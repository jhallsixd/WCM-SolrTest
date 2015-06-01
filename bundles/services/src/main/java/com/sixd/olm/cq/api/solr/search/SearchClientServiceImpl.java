package com.st.olm.cq.api.solr.search;

import com.st.olm.cq.api.solr.conf.ApacheSolrConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


/**
 * This is the client used to communicate with the Solr WS
 * 
 * @author Stefan Stoica <stefan.stoica@zitec.ro>
 */
@Component
@Service(value = SearchClientServiceImpl.class)
@Properties({ @Property(name = "searchWsURL", description = "Define Solr WS searchURL here", label = "Solr WS Host") })
public class SearchClientServiceImpl {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Reference
    private ApacheSolrConfiguration solrConfig;

	public String get(NameValuePair[] query, String category) {
		HttpClient client;
		String apiResponse = "";
		try {
			client = new HttpClient();
            String url = getSearchUrl(category);
			GetMethod get = new GetMethod(url);

			get.setQueryString(query);
			get.addRequestHeader("Accept", "application/json");
			get.addRequestHeader("http.protocol.content-charset", "UTF-8");
			client.executeMethod(get);

			apiResponse = get.getResponseBodyAsString();
		} catch (Exception e) {
			log.error("There was an error connecting to Solr WS", e);
		}

		return apiResponse;
	}
	
	private String getSearchUrl(String category) {
        Map<String, String> solrSettingsMap = solrConfig.getEnvironmentMap();
        String env = solrSettingsMap.get("environment");
        String port = solrSettingsMap.get("port");
        String _instance = env + ":" + port + "/";
        return _instance + category;
	}
}
