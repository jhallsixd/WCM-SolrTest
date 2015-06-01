package com.st.olm.cq.config;

import com.day.cq.wcm.api.Page;
import com.st.olm.cq.sling.models.config.*;

public interface StaticConfigManager {

    DesignResourcesStaticConfigDetailsList.DesignResourcesStaticConfigDetails getStaticDesignConfigForPage(Page path);

    EDesignStaticConfigList.EDesignStaticConfig getStaticEDesignConfigForPath(String path);

    RightRailStaticConfigList.RightRailStaticConfig getStaticRightRailConfigForPath(String path);

    UpcomingSeminarsStaticConfigList.UpcomingSeminarsStaticConfig getStaticSeminarConfigForPath(String path);

    FeaturedVideosStaticConfigList.FeaturedVideosStaticConfig getStaticVideoConfigForPath(String path);
}
