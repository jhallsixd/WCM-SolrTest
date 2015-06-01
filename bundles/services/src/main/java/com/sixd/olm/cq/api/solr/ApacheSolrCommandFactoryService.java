package com.st.olm.cq.api.solr;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONObject;

import java.util.List;

/**
 * Created by jhall on 10/8/14.
 */

public interface ApacheSolrCommandFactoryService {
    SolrCommand createCommand(JSONObject obj, Resource res);

    SolrCommand createCommand(JSONObject obj, List<Resource> resources);

    SolrCommand createCommand(String str, Resource res);
}
