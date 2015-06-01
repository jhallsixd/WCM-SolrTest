package com.st.olm.cq.events.handler;

import com.day.cq.replication.ReplicationAction;
import com.day.cq.workflow.WorkflowService;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.model.WorkflowModel;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;
import java.util.Iterator;

/**
 * Created by sixdimensions on 5/5/15.
 */
@Component
@Service
@Property(name="event.topics",value= ReplicationAction.EVENT_TOPIC)
public class ReplicationEventHandler implements EventHandler {
    private static final Logger log = LoggerFactory.getLogger(ReplicationEventHandler.class);

    @Reference
    private WorkflowService workflowService;

    private Session repSession;

    @Reference
    private ResourceResolverFactory resolverFactory;

    /**
     * A constant for the mini site config path
     */
    public static final String MINI_SITE_CONFIG_PATH = "/etc/stconfig/auto-translation-paths";

    public void handleEvent(Event event) {
        ReplicationAction action = ReplicationAction.fromEvent(event);
        if (action != null){
            String path = action.getPath();
            log.info("User {} has tried to replicate {}",action.getUserId(),path);

            try {
                ResourceResolver resourceResolver = resolverFactory.getAdministrativeResourceResolver(null);
                repSession = resourceResolver.adaptTo(Session.class);

                Resource autoTranslateConfig = resourceResolver.getResource(MINI_SITE_CONFIG_PATH);
                Iterator configIterator = autoTranslateConfig.listChildren();
                boolean autoTranslate = false;
                while(configIterator.hasNext()) {
                    Resource config = (Resource)configIterator.next();

                    if(path.contains(config.getPath())){
                        autoTranslate = true;
                        log.info("Reolication path {} matches config path {}",path,config.getPath());
                    }

                }
                if(autoTranslate == true) {
                    log.info("Auto translate path {}",path);
                    startWorkflow("/etc/workflow/models/sample_ct_workflowtranslation/jcr:content/model",path);
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }finally {
                if(repSession != null)
                    repSession.logout();
            }


        }
    }

    public void startWorkflow(String workflowName, String workflowContent) {

        try
        {
            WorkflowSession wfSession = workflowService.getWorkflowSession(repSession);
            log.info("Workflow sessin created for {} model",workflowName);

            WorkflowModel wfModel = wfSession.getModel(workflowName);
            log.info("Workflow Model {}",wfModel);
            WorkflowData wfData = wfSession.newWorkflowData("JCR_PATH", workflowContent);

            wfSession.startWorkflow(wfModel, wfData);

            log.info("{} has been successfully invoked on this content: {}",workflowName,workflowContent);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}