package com.sixd.olm.cq.api.solr;

import org.apache.sling.api.resource.Resource;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.*;

/**
 * Created by jhall on 10/28/14.
 */
public interface ApacheSolrResourceIndexer {
    SolrInputDocument index(Resource res, String type, Map<String, String> settingsMap) throws IOException, SolrServerException;
    Boolean isDocument();
}
