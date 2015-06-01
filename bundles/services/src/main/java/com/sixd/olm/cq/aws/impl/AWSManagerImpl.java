package com.st.olm.cq.aws.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Dictionary;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.st.olm.cq.api.aws.AWSManager;

@Component(name = "com.st.olm.cq.aws.impl.AWSManagerImpl", immediate = true, metatype = true)
@Service
public class AWSManagerImpl implements AWSManager {

	/**
	 * Constant for the AWS Access Key Field
	 */
	@Property(label = "AWS Access Key")
	public static final String AWS_ACCESS_KEY = "access.key";

	/**
	 * Constant for the AWS Secret Key Field
	 */
	@Property(label = "AWS Secret Key")
	public static final String AWS_SECRET_KEY = "secret.key";

	/**
	 * Constant for the S3 Bucket Name Field
	 */
	@Property(label = "S3 Bucket Name")
	public static final String S3_BUCKET_NAME = "bucket.name";

	/**
	 * Constant for the S3 Path Prefix Field
	 */
	@Property(label = "S3 Path Prefix")
	public static final String S3_PATH_PREFIX = "path.prefix";
	
	private AWSCredentials creds = null;

	private ComponentContext context;

	private String bucketName = null;

	private String prefix;
	
	private boolean ignorePrefix = false;
	
	/**
	 * The SLF4J Logger
	 */
	private static final Logger log = LoggerFactory
			.getLogger(AWSManagerImpl.class);

	protected void activate(final ComponentContext componentContext) {
		log.info("activate");
		this.context = componentContext;
		Dictionary<?, ?> props = context.getProperties();
		try {
			String accessKey = PropertiesUtil.toString(
					props.get(AWS_ACCESS_KEY), null);
			String secretKey = PropertiesUtil.toString(
					props.get(AWS_SECRET_KEY), null);
			creds = new BasicAWSCredentials(accessKey, secretKey);
			log.info("Loaded new credentials {}", creds.getAWSAccessKeyId());

			bucketName = PropertiesUtil.toString(props.get(S3_BUCKET_NAME),
					null);
			prefix = PropertiesUtil.toString(props.get(S3_PATH_PREFIX), null);
			log.info("Loaded S3 Bucket Name: {}", bucketName);
		} catch (IllegalArgumentException iae) {
			log.warn("Unable to load the credentials from component context "
					+ context, iae);
		}
	}

	public String getBucketName() {
		return bucketName;
	}

	public AWSCredentials getCreds() {
		return creds;
	}
	
	@Override
	public boolean fileExists(String fileName) {

		log.info("Attempting to access S3 Client");

		AmazonS3 s3Client = new AmazonS3Client(creds);
		
		   try {
			   log.debug("Checking if file or folder exists {}", fileName);
			   s3Client.getObjectMetadata(bucketName, fileName); 
		    } catch(AmazonServiceException e) {
		    	log.warn("File or folder not found {}", fileName);
		        return false;
		    } catch(Exception e){
		    	log.error("Failed to find file ",e);
		    	return false;
		    }
		   	log.debug("{} was found",fileName);
		    return true;

	}

	@Override
	public File getS3File(String fileName) throws IOException {

		log.trace("getS3File with fileName {}", fileName);

		S3ObjectInputStream is = null;
		FileOutputStream fos = null;
		File s3File = null;

		AmazonS3 s3Client = new AmazonS3Client(creds);

		try {
			if (s3Client.doesBucketExist(bucketName)) {

				log.debug(bucketName + " exists");
				ObjectListing objectListing = null;
				if(!ignorePrefix){
					objectListing = s3Client.listObjects(new ListObjectsRequest()
							.withBucketName(bucketName).withPrefix(prefix));
				} else {
					objectListing = s3Client.listObjects(new ListObjectsRequest()
							.withBucketName(bucketName));
				}

				boolean hasMoreResults = false;
				log.trace("objectListing.isTruncated: {}", objectListing.isTruncated());
				do {
					hasMoreResults = objectListing.isTruncated();
					log.trace("hasMoreResults: {}", String.valueOf(hasMoreResults));

					for (S3ObjectSummary s3ObjectSummary : objectListing.getObjectSummaries()) {
						String objectName = s3ObjectSummary.getKey();
						log.trace("Checking: " + objectName);
						if (s3ObjectSummary.getKey().contains(fileName)) {
							S3Object s3object = s3Client
									.getObject(new GetObjectRequest(s3ObjectSummary
											.getBucketName(), s3ObjectSummary
											.getKey()));
							log.debug("Found file: {} Content-Type: {}", fileName,
									s3object.getObjectMetadata().getContentType());
							is = s3object.getObjectContent();
							hasMoreResults = false;
							break;
						}
					}

					// test for more results
					if(hasMoreResults) {
						log.trace("objectListing says there are more files to check");
						objectListing = s3Client.listNextBatchOfObjects(objectListing);
					}
				} while(hasMoreResults);

				if (is != null) {
					log.info("Copying S3 object to file at {}",
							System.getProperty("java.io.tmpdir") + "/"
									+ fileName + ".tar.gz");
					s3File = new File(System.getProperty("java.io.tmpdir")
							+ "/" + fileName + ".tar.gz");
					fos = new FileOutputStream(s3File);
					IOUtils.copy(is, fos);
				} else {
					throw new IOException("Unable to find file matching "
							+ fileName);
				}
			} else {
				throw new IOException("Bucket " + bucketName
						+ " does not exist");
			}
		} catch (AmazonServiceException ase) {
			log.error("Caught an AmazonServiceException, which"
					+ " means your request made it "
					+ "to Amazon S3, but was rejected with an error response"
					+ " for some reason.");
			log.error("Error Message:    {}", ase.getMessage());
			log.error("HTTP Status Code: {}", ase.getStatusCode());
			log.error("AWS Error Code:   ", ase.getErrorCode());
			log.error("Error Type:     {}  ", ase.getErrorType());
			log.error("Request ID:     {}  ", ase.getRequestId());
			throw new IOException("Service exception making call to AWS", ase);
		} catch (AmazonClientException ace) {
			log.error("Caught an AmazonClientException, which means"
					+ " the client encountered "
					+ "an internal error while trying to "
					+ "communicate with S3, "
					+ "such as not being able to access the network.");
			log.error("Error Message: " + ace.getMessage());
			throw new IOException("Client exception making call to AWS", ace);
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(fos);
		}

		return s3File;
	}
	
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public void setCreds(AWSCredentials creds) {
		this.creds = creds;
	}

