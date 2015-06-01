package com.sixd.olm.cq.api.solr.conf;

import java.util.HashMap;
import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.OsgiUtil;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        label = "Apache Solr Configuration",
        description = "Configuration for Event Handler",
        metatype = true,
        immediate = true
)

@Service({ApacheSolrConfiguration.class})

@Properties({
        @Property(
                name = "apachesolr.handler.dev.settings",
                description = "DEV Profile",
                value = {
                        "environment=http://localhost",
                        "port=8983",
                        "path=solr",
                        "service=solrj",
                        "core=en",
                        "status=enabled"
                }
        ),
        @Property(
                name = "apachesolr.config.environment.settings",
                description = "Environment Configuration",
                value = {
                        "environment=dev",
                        "status=enabled"
                }
        )
})

/**
 * SolrConfiguration class implements OSGi configuration for Apache Solr integration.  Its
 * purpose is to provide details for indexing based on the environment settings.
 */
public class ApacheSolrConfiguration {
    //environment const
    private static final String DEV_ENVIRONMENT_MAP = "apachesolr.handler.dev.settings";
    private static final String SETTINGS_ENVIRONMENT_MAP = "apachesolr.config.environment.settings";

    // HashMap vars
    private Map<String, String> devProfile = new HashMap<String, String>();
    private Map<String, String> currentProfile = new HashMap<String, String>();
    private Map<String, String> settingsProfile = new HashMap<String, String>();

    private static final Logger log = LoggerFactory.getLogger(ApacheSolrConfiguration.class);

    /**
     * initializes the OSGI bundle
     *
     * @param context
     */
    @Activate
    protected void activate(ComponentContext context) {
        try {
            String[] oprofile = OsgiUtil.toStringArray(context.getProperties().get(SETTINGS_ENVIRONMENT_MAP));
            if (oprofile != null) {
                for (String anOprofile : oprofile) {
                    String[] map = anOprofile.split("=");
                    this.settingsProfile.put(map[0], map[1]);
                }
            }
        } catch (Exception e) {
            log.error("Unable to Parse DEV Configuration. Exception: ", e);
        }
        try {
            String[] oprofile = OsgiUtil.toStringArray(context.getProperties().get(DEV_ENVIRONMENT_MAP));
            if (oprofile != null) {
                for (String anOprofile : oprofile) {
                    String[] map = anOprofile.split("=");
                    log.info("SOLR OSGI - " + map[0] + "=" + map[1]);
                    this.devProfile.put(map[0], map[1]);
                }
            }
        } catch (Exception e) {
            log.error("Unable to Parse DEV Configuration. Exception: ", e);
        }
    }

    /**
     * Returns the field mapping for services settings.
     *
     * @return map of settings needed to connect to apache solr services
     */
    public Map<String, String> getEnvironmentSettingsMap() {
        return this.settingsProfile;
    }

    public Map<String, String> getEnvironmentMap() {
        return this.devProfile;
    }
}


