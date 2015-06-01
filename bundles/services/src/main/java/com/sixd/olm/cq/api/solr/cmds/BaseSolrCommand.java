package com.st.olm.cq.api.solr.cmds;

import com.st.olm.cq.api.solr.conf.ApacheSolrConfiguration;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

/**
 * Created by jhall on 10/8/14.
 */
public abstract class BaseSolrCommand {
    private static final Logger log = LoggerFactory.getLogger(BaseSolrCommand.class);
    protected JSONObject jsonResult = new JSONObject();

    public ApacheSolrConfiguration solrConfig;

    private HttpSolrServer server;

    public Map<String, String> solrSettingsMap;

    private String env;
    private String port;
    private String instance;
    private String path;
    private String url;

    public HttpSolrServer getServer() {
        HttpSolrServer _server = null;
        try {
            //this.server = new HttpSolrServer("http://localhost:8983/solr");
            this.solrSettingsMap = this.solrConfig.getEnvironmentMap();

            this.env = this.solrSettingsMap.get("environment");
            this.port = this.solrSettingsMap.get("port");
            this.path = this.solrSettingsMap.get("path");
            //this.instance = this.env + ":" + this.port + "/" + this.path;
            /*
            this.env = "http://localhost";
            this.port = "8983";
            this.path = "solr";
            */
            String _instance = this.env + ":" + this.port + "/" + this.path + "/collection1";
            _server = new HttpSolrServer(_instance);
        } catch (Exception e) {
            log.error("Unable to connect to solr: ", e);
        }
        return _server;
    }

    public String getURL() {
        this.solrSettingsMap = this.solrConfig.getEnvironmentMap();
        this.env = this.solrSettingsMap.get("environment");
        this.port = this.solrSettingsMap.get("port");
        this.path = this.solrSettingsMap.get("path");
        this.url = this.env + ":" + this.port + "/" + this.path;
        return this.url;
    }

    /**
     * Utility method that updates the jsonResult object to add the "result" field.  It will be set to "success" when
     * retVal is true, and "failure" when retval is false.  This method will log, but ignore json exceptions that may
     * be thrown.
     * <p>
     * This method is intended to be called once for each command at the end of execute.
     *
     * @param retVal boolean that indicates whether or not the command succeeded or failed.
     */
    protected void updateJSONResultWithCmdExecuteResult(boolean retVal) {
        if (this.jsonResult == null) {
            // shouldn't happen, but just in case
            this.jsonResult = new JSONObject();
        }

        try {
            String resultStr = "failure";
            if (retVal) {
                resultStr = "success";
            }

            this.jsonResult.put("result", resultStr);
        } catch (JSONException jsonException) {
            log.info("Unable to update JSON result: ", jsonException);
        }
    }

    /**
     * Utility method to set "resultMsg" field in JSONResults, note it will ignore the unlikely exception
     * that put may throw.
     *
     * @param message The message to set
     */
    protected void setJSONResultMsg(String message) {
        if (this.jsonResult == null) {
            this.jsonResult = new JSONObject();
        }

        try {
            this.jsonResult.put("resultMsg", message);
        } catch (JSONException jsonException) {
            log.info("Unable to update JSON result: ", jsonException);
        }
    }

    protected void bindApacheSolrConfiguration(
            ApacheSolrConfiguration paramApacheSolrDataConfiguration) {
        this.solrConfig = paramApacheSolrDataConfiguration;
    }

    protected void unbindApacheSolrDataConfiguration(
            ApacheSolrConfiguration paramApacheSolrDataConfiguration) {
        if (this.solrConfig == paramApacheSolrDataConfiguration)
            this.solrConfig = null;
    }

    public JSONObject getResourceObjByType(Resource res) {
        ValueMap resValueMap = res.adaptTo(ValueMap.class);
        //log.info("Trace ValueMap : " + resValueMap.toString());
        JSONObject resObj = new JSONObject();
        JSONArray resFields = new JSONArray();
        try {
            resObj.put("type", resValueMap.get("sling:resourceType", String.class));
            resObj.put("cat", resValueMap.get("sling:resourceType", String.class));
            resObj.put("name", resValueMap.get("sling:name", String.class));
            // TODO: determine the properties needed to be indexed
            resObj.put("fields", resFields);
        } catch (JSONException e) {
            log.info("BaseSolrCommand.getResourceObjByType ", e);
        }
        return resObj;
    }
}
