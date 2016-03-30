package it.cosenonjaviste.alfresco.workflow;

import it.cosenonjaviste.alfresco.annotations.ActivitiBean;
import org.activiti.engine.delegate.DelegateTask;
import org.alfresco.repo.workflow.activiti.tasklistener.TaskCreateListener;

import java.util.logging.Logger;

/**
 * Created by albertorugnone on 25/03/16.
 */
@ActivitiBean
public class OnCreateTest extends TaskCreateListener{

    private static Logger logger = Logger.getLogger(OnCreateTest.class.getName());
    @Override
    public void notify(DelegateTask task) {
        logger.info("called by "+ task);
    }
}
