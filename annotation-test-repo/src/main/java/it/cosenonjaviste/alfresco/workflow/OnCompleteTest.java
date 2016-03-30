package it.cosenonjaviste.alfresco.workflow;

import it.cosenonjaviste.alfresco.annotations.ActivitiBean;
import org.activiti.engine.delegate.DelegateTask;
import org.alfresco.repo.workflow.activiti.tasklistener.TaskCompleteListener;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

/**
 * Created by albertorugnone on 25/03/16.
 */
@ActivitiBean
public class OnCompleteTest extends TaskCompleteListener{

    @PostConstruct
    public void init() {
        logger.info("inititialized");
    }

    private static Logger logger = Logger.getLogger(OnCompleteTest.class.getName());
    @Override
    public void notify(DelegateTask task) {
        logger.info("called by "+ task);
    }
}
