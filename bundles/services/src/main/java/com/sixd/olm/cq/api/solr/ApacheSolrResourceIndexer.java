package com.st.olm.cq.api.solr;

import org.apache.sling.api.resource.Resource;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

/**
 * Created by jhall on 10/28/14.
 */
public interface ApacheSolrResourceIndexer {
    SolrInputDocument index(Resource res, String type) throws IOException, SolrServerException;
    Boolean isDocument();
}
