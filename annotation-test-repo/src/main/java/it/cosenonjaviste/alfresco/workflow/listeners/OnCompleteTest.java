package it.cosenonjaviste.alfresco.workflow.listeners;

import it.cosenonjaviste.alfresco.annotations.workflow.OnCompleteTaskListener;
import org.activiti.engine.delegate.DelegateTask;
import org.alfresco.repo.workflow.activiti.tasklistener.TaskCompleteListener;
import org.apache.log4j.Logger;


/**
 * Created by albertorugnone on 03/04/16.
 */
@OnCompleteTaskListener
public class OnCompleteTest extends TaskCompleteListener{
    private static Logger LOGGER = Logger.getLogger(OnCompleteTest.class);

    @Override
    public void notify(DelegateTask task) {
        super.notify(task);
        LOGGER.info("on completed called");
    }
}
