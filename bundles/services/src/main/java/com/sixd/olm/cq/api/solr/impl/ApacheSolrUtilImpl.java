package com.sixd.olm.cq.api.solr.impl;

import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sixd.olm.cq.api.solr.ApacheSolrUtil;
import com.sixd.olm.cq.api.solr.conf.ApacheSolrConfiguration;

/**
 * Created by jhall on 10/8/14.
 */
@Component(immediate=true)
@Service({ApacheSolrUtil.class})
public class ApacheSolrUtilImpl implements ApacheSolrUtil {

    private static final Logger log = LoggerFactory.getLogger(ApacheSolrUtilImpl.class);

    @Reference
    private ApacheSolrConfiguration solrConfig;

    public Map<String, String> solrSettingsMap;

    public Boolean getSyncStatus(JSONObject resourceObj){
    	if(solrSettingsMap == null){
            this.solrSettingsMap = solrConfig.getEnvironmentMap();
    	}
        boolean b = false;
        String syncPropName = this.solrSettingsMap.get("syncPropName");
        if(resourceObj.has(syncPropName)){
            try {
                if(resourceObj.getString(syncPropName).equals("yes")){
                    b = true;
                }
            } catch (Exception e){
                log.error(e.getMessage());
            } finally {

            }
        }
        return b;
    }

    public Boolean evalValidType(JSONObject resourceObj){
        boolean b = false;
        // what is the property we need to check for validity
        String validType = this.solrSettingsMap.get("validTypePropName");
        // does the obj have the property?
        if(resourceObj.has(validType)){
            try {
                String propEnabled = resourceObj.getString(validType);
                if(this.solrSettingsMap.get(propEnabled).equals("enabled")){
                    // the setting for the type is enabled, pass the check
                    b = true;
                }
            } catch (Exception e){
                log.error(e.getMessage());
            } finally {

            }
        }
        return b;
    }
}
