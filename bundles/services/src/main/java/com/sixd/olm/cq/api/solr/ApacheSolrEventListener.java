package com.st.olm.cq.api.solr;

/**
 * Created by jhall on 10/7/14.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.replication.ReplicationException;
import com.day.cq.replication.Replicator;
import com.st.olm.cq.api.ccc.CCCAsset;
import com.st.olm.cq.api.ccc.CCCAssetManager;
import com.st.olm.cq.api.products.STProduct;
import com.st.olm.cq.api.solr.conf.ApacheSolrConfiguration;
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

    /**
     * Path parts of activated product overview fragment
     */
    private static final String PRODUCT_RELATED_PART = "product_related";
    private static final String OVERVIEW_PART = "overview";
    /**
     * Product overview fragment tag prefix
     */
    private static final String OVERVIEW_TAG_PREFIX = "ccc:fragment/product_related";
    /**
     * Tags property
     */
    private static final String TAGS_PROPERTY = "cq:tags";

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
                            activateRelatedResources(adminResolver, res);
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

    private void activateRelatedResources(ResourceResolver adminResolver, Resource activatedResource) {
        CCCAssetManager cccAssetManager = adminResolver.adaptTo(CCCAssetManager.class);
        STProduct product = getActivatedProduct(activatedResource, cccAssetManager);
        if (product != null) {
            List<CCCAsset<?>> relatedAssets = getRelatedAssets(cccAssetManager, product);
            try {
                replicateAssets(adminResolver, relatedAssets);
            } catch (ReplicationException e) {
                log.error("Can't replicate related assets to the product {}" + product.getPrmisId());
            }
        }
    }

    private List<CCCAsset<?>> getRelatedAssets(CCCAssetManager cccAssetManager, STProduct product) {
        List<CCCAsset<?>> relatedAssets = new ArrayList<>();
        if (product != null) {
            List<CCCAsset<?>> allAssets = cccAssetManager.getCCCAssets(product);
            for (CCCAsset<?> asset : allAssets) {
                if (!isProductOverview(asset.getResource())) {
                    relatedAssets.add(asset);
                }
            }
        } else {
            log.trace("Product is null");
        }
        return relatedAssets;
    }

    private void replicateAssets(ResourceResolver adminResolver, List<CCCAsset<?>> relatedAssets)
            throws ReplicationException {
        for (CCCAsset<?> relatedAsset : relatedAssets) {
            replicator.replicate(adminResolver.adaptTo(Session.class),
                    ReplicationActionType.ACTIVATE, relatedAsset.getPath());
        }
    }

    private STProduct getActivatedProduct(Resource activatedResource, CCCAssetManager cccAssetManager) {
        boolean isOverview = isProductOverview(activatedResource);
        if (isOverview) {
            CCCAsset<?> cccAsset = cccAssetManager.getCCCAsset(activatedResource.getPath());
            if (cccAsset.isFragment()) {
                List<STProduct> productAssociationIds = cccAsset.getProductAssociations();
                if (!productAssociationIds.isEmpty()) {
                    return productAssociationIds.get(0);
                }
            }
        }
        return null;
    }

    private boolean isProductOverview(Resource activatedResource) {
        String resourcePath = activatedResource.getPath();
        if (resourcePath.contains(PRODUCT_RELATED_PART) && resourcePath.contains(OVERVIEW_PART)) {
            Resource content = activatedResource.getChild(JcrConstants.JCR_CONTENT);
            if (content != null) {
                ValueMap properties = content.adaptTo(ValueMap.class);
                if (properties != null) {
                    String[] resourceTags = properties.get(TAGS_PROPERTY, String[].class);
                    if (resourceTags != null) {
                        for (String tag : resourceTags) {
                            if (tag.contains(OVERVIEW_TAG_PREFIX) && tag.contains(OVERVIEW_PART)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
