package com.sixd.olm.cq.api.solr;

/**
 * Created by jhall on 10/7/14.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.replication.ReplicationException;
import com.day.cq.replication.Replicator;
import com.sixd.olm.cq.api.solr.conf.ApacheSolrConfiguration;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;
import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationActionType;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jcr.Session;

/**
 * This is an listener that listens for updates and manages indexing with solr
 */
@Component(metatype = true, immediate = true)
@Service(EventHandler.class)
@Properties({ @Property(name = "event.topics", value = { ReplicationAction.EVENT_TOPIC }, propertyPrivate = true) })

public class ApacheSolrEventListener implements EventHandler {

    private static final Logger log = LoggerFactory.getLogger(ApacheSolrEventListener.class);

    @Reference
    private ResourceResolverFactory factory;

    @Reference
    private ApacheSolrConfiguration solrConfig;

    @Reference
    ApacheSolrUtil apacheSolrUtil;

    /**
     * A reference to the Replicator Service
     */
    @Reference
    private Replicator replicator;

    @Reference
    ApacheSolrCommandFactoryService solrCommandFactoryService;

    @Property(label = "Service Enabled", boolValue = false)
    private static final String ENABLED = "enabled";
    private boolean enabled = false;
    private Map<String, String> environmentSettingsMap;
    private Map<String, String> solrSettingsMap;

    /**
     * Called when the service is activated.
     *
     * @param context
     */
    @Activate
    public void activate(ComponentContext context) {
        log.info("ApacheSolrEventListener.activate");
        if (PropertiesUtil.toBoolean(context.getProperties().get(ENABLED), false)) {
            log.info("ApacheSolrEventListener.enabled = true");
            enabled = true;
        }
    }

    /**
     * Called when the service is activated.
     *
     * @param context
     */
    @Deactivate
    public void deactivate(ComponentContext context) {
        log.info("ApacheSolrEventListener.deactivate");
    }

    public void run() {
    }

    public void handleEvent(Event event) {
        log.info("ApacheSolrEventListener.handleEvent " + event.toString());
        ResourceResolver adminResolver = null;

        try {
            adminResolver = factory.getAdministrativeResourceResolver(null);

            if (enabled) {
                // is the service available?
                //enabled = this.environmentSettingsMap.get("status").equals("enabled");
                enabled = true;
                if (enabled) {
                    log.info("ApacheSolrEventListener.handleEvent");

                    ReplicationAction action = ReplicationAction.fromEvent(event);
                    ReplicationActionType actionType = action.getType();

                    log.info("ApacheSolrEventListener.resource " + action.getPath());
                    Resource res = adminResolver.getResource(action.getPath());
                    JSONObject resObj = new JSONObject();
                    String cmdStr = "";
                    try {
                        if (actionType.equals(ReplicationActionType.ACTIVATE)) {  // 12
                            cmdStr = "IndexResource";

                        } else if (actionType.equals(ReplicationActionType.DEACTIVATE) ||
                                actionType.equals(ReplicationActionType.DELETE)) {
                            cmdStr = "RemoveResource";
                        }
                        resObj.put("commit", "true");
                        resObj.put("profileCmdType", cmdStr);
                        JSONArray fields = this.prepareFieldsFromType("page", res);
                        resObj.put("fields", fields);
                        log.info("ApacheSolrEventListener.resObj " + resObj.toString());
                        SolrCommand cmd = solrCommandFactoryService.createCommand(resObj, res);
                        if ((cmd != null) && cmd.execute() == true) {
                            JSONObject cmdResult = cmd.getResultObject();
                            log.info(cmdStr + " result: " + cmdResult.toString());
                        }
                    } catch (JSONException e) {
                        log.error("ApacheSolrEventListener solr command " + cmdStr, e);
                    }
                    log.debug("Event complete: " + cmdStr);
                }
            }
        } catch (LoginException e) {
            log.error("Exception getting administrative resource resolver, ", e);
        } finally {
            if (adminResolver != null) {
                adminResolver.close();
            }
        }
    }

    private JSONArray prepareFieldsFromType(String type, Resource res) {
        JSONArray fields = null;
        // TODO: needs to be expanded to match the jcr and solr schema
        // reminder: remove the following line, this is a placeholder for the story/
        // at this time we are only indexing pages
        try {
            fields = new JSONArray();
            JSONObject obj = new JSONObject();
            obj.put("cat", type);
            fields.put(obj);
            log.info("ApacheSolrEventListener.fields returned " + fields.toString());
        } catch (JSONException e) {
            log.error("ApacheSolrEventListener.fields exception ", e);
        }
        return fields;
    }
}
