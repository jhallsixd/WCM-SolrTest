package com.st.olm.cq.api.solr.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.st.olm.cq.sling.models.solr.SolrFragment;
import com.st.olm.cq.sling.models.solr.SolrPage;
import com.st.olm.cq.sling.models.solr.SolrResource;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.ResourceResolver;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.st.olm.cq.api.solr.ApacheSolrResourceIndexer;

/**
 * Created by jhall on 10/28/14.
 */
public class ApacheSolrResourceIndexerImpl implements ApacheSolrResourceIndexer {

    private static final Logger log = LoggerFactory.getLogger(ApacheSolrResourceIndexerImpl.class);

    private Resource resource;
    private ValueMap resValueMap;
    private String resourceType;
    private SolrInputDocument solrDoc;
    private Boolean isDoc;
    private SolrResource fileResource;

    public SolrInputDocument index(Resource res, String type) throws IOException, SolrServerException {

        this.resource = res;
        this.resourceType = type;
        this.solrDoc = new SolrInputDocument();
        this.isDoc = false;

        try {

            if (resourceType.toLowerCase().equals("st-site/components/pages/base")) {
                SolrPage indexResource = null;
                indexResource = this.resource.adaptTo(SolrPage.class);
                this.solrDoc = indexResource.getSolrDoc();
            }

            if (resourceType.toLowerCase().equals("st-ccc/components/pages/fragment")) {
                SolrFragment indexResource = null;
                indexResource = this.resource.adaptTo(SolrFragment.class);
                this.solrDoc = indexResource.getSolrDoc();
            }

            if (resourceType.toLowerCase().equals("st-ccc/components/pages/resource")) {
                SolrResource indexResource = null;
                indexResource = this.resource.adaptTo(SolrResource.class);
                this.solrDoc = indexResource.getSolrDoc();
                this.isDoc = indexResource.isDocument;
            }

        } catch (Exception e) {
            log.error("ApacheSolrResourceIndexerImpl.convert exception", e);
        }

        return this.solrDoc;
    }

    public JSONArray getFields(Resource res, String type) {

        this.resource = res;
        if (type == null) {
            this.resourceType = getType(res);
        } else {
            this.resourceType = type;
        }
        this.isDoc = false;
        JSONArray fields = null;

        try {

            if (resourceType.toLowerCase().equals("st-site/components/pages/base")) {
                SolrPage indexResource = this.resource.adaptTo(SolrPage.class);
                fields = indexResource.getFields();
            }

            if (resourceType.toLowerCase().equals("st-ccc/components/pages/fragment")) {
                SolrFragment indexResource = this.resource.adaptTo(SolrFragment.class);
                fields = indexResource.getFields();
            }

            if (resourceType.toLowerCase().equals("st-ccc/components/pages/resource")) {
                SolrResource indexResource = this.resource.adaptTo(SolrResource.class);
                fields = indexResource.getFields();
                this.isDoc = indexResource.isDocument;
                this.fileResource = indexResource;
            }

        } catch (Exception e) {
            log.error("ApacheSolrResourceIndexerImpl.convert exception", e);
        }

        return fields;
    }

    public JSONArray getFields(List<Resource> resources) {
        JSONArray fields = new JSONArray();
        resources.stream().filter(res -> res != null).forEach(res -> {
            JSONArray jsonArray = this.getFields(res, null);
            if (jsonArray != null) {
                try {
                    fields.put(jsonArray.get(0));
                } catch (JSONException e) {
                    log.error(e.getMessage(), e);
                }
            }
        });
        return fields;
    }

    private String getType(Resource resource) {
        ResourceResolver resourceResolver = resource.getResourceResolver();
        PageManager pm = resourceResolver.adaptTo(PageManager.class);
        Page currentPage = pm.getContainingPage(this.resource);
        return currentPage.getContentResource().getResourceType();
    }

    public Boolean isDocument() {
        return this.isDoc;
    }

    public String getFilesAttributes() {
        String attrStr = "";
        try {
            attrStr = this.fileResource.getFileAttributes().toString();
        } catch (Exception e) {
            log.error("ApacheSolrResourceIndexerImpl.convert exception", e);
        }
        return attrStr;
    }

    public InputStream getFileIS() {
        InputStream is = this.fileResource.getFileIS();
        return is;
    }

    public String getFileContentType() {
        String contentType = this.fileResource.getFileContentType();
        return contentType;
    }

    public String getFileName() {
        String fileName = this.fileResource.getFileName();
        return fileName;
    }

}
