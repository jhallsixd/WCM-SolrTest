package com.st.olm.cq.api.solr.cmds;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.result.SearchResult;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jhall on 10/8/14.
 */
public class ScanResourcesCommand extends BaseSolrCommand implements SolrCommand {
    private QueryManager queryManager;
    private JSONObject cmdParam;
    private HttpSolrServer server;
    public ApacheSolrConfiguration solrConfig;
    public Map<String, String> solrSettingsMap;

    private static final Logger log = LoggerFactory.getLogger(ScanResourcesCommand.class);

    /**
     * Instantiates an instance of GetSearchCommand
     *
     * @param params JSONObject with command parameters
     */
    public ScanResourcesCommand(JSONObject params, ApacheSolrConfiguration solrConfiguration, Resource res){
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
        this.server = super.getServer();
        try {
            this.scan();
        } catch (Exception e){
            log.error("ScanResourcesCommand.execute method threw an exception", e);
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

    public void scan () {
        try {
            // TODO: query the jcr to find resources that were not set as indexed by the event listener

            /*
            long start = System.currentTimeMillis();

            // create query description as hash map (simplest way, same as form post)
            Map<String, String> map = new HashMap<String, String>();
            map.put("path", "/content/client/en");
            map.put("type", "cq:Page");

            try {
                Session session = repository.loginAdministrative(null);
                Query query = builder.createQuery(PredicateGroup.create(map), session);
                query.setHitsPerPage(0);
                SearchResult result = query.getResult();

                log.info("Hits: " + result.getHits().size());
                log.info("total Matches: " + result.getTotalMatches());
                log.info("Start Index: " + result.getStartIndex());
            } catch (RepositoryException ex) {
                log.error("Failed to get the session", ex);
            }
            long end = System.currentTimeMillis();
            log.info("Total time in mili-seconds is: " + (end - start));

            */
            //this.jsonResult.put("resources", resourcesObj);

        } catch (Exception e){
            log.error("ScanResourcesCommand.scan method threw an exception", e);
        } finally {

        }
    }
}
