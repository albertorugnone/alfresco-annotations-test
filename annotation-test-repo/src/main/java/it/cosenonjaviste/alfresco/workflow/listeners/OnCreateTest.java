package it.cosenonjaviste.alfresco.workflow.listeners;

import it.cosenonjaviste.alfresco.annotations.workflow.OnCompleteTaskListener;
import it.cosenonjaviste.alfresco.annotations.workflow.OnCreateTaskListener;
import org.activiti.engine.delegate.DelegateTask;
import org.alfresco.repo.workflow.activiti.tasklistener.TaskCompleteListener;
import org.alfresco.repo.workflow.activiti.tasklistener.TaskCreateListener;
import org.apache.log4j.Logger;


/**
 * Created by albertorugnone on 03/04/16.
 */
@OnCreateTaskListener
public class OnCreateTest extends TaskCreateListener{
    private static Logger LOGGER = Logger.getLogger(OnCreateTest.class);

    @Override
    public void notify(DelegateTask task) {
        super.notify(task);
        LOGGER.info("on created called");
    }
}
