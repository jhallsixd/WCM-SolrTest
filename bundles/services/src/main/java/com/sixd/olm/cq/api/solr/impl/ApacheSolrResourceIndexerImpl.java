package com.sixd.olm.cq.api.solr.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.sixd.olm.cq.sling.models.solr.SolrPage;
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
import com.sixd.olm.cq.api.solr.ApacheSolrResourceIndexer;
import java.util.*;

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
    public Map<String, String> solrSettingsMap;

    public SolrInputDocument index(Resource res, String type, Map<String, String> settingsMap ) throws IOException, SolrServerException {

        this.resource = res;
        this.resourceType = type;
        this.solrDoc = new SolrInputDocument();
        this.isDoc = false;
        this.solrSettingsMap = settingsMap;

        try {
            String sitePath = this.solrSettingsMap.get("sitepath");
            if (resourceType.toLowerCase().contains(sitePath)) {
                SolrPage indexResource = null;
                indexResource = this.resource.adaptTo(SolrPage.class);
                this.solrDoc = indexResource.getSolrDoc();
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

            if (resourceType.toLowerCase().equals("solr/components/pages/base") || resourceType.toLowerCase().equals("solr/components/pages/home") || resourceType.toLowerCase().equals("solr/components/pages/static")) {
                SolrPage indexResource = this.resource.adaptTo(SolrPage.class);
                fields = indexResource.getFields();
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

}
