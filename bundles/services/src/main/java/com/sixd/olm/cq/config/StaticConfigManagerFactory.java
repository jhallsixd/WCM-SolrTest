package com.st.olm.cq.config;

import org.apache.sling.api.resource.ResourceResolver;

public interface StaticConfigManagerFactory {

    ResourceResolver buildDesignConfigs(ResourceResolver resolver);

    ResourceResolver buildEDesignConfigs(ResourceResolver resolver);

    ResourceResolver buildRightRailConfigs(ResourceResolver resolver);

    ResourceResolver buildSeminarConfigs(ResourceResolver resolver);

    ResourceResolver buildVideoConfigs(ResourceResolver resolver);

    StaticConfigManager getStaticDesignConfigManager();

    StaticConfigManager getStaticEDesignConfigManager();

    StaticConfigManager getStaticRightRailConfigManager();

    StaticConfigManager getStaticSeminarsConfigManager();

    StaticConfigManager getStaticVideoConfigManager();

}
