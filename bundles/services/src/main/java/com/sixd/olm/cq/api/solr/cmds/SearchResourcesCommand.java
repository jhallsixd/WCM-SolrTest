package com.st.olm.cq.api.solr.cmds;

import com.st.olm.cq.api.solr.ApacheSolrUtil;
import com.st.olm.cq.api.solr.SolrCommand;
import com.st.olm.cq.api.solr.conf.ApacheSolrConfiguration;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.solr.*;

import javax.jcr.query.QueryManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jhall on 10/8/14.
 */
public class SearchResourcesCommand extends BaseSolrCommand implements SolrCommand {
    private QueryManager queryManager;
    private JSONObject cmdParam;
    private HttpSolrServer server;
    public ApacheSolrConfiguration solrConfig;
    public Map<String, String> solrSettingsMap;

    private static final Logger log = LoggerFactory.getLogger(SearchResourcesCommand.class);

    /**
     * Instantiates an instance of GetSearchCommand
     *
     * @param params JSONObject with command parameters
     *
     */
    public SearchResourcesCommand(JSONObject params, ApacheSolrConfiguration solrConfiguration, Resource res){
        this.cmdParam = params;
        this.solrConfig = solrConfiguration;
    }

    /**
     * Invokes the command to return search information
     *
     * @return true on success; false otherwise
     */
    public boolean execute(){
        boolean retVal = true;
        try {
            JSONObject queryObj = new JSONObject(cmdParam.getString("query"));
            this.query(queryObj);
        } catch (Exception e){
            log.error("SearchResourcesCommand.execute method threw an exception", e);
        } finally {
            //
        }
        return retVal;
    }

    /**
     * Validates the command - in this instance always returns true
     * @return true always
     */
    public boolean validate(){
        boolean b = false;
        if(this.cmdParam.has("query")){
          b = true;
        }
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

    public void query (JSONObject obj) throws IOException, SolrServerException {
        SolrDocumentList results = null;
        SolrQuery query = new SolrQuery();
        JSONArray queryParamArray = null;
        log.info(obj.toString());
        if(obj.has("params")){
            try{
                queryParamArray = new JSONArray(obj.getString("params"));
            } catch (Exception e){
                //
            } finally {
                //
            }
        }

        try {
            query.setQuery(this.setQueryStringParams(queryParamArray));
        } catch (Exception e){
            log.error("SearchResourceCommand.query method threw an exception", e);
        } finally {

        }

        try {
            QueryResponse response = this.server.query(query);
            results = response.getResults();
            this.jsonResult = new JSONObject();
            Map<Integer, Object> solrDocMap = new HashMap<Integer, Object>();
            int counter = 1;
            for(Map singleDoc : results)
            {
                solrDocMap.put(counter, new JSONObject(singleDoc));
                counter++;
            }
            this.jsonResult.put("docs", solrDocMap);
        } catch (Exception e){
            log.error("SearchResourceCommand.query method threw an exception", e);
        } finally {

        }
    }

    private String setQueryStringParams (JSONArray queryParamArray) {
        String str = "";
        try {
            for (int i = 0; i < queryParamArray.length(); i++) {
                JSONObject obj = queryParamArray.getJSONObject(i);
                log.info(obj.toString());
                if(obj.has("text")) {
                    str = obj.getString("text");
                }
            }
        } catch (Exception e){
            log.error("SearchResourceCommand.setQueryStringParam Exception", e);
        } finally {

        }
        return str;
    }

    private String setQueryFilterParams (JSONArray queryParamArray) {
        String str = "";
        JSONArray filters = new JSONArray();
        try {
            for (int i = 0; i < queryParamArray.length(); i++) {
                JSONObject obj = queryParamArray.getJSONObject(i);
                if(obj.has("filters")) {
                    filters = new JSONArray(obj.getString("filters"));
                    // TODO: loop thru filters to build string
                }
            }
        } catch (Exception e){
            log.error("SearchResourceCommand.setQueryStringParam Exception", e);
        } finally {

        }
        return str;
    }

    private String setQueryFieldsParams (JSONArray queryParamArray) {
        String str = "";
        JSONArray fields = new JSONArray();
        try {
            for (int i = 0; i < queryParamArray.length(); i++) {
                JSONObject obj = queryParamArray.getJSONObject(i);
                if(obj.has("fields")) {
                    fields = new JSONArray(obj.getString("fields"));
                    // TODO: loop thru filters to build string
                }
            }
        } catch (Exception e){
            log.error("SearchResourceCommand.setQueryStringParam Exception", e);
        } finally {

        }
        return str;
    }

    private String setQuerySetParams (JSONArray queryParamArray){
        String str = "";
        JSONArray sets = new JSONArray();
        try {
            for (int i = 0; i < queryParamArray.length(); i++) {
                JSONObject obj = queryParamArray.getJSONObject(i);
                if(obj.has("set")) {
                    sets = new JSONArray(obj.getString("set"));
                    // TODO: loop thru filters to build string
                }
            }
        } catch (Exception e){
            log.error("SearchResourceCommand.setQueryStringParam Exception", e);
        } finally {

        }
        return str;
    }
}
