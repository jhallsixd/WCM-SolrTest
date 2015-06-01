package com.sixd.olm.cq.api.solr.cmds;

import com.sixd.olm.cq.api.SharedConstants;
import com.sixd.olm.cq.api.solr.SolrCommand;
import com.sixd.olm.cq.api.solr.conf.ApacheSolrConfiguration;
import com.sixd.olm.cq.api.solr.impl.ApacheSolrResourceIndexerImpl;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.io.IOUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.jcr.api.SlingRepository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SignatureException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.jcr.query.QueryManager;
import java.util.*;

import org.apache.sling.api.resource.ResourceResolver;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


/**
 * Created by jhall on 10/8/14.
 */
public class IndexResourceCommand extends BaseSolrCommand implements SolrCommand {
    private SlingRepository repository;
    private ResourceResolverFactory resolverFactory;
    private QueryManager queryManager;
    private JSONObject cmdParam;
    private Resource resource;
    private List<Resource> resources;
    private ApacheSolrResourceIndexerImpl indexer;
    private String type;
    private String url;
    private Page currentPage;
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    private ApacheSolrConfiguration apacheSolrConfiguration;
    private HttpSolrServer server;
    public Map<String, String> solrSettingsMap;

    private static final Logger log = LoggerFactory.getLogger(IndexResourceCommand.class);

    public IndexResourceCommand(ApacheSolrConfiguration solrConfiguration, Resource res) {
        this.resource = res;
        this.apacheSolrConfiguration = solrConfiguration;
        this.indexer = new ApacheSolrResourceIndexerImpl();
        if (null != res) {
            ResourceResolver resourceResolver = this.resource.getResourceResolver();
            PageManager pm = resourceResolver.adaptTo(PageManager.class);
            this.currentPage = pm.getContainingPage(this.resource);
            this.type = this.currentPage.getContentResource().getResourceType();
        }
        this.solrSettingsMap = this.apacheSolrConfiguration.getEnvironmentMap();
    }

    public IndexResourceCommand(ApacheSolrConfiguration solrConfiguration, List<Resource> resources) {
        this.resources = resources;
        this.apacheSolrConfiguration = solrConfiguration;
        this.indexer = new ApacheSolrResourceIndexerImpl();
        this.solrSettingsMap = this.apacheSolrConfiguration.getEnvironmentMap();
    }

    /**
     * Invokes the command to return search information
     *
     * @return true on success; false otherwise
     */
    public boolean execute() {
        boolean retVal = true;
        try {
            if (null != this.resource ) {
                this.populate(type);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return retVal;
    }

    /**
     * Validates the command - in this instance always returns true
     *
     * @return true always
     */
    public boolean validate() {
        return true;
    }

    /**
     * This method returns the account information in a json formatted string
     *
     * @return JSON formatted string with requested information
     */
    public String getResult() {
        return super.jsonResult.toString();
    }

    /**
     * This method returns the account information in a JSON object
     *
     * @return JSONObject containing requested information
     */
    public JSONObject getResultObject() {
        return this.jsonResult;
    }

    public void populate(String type) throws IOException, SolrServerException {
        try {
            this.solrSettingsMap = this.apacheSolrConfiguration.getEnvironmentMap();

            if (this.solrSettingsMap.get("service").equals("solrj")) {
                commitToSolrJ(type);
            } else {
                commitToSolrService(type);
            }
        } catch (Exception e) {
            log.error("IndexResourceCommand.populate exception", e);
        }
    }

    public String calculateRFC2104HMAC(String data, String key) throws java.security.SignatureException {
        String result;
        try {
            // get an hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);

            // get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);

            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes());

            // base64-encode the hmac
            Base64.Encoder encoder = Base64.getEncoder();
            result = encoder.encodeToString(rawHmac);

        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

    public void commitToSolrService(String type) {
        try {

            // setup the url for post
            String env = this.solrSettingsMap.get("environment");
            String port = this.solrSettingsMap.get("port");
            String path = this.solrSettingsMap.get("path");
            this.url = env + ":" + port + "/" + path;

            HttpClient client;
            String apiResponse = "";

            client = new HttpClient();
            PostMethod post = new PostMethod(this.url);

            post.addRequestHeader("Accept", "application/json");
            post.addRequestHeader("http.protocol.content-charset", "UTF-8");

            // set up the data json object to send to solr via post
            JSONObject dataObj = new JSONObject();

            // get the fields from the resource to be indexed
            JSONArray fields = null;
            if (this.resources != null && !this.resources.isEmpty()) {
                log.info("IndexResourceCommand:commitToSolrService:multipleResources " + this.resources);
                fields = indexer.getFields(this.resources);
            } else {
                log.info("IndexResourceCommand:commitToSolrService:singleResource " + this.resource);
                fields = indexer.getFields(this.resource, type);
            }
            dataObj.put("jp", fields);
            dataObj.put("en", fields);
            dataObj.put("cn", fields);

            log.info("IndexResourceCommand:commitToSolrService:objectToSend " + dataObj.toString());

            NameValuePair[] data = new NameValuePair[]{new NameValuePair("data", dataObj.toString())};

            post.addParameters(data);

            client.executeMethod(post);

            apiResponse = post.getResponseBodyAsString();

        } catch (Exception e) {
            log.error("commit to solr exception", e);
        }
    }

    public void commitToSolrJ(String type) {
        try {

            SolrInputDocument doc = indexer.index(this.resource, type);
            log.info("committing doc to server " + doc.toString());
            String core = this.solrSettingsMap.get("core");
            writeToSolrServer(core, doc);

        } catch (Exception e) {
            log.error("commit to solr exception", e);
        }
    }

    public void writeToSolrServer(String core, SolrInputDocument doc) throws IOException, SolrServerException {

        try {
            HttpSolrServer server = getServer(core);
            UpdateResponse resp = server.add(doc);

            UpdateResponse commitResponse = server.commit();
            if (commitResponse.getStatus() == 500) {
                this.jsonResult = new JSONObject("{'commit':'" + commitResponse.getStatus() + "'}");
                log.error("Failed to commit the document to the SOLR server. Server returned status code '" + commitResponse.getStatus() + "'.");
            } else {
                this.jsonResult = new JSONObject("{'commit':'success'}");
                log.info("IndexResourceCommand committed");
            }
        } catch (Exception e) {
            log.error("Unable to write to solr: ", e);
        }
    }

    public HttpSolrServer getServer(String core) {
        HttpSolrServer _server = null;
        try {

            String env = this.solrSettingsMap.get("environment");
            String port = this.solrSettingsMap.get("port");
            String path = this.solrSettingsMap.get("path");
            String _instance = env + ":" + port + "/" + path + "/" + core;
            _server = new HttpSolrServer(_instance);

        } catch (Exception e) {
            log.error("Unable to connect to solr: ", e);
        }
        return _server;
    }
}
