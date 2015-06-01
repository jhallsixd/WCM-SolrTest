package com.st.olm.cq.config.impl;

import com.st.olm.cq.config.StaticConfigManager;
import com.st.olm.cq.config.StaticConfigManagerFactory;
import com.st.olm.cq.sling.models.config.*;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Service
public class StaticConfigManagerFactoryImpl implements StaticConfigManagerFactory {

    protected static final Logger log = LoggerFactory.getLogger(StaticConfigManagerFactoryImpl.class);

    private EDesignStaticConfigList eDesignConfigurations;
    private FeaturedVideosStaticConfigList videoConfigurations;
    private RightRailStaticConfigList rightRailConfigurations;
    private UpcomingSeminarsStaticConfigList seminarConfigurations;

    @Reference
    ResourceResolverFactory resolverFactory;

    @Activate
    protected void activate(ComponentContext context){
        ResourceResolver resolver = null;
        if(resolverFactory != null) {
            try {
                resolver = resolverFactory.getAdministrativeResourceResolver(null);
                if(resolver != null) {
                    resolver = buildDesignConfigs(resolver);
                    if (resolver != null) {
                        resolver = buildEDesignConfigs(resolver);
                        if (resolver != null) {
                            resolver = buildRightRailConfigs(resolver);
                            if(resolver != null) {
                                resolver = buildSeminarConfigs(resolver);
                                if(resolver != null) {
                                    resolver = buildVideoConfigs(resolver);
                                }
                            }
                        }
                    }
                }
            }catch(Exception e){
                log.error("Exception getting resource resolver");
            }finally{
                if (resolver != null && resolver.isLive())
                    resolver.close();
            }
        }else {
            log.error("Problem getting resource resolver from resolver factory");
        }
    }

    public ResourceResolver buildDesignConfigs(ResourceResolver resolver){
        if (resolver != null) {
            Resource resource = resolver.getResource(DesignResourcesStaticConfigList.CONFIG_FRAGMENTS_BASE);
            if (resource != null) {
                DesignResourcesStaticConfigList configList = resource.adaptTo(DesignResourcesStaticConfigList.class);
                if (configList != null) {
                    log.info("Design configurations successfully built.");
                }else{
                    log.error("Design config list null");
                }
            }else{
                log.error("Design - Root design resource null");
            }
            return resolver;
        } else {
            log.error("Design - Resource resolver null");
            return null;
        }
    }

    public ResourceResolver buildEDesignConfigs(ResourceResolver resolver){
        if (resolver != null) {
            Resource resource = resolver.getResource(EDesignStaticConfigList.CONFIG_FRAGMENTS_BASE);
            if (resource != null) {
                EDesignStaticConfigList configList = resource.adaptTo(EDesignStaticConfigList.class);
                if (configList != null) {
                    this.eDesignConfigurations = configList;
                    log.info("E-Design configurations successfully built.");
                }else{
                    log.error("E Design config list null");
                }
            }else{
                log.error("E Design - Root design resource null");
            }
            return resolver;
        } else {
            log.error("E Design - Resource resolver null");
            return null;
        }
    }

    public ResourceResolver buildRightRailConfigs(ResourceResolver resolver) {
        if (resolver != null) {
            Resource resource = resolver.getResource(RightRailStaticConfigList.CONFIG_BASE);
            if (resource != null) {
                RightRailStaticConfigList configList = resource.adaptTo(RightRailStaticConfigList.class);
                if (configList != null) {
                    this.rightRailConfigurations = configList;
                    log.info("Right Rail configurations successfully built.");
                }else{
                    log.error("Right Rail config list null");
                }
            }else{
                log.error("Right Rail - Root design resource null");
            }
            return resolver;
        } else {
            log.error("Right Rail - Resource resolver null");
            return null;
        }
    }

    public ResourceResolver buildSeminarConfigs(ResourceResolver resolver){
        if (resolver != null) {
            Resource resource = resolver.getResource(UpcomingSeminarsStaticConfigList.CONFIG_FRAGMENTS_BASE);
            if (resource != null) {
                UpcomingSeminarsStaticConfigList configList = resource.adaptTo(UpcomingSeminarsStaticConfigList.class);
                if (configList != null) {
                    this.seminarConfigurations = configList;
                    log.info("Seminar configurations successfully built");
                }else{
                    log.error("Seminar config list null");
                }
            }else{
                log.error("Seminar - Root design resource null");
            }
            return resolver;
        } else {
            log.error("Seminar -Resource resolver null");
            return null;
        }
    }

    public ResourceResolver buildVideoConfigs(ResourceResolver resolver){
        if (resolver != null) {
            Resource resource = resolver.getResource(FeaturedVideosStaticConfigList.CONFIG_FRAGMENTS_BASE);
            if (resource != null) {
                FeaturedVideosStaticConfigList configList = resource.adaptTo(FeaturedVideosStaticConfigList.class);
                if (configList != null) {
                    this.videoConfigurations = configList;
                    log.info("Video configurations successfully built.");
                }else{
                    log.error("Video config list null");
                }
            }else{
                log.error("Video - Root design resource null");
            }
            return resolver;
        } else {
            log.error("Video -Resource resolver null");
            return null;
        }
    }

    @Override
    public StaticConfigManagerImpl getStaticDesignConfigManager() {
        return new StaticConfigManagerImpl();
    }

    @Override
    public StaticConfigManagerImpl getStaticEDesignConfigManager(){
        return new StaticConfigManagerImpl(eDesignConfigurations);
    }

    @Override
    public StaticConfigManager getStaticRightRailConfigManager() {
        return new StaticConfigManagerImpl(rightRailConfigurations);
    }

    @Override
    public StaticConfigManager getStaticSeminarsConfigManager() {
        return new StaticConfigManagerImpl(seminarConfigurations);
    }

    @Override
    public StaticConfigManager getStaticVideoConfigManager() {
        return new StaticConfigManagerImpl(videoConfigurations);
    }
}
