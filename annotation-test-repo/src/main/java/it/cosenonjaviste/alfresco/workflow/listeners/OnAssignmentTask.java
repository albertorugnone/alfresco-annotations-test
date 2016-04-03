package it.cosenonjaviste.alfresco.workflow.listeners;

import it.cosenonjaviste.alfresco.annotations.workflow.TaskListenerBean;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.log4j.Logger;


/**
 * Created by albertorugnone on 03/04/16.
 */
@TaskListenerBean("onAssignment")
public class OnAssignmentTask implements TaskListener {
    private static Logger LOGGER = Logger.getLogger(OnAssignmentTask.class);

    public void notify(DelegateTask task) {
        LOGGER.info("on assignment called");
    }
}
