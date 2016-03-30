package it.cosenonjaviste.alfresco.annotations.test;

import it.cosenonjaviste.alfresco.annotations.ActivitiBean;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * Created by albertorugnone on 28/03/16.
 */
@ActivitiBean
public class TaskListenerToTest implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {

    }
}
