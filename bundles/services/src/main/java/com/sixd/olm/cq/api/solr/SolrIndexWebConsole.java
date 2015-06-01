package com.sixd.olm.cq.api.solr;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.felix.webconsole.AbstractWebConsolePlugin;
import org.apache.felix.webconsole.WebConsoleConstants;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Service(value = {Servlet.class})
@Properties({
        @Property(name = WebConsoleConstants.PLUGIN_LABEL, value = SolrIndexWebConsole.LABEL),
        @Property(name = WebConsoleConstants.PLUGIN_TITLE, value = SolrIndexWebConsole.TITLE)})
public class SolrIndexWebConsole extends AbstractWebConsolePlugin {

    public static final String LABEL = "solrindexing";
    public static final String TITLE = "Solr Indexing";
    private static final String CONSOLE_VIEW = "/solr-indexing-console.html";

    private static final String LABEL_ACTION = "action";

    private static final String ACTION_INDEX = "indexcontent";
    private static final String ACTION_FIND = "findresources";

    private static final String PARAMETER_CHUNK = "chunkSize";
    private static final String PARAMETER_SLEEP = "sleepDelay";
    private static final String PARAMETER_CONTENT_PATH = "contentPath";

    private static final String PROPERTY_RESOURCES_COUNT = "resourcesCount";
    private static final String PROPERTY_RESOURCES = "indexingResources";

    private static final int MILLISECONDS_IN_SECOND = 1000;

    private static final Logger log = LoggerFactory.getLogger(SolrIndexWebConsole.class);

    private static final long serialVersionUID = -6591235429225405517L;

    @Reference
    private ApacheSolrCommandFactoryService solrCommandFactoryService;

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    private ResourceResolver resourceResolver;

    @Override
    protected void renderContent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        log.info("SolrIndexWebConsole:renderContent");
        Map<String, Object> properties = new HashMap<>();

        List<Resource> indexingResources = new ArrayList<>();

        if (ACTION_FIND.equals(httpServletRequest.getParameter(LABEL_ACTION))) {
            String indexingContentPath = httpServletRequest.getParameter(PARAMETER_CONTENT_PATH);
            if (StringUtils.isNotBlank(indexingContentPath)) {
                indexingResources = findResources(indexingContentPath);
                properties.put(PROPERTY_RESOURCES_COUNT, indexingResources.size());
            }
        }

        if (ACTION_INDEX.equals(httpServletRequest.getParameter(LABEL_ACTION))) {
            String indexingContentPath = httpServletRequest.getParameter(PARAMETER_CONTENT_PATH);
            if (StringUtils.isBlank(indexingContentPath))
                return;
            indexingResources = findResources(indexingContentPath);
            if (indexingResources.isEmpty())
                return;
            properties.put(PROPERTY_RESOURCES_COUNT, indexingResources.size());
            int chunkSize;
            int sleepDelay;
            try {
                chunkSize = Integer.parseInt(httpServletRequest.getParameter(PARAMETER_CHUNK));
                sleepDelay = Integer.parseInt(httpServletRequest.getParameter(PARAMETER_SLEEP));
            } catch (NumberFormatException e) {
                log.error(e.getMessage(), e);
                return;
            }
            if (chunkSize > 0 && sleepDelay > 0) {
                runIndexing(indexingResources, chunkSize, sleepDelay);
            } else {
                return;
            }
        }
        properties.put(PROPERTY_RESOURCES, indexingResources.stream().map(Resource::getPath).collect(Collectors.toList()));
        renderBlock(httpServletResponse, CONSOLE_VIEW, properties);
    }

    private void runIndexing(List<Resource> indexingResources, int chunkSize, int sleepDelay) {
        int resourcesSize = indexingResources.size();
        if (chunkSize > indexingResources.size())
            chunkSize = resourcesSize;

        int stepsCount = resourcesSize / chunkSize;
        if (resourcesSize % chunkSize != 0)
            ++stepsCount;
        JSONObject solrObj = buildSolrResObject();
        log.info("SolrIndexWebConsole:runIndexing:indexingResources " + indexingResources);
        for (int i = 0; i < stepsCount; i++) {
            List<Resource> resourcesChunk =
                    i == stepsCount - 1 ?
                            indexingResources.subList((i * chunkSize), resourcesSize) :
                            indexingResources.subList((i * chunkSize), chunkSize * (i + 1));
            SolrCommand cmd = solrCommandFactoryService.createCommand(solrObj, resourcesChunk);
            if (cmd != null && cmd.execute()) {
                JSONObject cmdResult = cmd.getResultObject();
                log.info(" result: " + cmdResult.toString());
            }
            try {
                Thread.sleep(sleepDelay * MILLISECONDS_IN_SECOND);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private List<Resource> findResources(String indexingContentPath) {
        List<Resource> indexingResources = new ArrayList<>();
        if (StringUtils.isBlank(indexingContentPath))
            return indexingResources;

        QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
        Session jcrSession = resourceResolver.adaptTo(Session.class);

        // query the JCR for fragments
        Map<String, String> predicates = new HashMap<>();
        predicates.put("path", indexingContentPath);
        predicates.put("type", "cq:Page");
        predicates.put("p.limit", "0");

        Query query = queryBuilder.createQuery(PredicateGroup.create(predicates), jcrSession);
        for (Hit hit : query.getResult().getHits()) {
            try {
                indexingResources.add(hit.getResource());
            } catch (RepositoryException e) {
                log.error(e.getMessage(), e);
            }
        }
        return indexingResources;
    }

    private JSONObject buildSolrResObject() {
        JSONObject resObj = new JSONObject();
        try {
            resObj.put("commit", "true");
            resObj.put("profileCmdType", "IndexResource");
            JSONArray fields = new JSONArray();
            JSONObject obj = new JSONObject();
            obj.put("cat", "page");
            fields.put(obj);
            resObj.put("fields", fields);
        } catch (JSONException e) {
            log.error(e.getMessage(), e);
        }
        return resObj;
    }

    private void renderBlock(HttpServletResponse httpServletResponse, String templateName, Map<String, Object> properties) throws IOException {
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String template = null;
        try {
            is = getClass().getClassLoader().getResourceAsStream(templateName);
            if (is != null) {
                IOUtils.copy(is, baos);
                template = baos.toString();
            } else {
                throw new IOException("Unable to load template " + templateName);
            }
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(baos);
        }
        StrSubstitutor sub = new StrSubstitutor(properties);
        httpServletResponse.getWriter().write(sub.replace(template));
    }

    @Override
    public String getLabel() {
        return LABEL;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    /**
     * Called when this servlet is activate
     *
     * @param context
     * @throws LoginException
     */
    protected void activate(ComponentContext context) throws LoginException {
        resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
    }

    /**
     * Called when this servlet is deactivated
     *
     * @param context
     */
    protected void deactivate(ComponentContext context) {
        if (resourceResolver != null) {
            resourceResolver.close();
        }
    }
}