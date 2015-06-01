package com.st.olm.cq.config.impl;

import com.day.cq.wcm.api.Page;
import com.st.olm.cq.config.StaticConfigManager;
import com.st.olm.cq.sling.models.config.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticConfigManagerImpl implements StaticConfigManager {

    private static final Logger log = LoggerFactory
            .getLogger(StaticConfigManagerImpl.class);

    private DesignResourcesStaticConfigDetailsList designConfigs;
    private EDesignStaticConfigList eDesignConfigs;
    private RightRailStaticConfigList rightRailConfigs;
    private UpcomingSeminarsStaticConfigList seminarConfigs;
    private FeaturedVideosStaticConfigList videoConfigs;

    public StaticConfigManagerImpl(){ designConfigs = new DesignResourcesStaticConfigDetailsList();  }

    public StaticConfigManagerImpl(RightRailStaticConfigList configurations){ this.rightRailConfigs = configurations; }

    public StaticConfigManagerImpl(UpcomingSeminarsStaticConfigList configurations){ this.seminarConfigs = configurations; }

    public StaticConfigManagerImpl(FeaturedVideosStaticConfigList configurations){ this.videoConfigs = configurations; }

    public StaticConfigManagerImpl(EDesignStaticConfigList configurations){ this.eDesignConfigs = configurations; }

    public DesignResourcesStaticConfigDetailsList.DesignResourcesStaticConfigDetails getStaticDesignConfigForPage(Page page) {
            return designConfigs.findMatchingConfig(page);
    }

    public EDesignStaticConfigList.EDesignStaticConfig getStaticEDesignConfigForPath(String path) {
        if(eDesignConfigs != null){
                return eDesignConfigs.findMatchingConfig(path);
        }else{
            log.error("StaticConfigManagerImpl e-design config list is null");
            return null;
        }
    }

    public RightRailStaticConfigList.RightRailStaticConfig getStaticRightRailConfigForPath(String path) {
        if(rightRailConfigs != null){
            return rightRailConfigs.findMatchingConfig(path);
        }else{
            log.error("StaticConfigManagerImpl right rail config list is null");
            return null;
        }
    }

    public UpcomingSeminarsStaticConfigList.UpcomingSeminarsStaticConfig getStaticSeminarConfigForPath(String path) {
        if(seminarConfigs != null){
            return seminarConfigs.findMatchingConfig(path);
        }else{
            log.error("StaticConfigManagerImpl upcoming seminar config list is null");
            return null;
        }

    }

    public FeaturedVideosStaticConfigList.FeaturedVideosStaticConfig getStaticVideoConfigForPath(String path) {
        if(videoConfigs != null){
            return videoConfigs.findMatchingConfig(path);
        }else{
            log.error("StaticConfigManagerImpl featured videos config list is null");
            return null;
        }
    }
}
