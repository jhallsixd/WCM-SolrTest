package com.st.olm.cq.api.solr;

import org.apache.sling.commons.json.JSONObject;

/**
 * Created by jhall on 10/8/14.
 */
public interface ApacheSolrUtil {
    Boolean getSyncStatus(JSONObject resourceObj);
    Boolean evalValidType(JSONObject resourceObj);
}