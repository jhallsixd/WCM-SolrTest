package com.sixd.olm.cq.api.solr.cmds;

import com.sixd.olm.cq.api.solr.ApacheSolrUtil;
import com.sixd.olm.cq.api.solr.SolrCommand;
import com.sixd.olm.cq.api.solr.conf.ApacheSolrConfiguration;
import com.sixd.olm.cq.sling.models.solr.SolrPage;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.query.QueryManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

/**
 * Created by jhall on 10/8/14.
 */
public class RemoveResourceCommand extends BaseSolrCommand implements SolrCommand {
    private SlingRepository repository;
    private ResourceResolverFactory resolverFactory;
    private QueryManager queryManager;
    private JSONObject cmdParam;
    private HttpSolrServer server;
    private Resource resource;
    private String type;
    private Page currentPage;
    public String id;

    public ApacheSolrConfiguration apacheSolrConfiguration;
    public Map<String, String> solrSettingsMap;

    private static final Logger log = LoggerFactory.getLogger(RemoveResourceCommand.class);

    public RemoveResourceCommand(ApacheSolrConfiguration solrConfiguration, Resource res){
        this.resource = res;
        this.apacheSolrConfiguration = solrConfiguration;
        ResourceResolver resourceResolver = this.resource.getResourceResolver();
        PageManager pm = resourceResolver.adaptTo(PageManager.class);
        this.currentPage = pm.getContainingPage(this.resource);
        this.type = this.currentPage.getContentResource().getResourceType();
        this.id = "";
        this.solrSettingsMap = this.apacheSolrConfiguration.getEnvironmentMap();
    }

    /**
     * Invokes the command to return search information
     *
     * @return true on success; false otherwise
     */
    public boolean execute(){
        boolean retVal = true;
        try {
            this.prune();
        } catch (Exception e){
            log.error(e.getMessage());
        } finally {

        }
        return retVal;
    }

    /**
     * Validates the command - in this instance always returns true
     * @return true always
     */
    public boolean validate(){
        boolean b = false;
        b = true;
        return b;
    }

    /**
     * This method returns the account information in a json formatted string
     * @return JSON formatted string with requested information
     */
    public String getResult(){
        return super.jsonResult.toString();
    }

    /**
     * This method returns the account information in a JSON object
     * @return JSONObject containing requested information
     */
    public JSONObject getResultObject(){
        return this.jsonResult;
    }

    public void prune () throws IOException, SolrServerException {

        if(this.type.toLowerCase().contains(this.solrSettingsMap.get("sitepath"))) {
            SolrPage indexResource = null;
            indexResource = this.resource.adaptTo(SolrPage.class);
            this.id = indexResource.getID().toString();
        }

        try {

            if(this.solrSettingsMap.get("service").equals("solrj")) {
                String core = this.solrSettingsMap.get("core");
                removeIndexSolrj(core, this.id);
            } else {
                removeIndexService(this.id);
            }

        } catch (Exception e){
            log.error("RemoveResourceCommand.prune to solr exception", e);
        } finally {

        }
    }

    public void removeIndexSolrj (String core, String id){
        HttpSolrServer server = getServer(core);
        try {
            server.deleteById(id);
            server.commit();
        } catch (Exception e){
            log.error("RemoveResourceCommand.removeIndex to solr exception", e);
        } finally {

        }
    }


    public void removeIndexService (String id){

        try {
            String env = this.solrSettingsMap.get("environment");
            String port = this.solrSettingsMap.get("port");
            String path = this.solrSettingsMap.get("path");
            String core = this.solrSettingsMap.get("core");
            String url = env + ":" + port + "/delete";

            HttpClient client;
            String apiResponse = "";

            client = new HttpClient();
            PostMethod post = new PostMethod(url);

            post.addRequestHeader("Accept", "application/json");
            post.addRequestHeader("http.protocol.content-charset", "UTF-8");

            // set up the data json object to send to solr via post
            JSONObject dataObj = new JSONObject();

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", this.id);

            JSONArray jsonID = new JSONArray();

            jsonID.put(jsonObj);

            dataObj.put(core, jsonID);

            NameValuePair[] data = new NameValuePair[] { new NameValuePair("delete", dataObj.toString()) };

            post.addParameters(data);

            client.executeMethod(post);

            apiResponse = post.getResponseBodyAsString();

        } catch (Exception e){
            log.error("commit to solr exception", e);
        } finally {

        }
    }

    public HttpSolrServer getServer(String core){
        HttpSolrServer _server = null;
        try{

            String env = this.solrSettingsMap.get("environment");
            String port = this.solrSettingsMap.get("port");
            String path = this.solrSettingsMap.get("path");
            String _instance = env + ":" + port + "/" + path + "/" + core;
            _server = new HttpSolrServer(_instance);
        }catch(Exception e){
            log.error("Unable to connect to solr: ", e);
        }finally{

        }
        return _server;
    }
}