	public boolean createPath(String pathToCreate){
		log.info("Creating path {} in S3",pathToCreate);
		boolean pathExists = false;
			InputStream emptyContent = null;
			try {
				ObjectMetadata metadata = new ObjectMetadata();
				metadata.setContentLength(0);
				emptyContent = new ByteArrayInputStream(new byte[0]);
		        PutObjectRequest request = new PutObjectRequest(bucketName, 
		        		pathToCreate,emptyContent, metadata);
		     	
		        TransferManager tx = new TransferManager(creds);
		          
		        Upload upload = tx.upload(request);

		        upload.waitForCompletion();

		        if(upload.isDone()){
		        	pathExists = true;
		        }
				
			}catch (AmazonServiceException ase) {
		        	 log.error("Caught an AmazonServiceException, which " +
		            		"means your request made it " +
		                    "to Amazon S3, but was rejected with an error response" +
		                    " for some reason.");
		            log.error("Error Message:    " + ase.getMessage());
		            log.error("HTTP Status Code: " + ase.getStatusCode());
		            log.error("AWS Error Code:   " + ase.getErrorCode());
		            log.error("Error Type:       " + ase.getErrorType());
		            log.error("Request ID:       " + ase.getRequestId());
		        } catch (AmazonClientException ace) {
		        	log.error("Caught an AmazonClientException, which " +
		            		"means the client encountered " +
		                    "an internal error while trying to " +
		                    "communicate with S3, " +
		                    "such as not being able to access the network.");
		            log.error("Error Message: " + ace.getMessage());
		        } catch (InterruptedException e) {
		        	log.error("Failed to upload file. Upload was interrupted ", e);
				}finally{
				IOUtils.closeQuietly(emptyContent);
			}
			log.debug("Path created: {}",pathExists);
		return pathExists;
		
	}

	@Override
	public void uploadS3File(File file, String fileName, String path) {
		 try {
			 String key = path + fileName;
		         log.debug("\n Uploading a new object to S3 from a file:  {}",key);
		         PutObjectRequest request = new PutObjectRequest(bucketName, key, file);
		
		         TransferManager tx = new TransferManager(creds);
		          
		         final Upload upload = tx.upload(request);
		          
		         upload.addProgressListener(new ProgressListener() {
		        	    public void progressChanged(ProgressEvent progressEvent) {
		        	        log.trace("{}%", upload.getProgress().getPercentTransferred());
		        	 
		        	        if (progressEvent.getEventCode() ==
		        	        		ProgressEvent.COMPLETED_EVENT_CODE) {
		        	            log.trace("Upload complete!!!");
		        	        }
		        	    }
		        	});
		        	
		        upload.waitForCompletion();
	            	            
	         } catch (AmazonServiceException ase) {
	        	 log.error("Caught an AmazonServiceException, which " +
	            		"means your request made it " +
	                    "to Amazon S3, but was rejected with an error response" +
	                    " for some reason.");
	            log.error("Error Message:    " + ase.getMessage());
	            log.error("HTTP Status Code: " + ase.getStatusCode());
	            log.error("AWS Error Code:   " + ase.getErrorCode());
	            log.error("Error Type:       " + ase.getErrorType());
	            log.error("Request ID:       " + ase.getRequestId());
	        } catch (AmazonClientException ace) {
	        	log.error("Caught an AmazonClientException, which " +
	            		"means the client encountered " +
	                    "an internal error while trying to " +
	                    "communicate with S3, " +
	                    "such as not being able to access the network.");
	            log.error("Error Message: " + ace.getMessage());
	        } catch (InterruptedException e) {
	        	log.error("Failed to upload file. Upload was interrupted ", e);
			} catch(UnknownError ue){
				log.error(ue.getMessage(),ue);
			}
	}

}
