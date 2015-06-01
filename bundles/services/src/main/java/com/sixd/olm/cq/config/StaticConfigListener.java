package com.st.olm.cq.config;

import com.st.olm.cq.api.SharedConstants;
import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.*;

import org.apache.sling.api.SlingConstants;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

@Component(metatype=true)
@Service(EventHandler.class)
@Properties({ @Property(name = EventConstants.EVENT_TOPIC,
        value = { SlingConstants.TOPIC_RESOURCE_ADDED,
                SlingConstants.TOPIC_RESOURCE_CHANGED,
                SlingConstants.TOPIC_RESOURCE_REMOVED}),
        @Property(name = EventConstants.EVENT_FILTER, value= {"(path=" + SharedConstants.ST_ADMIN_ROOT + "*)"}) }
)
public class StaticConfigListener implements EventHandler {

    @Reference
    StaticConfigManagerFactory managerFactory;

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Override
    public void handleEvent(org.osgi.service.event.Event event) {
        if (event == null)
            return;

        final String propPath = (String) event.getProperty(SlingConstants.PROPERTY_PATH);
        if (StringUtils.isBlank(propPath))
            return;

        if(propPath.indexOf(SharedConstants.E_DESIGN_ROOT) > -1){
            if(managerFactory != null){
                rebuildEDesignConfigs();
            }
        }else if(propPath.indexOf(SharedConstants.RIGHT_RAIL_ROOT) > -1){
            if(managerFactory != null){
                rebuildRightRailConfigs();
            }
        }else if(propPath.indexOf(SharedConstants.UPCOMING_SEMINARS_ROOT) > -1){
            if(managerFactory != null){
                rebuildSeminarConfigs();
            }
        }else if(propPath.indexOf(SharedConstants.FEATURED_VIDEOS_ROOT) > -1){
            if(managerFactory != null){
                rebuildVideoConfigs();
            }
        }else if (propPath.indexOf(SharedConstants.DESIGN_RESOURCES_ROOT) > -1) {
            //listener fires for child section/tableConfig nodes, ignore
            if (propPath.indexOf("/section") > -1 || propPath.indexOf("/table") > -1)
                return;
            if (managerFactory != null) {
                rebuildDesignConfigs();
            }
        }
    }

    private void rebuildDesignConfigs() {
        if(resourceResolverFactory != null ) {
            ResourceResolver resolver = null;
            try {
                resolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
                managerFactory.buildDesignConfigs(resolver);
            } catch (LoginException e) {
                e.printStackTrace();
            } finally {
                if (resolver != null && resolver.isLive()) {
                    resolver.close();
                }
            }
        }
    }

    private void rebuildEDesignConfigs() {
        if(resourceResolverFactory != null ) {
            ResourceResolver resolver = null;
            try {
                resolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
                managerFactory.buildEDesignConfigs(resolver);
            } catch (LoginException e) {
                e.printStackTrace();
            } finally {
                if (resolver != null && resolver.isLive()) {
                    resolver.close();
                }
            }
        }
    }

    private void rebuildRightRailConfigs() {
        if(resourceResolverFactory != null ) {
            ResourceResolver resolver = null;
            try {
                resolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
                managerFactory.buildRightRailConfigs(resolver);
            } catch (LoginException e) {
                e.printStackTrace();
            } finally {
                if (resolver != null && resolver.isLive()) {
                    resolver.close();
                }
            }
        }
    }

    private void rebuildSeminarConfigs(){
        if(resourceResolverFactory != null ) {
            ResourceResolver resolver = null;
            try {
                resolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
                managerFactory.buildSeminarConfigs(resolver);
            } catch (LoginException e) {
                e.printStackTrace();
            } finally {
                if (resolver != null && resolver.isLive()) {
                    resolver.close();
                }
            }
        }
    }

    private void rebuildVideoConfigs(){
        if(resourceResolverFactory != null ) {
            ResourceResolver resolver = null;
            try {
                resolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
                managerFactory.buildVideoConfigs(resolver);
            } catch (LoginException e) {
                e.printStackTrace();
            } finally {
                if (resolver != null && resolver.isLive()) {
                    resolver.close();
                }
            }
        }
    }
}
