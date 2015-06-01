package com.sixd.olm.cq.api.solr.impl;

import com.sixd.olm.cq.api.solr.cmds.IndexResourceCommand;
import com.sixd.olm.cq.api.solr.cmds.RemoveResourceCommand;
import com.sixd.olm.cq.api.solr.conf.ApacheSolrConfiguration;
import com.sixd.olm.cq.api.solr.ApacheSolrCommandFactoryService;
import com.sixd.olm.cq.api.solr.SolrCommand;
import com.sixd.olm.cq.api.solr.ApacheSolrUtil;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.jcr.api.SlingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.ResourceResolverFactory;

import java.util.List;

/**
 * Created by jhall on 10/8/14.
 */
@Component(immediate = true)
@Service({ApacheSolrCommandFactoryService.class})
public class ApacheSolrCommandFactoryServiceImpl implements ApacheSolrCommandFactoryService {

    @Reference
    private SlingRepository repository;

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Reference
    private ApacheSolrConfiguration solrConfig;

    @Reference
    ApacheSolrUtil apacheSolrUtil;

    private static final Logger log = LoggerFactory.getLogger(ApacheSolrCommandFactoryServiceImpl.class);

    @Override
    public SolrCommand createCommand(JSONObject obj, Resource res) {
        log.info("SolrFactory.createCommand");
        SolrCommand cmd = null;
        try {
            String cmdType = obj.get("profileCmdType").toString();
            log.info("Creating cmd of type: " + cmdType);
            if (cmdType.equals("IndexResource")) {
                if (null != res) {
                    cmd = new IndexResourceCommand(solrConfig, res);
                }
            } else if (cmdType.equals("RemoveResource")) {
                if (null != res) {
                    cmd = new RemoveResourceCommand(solrConfig, res);
                }
            }

            if ((cmd != null) && (!cmd.validate())) {
                cmd = null;
                log.error("Invalid command");
            }
        } catch (Exception e) {
            log.error("createCommand threw an exception", e);
        }

        return cmd;
    }

    @Override
    public SolrCommand createCommand(JSONObject obj, List<Resource> resources) {
        SolrCommand solrCommand = null;
        try {
            String cmdType = obj.get("profileCmdType").toString();
            if (cmdType.equals("IndexResource")) {
                solrCommand = new IndexResourceCommand(solrConfig, resources);
            }
        } catch (JSONException e) {
            log.error(e.getMessage(), e);
        }
        return solrCommand;
    }

    /**
     * This method creates and returns a SolrCommand object based on the json formatted string parameter
     *
     * @param str Parameters for the Solr command.  (JSON formatted string)
     * @return Requested SolrCommand on success, null on failure
     */
    @Override
    public SolrCommand createCommand(String str, Resource res) {
        SolrCommand cmd = null;
        try {
            JSONObject obj = new JSONObject(str);
            cmd = createCommand(obj, res);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return cmd;
    }
}
