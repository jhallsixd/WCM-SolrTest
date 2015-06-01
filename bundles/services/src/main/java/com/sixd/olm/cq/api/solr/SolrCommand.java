package com.st.olm.cq.api.solr;

import org.apache.sling.commons.json.JSONObject;

/**
 * Created by jhall on 10/8/14.
 */

public interface SolrCommand {
    boolean execute();

    boolean validate();

    String getResult();

    JSONObject getResultObject();
}

