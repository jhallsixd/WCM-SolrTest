package com.sixd.olm.cq.sling.models.solr;

import com.day.cq.tagging.Tag;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jhall on 2/23/15.
 */

@Model(adaptables=Resource.class)
public class SolrPage {

    public String description;
    public String title;
    public String type;
    public String link;
    public Integer id;
    public String path;
    public String link_parent;
    public String parent_id;
    public SolrInputDocument solrDoc;
    private String DOMAIN_URL;

    public final Resource resource;

    private static final Logger log = LoggerFactory.getLogger(SolrPage.class);

    public SolrPage(Resource resource) {
        this.resource = resource;
    }

    @PostConstruct
    protected void init() throws Exception {

        DOMAIN_URL = "http://www.mydomain.com";
        this.link_parent = DOMAIN_URL + this.resource.getParent().getPath();
        this.path = this.resource.getPath();
        this.link = DOMAIN_URL + this.path;
        this.id = this.path.hashCode();
        this.type = "page";
        this.title = this.resource.getName();

        ResourceResolver resourceResolver = this.resource.getResourceResolver();
        this.solrDoc = new SolrInputDocument();

    }

    public JSONArray getFields (){
        JSONArray fieldsArray = new JSONArray();

        try {

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", this.path.hashCode());
            //jsonObj.put("link", this.link);
            //jsonObj.put("type", this.type);
            //jsonObj.put("link_parent", this.link_parent);
            jsonObj.put("title", this.title);

            fieldsArray.put(jsonObj);
        } catch (JSONException e){
            log.error(e.getMessage(), e);
        }
        return fieldsArray;
    }

    public SolrInputDocument generateDoc (){
        try {
            JSONArray fields = getFields();
            for (int i = 0; i < fields.length(); i++) {
                JSONObject obj = fields.getJSONObject(i);
                Iterator<?> keys = obj.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    this.solrDoc.addField(key, obj.get(key));
                }
            }
        } catch (JSONException e) {
            log.error(e.getMessage(), e);
        }
        return this.solrDoc;
    }

    public SolrInputDocument getSolrDoc (){
        this.solrDoc = this.generateDoc();
        return this.solrDoc;
    }

    public Integer getID(){
        return this.id.hashCode();
    }
}
