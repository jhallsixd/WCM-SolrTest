package com.st.olm.cq.sling.models.solr;

import com.day.cq.tagging.Tag;
import com.st.olm.cq.api.ccc.CCCAsset;
import com.st.olm.cq.api.ccc.CCCAssetManager;
import com.st.olm.cq.api.ccc.CCCResourceAsset;
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
    public String confidentiality;
    public String personalization;
    public String part_type;
    public String tree;
    public String vertical;
    public String company;
    public String department;
    public String region;
    public String rpn;
    public String cpn;
    public String parent_id;
    public String recommended;
    public ValueMap properties;
    public SolrInputDocument solrDoc;
    private String DOMAIN_URL;

    public final Resource resource;

    private static final Logger log = LoggerFactory.getLogger(SolrPage.class);

    public SolrPage(Resource resource) {
        this.resource = resource;
    }

    @PostConstruct
    protected void init() throws Exception {

        DOMAIN_URL = "";
        this.link_parent = DOMAIN_URL + this.resource.getParent().getPath().replace("/content/st_com/", "");
        this.path = this.resource.getPath();
        this.link = DOMAIN_URL + this.path.replace("/content/st_com/","");
        this.id = this.path.hashCode();
        this.type = "page";
        this.title = this.resource.getName();
        this.confidentiality = "public";
        this.part_type = "";
        this.tree = "";
        this.vertical = "";
        this.department = "";
        this.company = "";
        this.region = "";
        this.rpn = "";
        this.cpn = "";
        this.parent_id = "";
        this.recommended = "";
        this.properties = null;

        ResourceResolver resourceResolver = this.resource.getResourceResolver();
        CCCAssetManager cccAssetManager = resourceResolver.adaptTo(CCCAssetManager.class);
        CCCAsset<?> cccAsset = cccAssetManager.getCCCAsset(this.path);
        if(cccAsset.isResource()) {
            CCCResourceAsset resourceAsset = (CCCResourceAsset) cccAsset;
            this.properties = resourceAsset.getProperties();
            this.title = this.properties.get("jcr:title", "");
            this.confidentiality = this.properties.get("confidentiality", "public");
            this.personalization = this.properties.get("personalization", "public");
        }

        this.solrDoc = new SolrInputDocument();

    }

    public JSONArray getFields (){
        JSONArray fieldsArray = new JSONArray();

        try {

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", this.path.hashCode());
            jsonObj.put("link", this.link);

            if(!this.part_type.equals("")) {
                jsonObj.put("part_type", this.part_type);
            }

            jsonObj.put("type", this.type);
            jsonObj.put("link_parent", this.link_parent);
            jsonObj.put("title", this.title);
            jsonObj.put("title_man", this.title);

            if(!this.parent_id.equals("")) {
                jsonObj.put("parent_id", this.parent_id);
            }

            jsonObj.put("recommended", this.recommended);

            if(!this.tree.equals("")) {
                jsonObj.put("tree", this.tree);
            }

            jsonObj.put("confidentiality", this.confidentiality.toLowerCase());

            if(!this.confidentiality.toLowerCase().equals("public")) {

                if(!this.vertical.equals("")) {
                    jsonObj.put("vertical", this.vertical);
                }

                if(!this.company.equals("")) {
                    jsonObj.put("company", this.company);
                }

                if(!this.department.equals("")) {
                    jsonObj.put("department", this.department);
                }

                if(!this.region.equals("")) {
                    jsonObj.put("region", this.region);
                }
            }
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

    public Boolean evalPathForSubType (String path, String sub){
        Boolean contains = false;
        String[] pathElements = path.split("/");
        for (String m : pathElements) {
            if (m.equals(sub)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public void categorizePersonalizationTags(List<Tag> tags){

        String verticalTmp = "";
        String regionTmp = "";
        String departmentTmp = "";
        String companyTmp = "";

        for(Tag tag : tags) {
            String tagTitle = tag.getTitle();
            String tagPath = tag.getPath();

            if(evalPathForSubType(tagPath, "verticals")){
                verticalTmp = verticalTmp + ", " + tagTitle;
            }

            if(evalPathForSubType(tagPath, "channels")){

                if(evalPathForSubType(tagPath, "regions")){
                    regionTmp = regionTmp + ", " + tagTitle;
                }
                if(evalPathForSubType(tagPath, "departments")){
                    departmentTmp = departmentTmp + ", " + tagTitle;
                }

                if(!evalPathForSubType(tagPath, "regions") || !evalPathForSubType(tagPath, "departments")){
                    companyTmp = companyTmp + ", " + tagTitle;
                }
            }

            if(!verticalTmp.isEmpty()) {
                this.vertical = verticalTmp.substring(2, verticalTmp.length());
                if(verticalTmp.contains(",")){
                    this.vertical = '[' + verticalTmp + ']';
                }

            }
            if(!companyTmp.isEmpty()) {
                this.company = companyTmp.substring(2, companyTmp.length());
                if(companyTmp.contains(",")){
                    this.company = '[' + companyTmp + ']';
                }
            }
            if(!departmentTmp.isEmpty()) {
                this.department = departmentTmp.substring(2, departmentTmp.length());
                if(departmentTmp.contains(",")){
                    this.department = '[' + departmentTmp + ']';
                }
            }
            if(!regionTmp.isEmpty()) {
                this.region = regionTmp.substring(2, regionTmp.length());
                if(regionTmp.contains(",")){
                    this.region = '[' + regionTmp + ']';
                }
            }
        }
    }
}
