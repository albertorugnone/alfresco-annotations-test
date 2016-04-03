package it.cosenonjaviste.alfresco.annotations;

import com.tradeshift.test.remote.Remote;
import com.tradeshift.test.remote.RemoteTestRunner;
import it.cosenonjaviste.alfresco.annotations.workflow.ActivitiBean;
import it.cosenonjaviste.alfresco.annotations.workflow.OnCompleteTaskListener;
import it.cosenonjaviste.alfresco.annotations.workflow.OnCreateTaskListener;
import it.cosenonjaviste.alfresco.annotations.workflow.TaskListenerBean;
import it.omniagroup.product.rule.JUnitRemoteEndpoint;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.alfresco.repo.workflow.activiti.tasklistener.TaskCompleteListener;
import org.alfresco.repo.workflow.activiti.tasklistener.TaskCreateListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by albertorugnone on 28/03/16.
 */
@RunWith(RemoteTestRunner.class)
@Remote(runnerClass = SpringJUnit4ClassRunner.class, endpoint = JUnitRemoteEndpoint.URL)
@ContextConfiguration("classpath:alfresco/application-context.xml")
public class ActivitiBeanIntegrationTest {

    @OnCreateTaskListener
    static public class TaskCreateListenerToTest extends TaskCreateListener {
    }

    @ActivitiBean
    static public class ActivitiBeanToTest {
    }

    @TaskListenerBean
    static public class TaskListenerToTest implements TaskListener {

        @Override
        public void notify(DelegateTask delegateTask) {

        }
    }

    @OnCompleteTaskListener
    static public class TaskCompleteListenerToTest extends TaskCompleteListener {
        @Override
        public void notify(DelegateTask task) {
            super.notify(task);
        }
    }


    static public class ANotActivitiBeanToTest {
    }

    @Autowired
    ApplicationContext context;

    private Map<String, Object> activitiBeanRegistry;

    @Before
    public void initActivitiBeanRegistry() {
        this.activitiBeanRegistry = (Map<String, Object>) context.getBean("activitiBeanRegistry");
        assertNotNull(activitiBeanRegistry);
    }

    @Test
    public void shouldHaveActivitiBean() throws Exception {
        ActivitiBeanToTest activitiBeanToTest = (ActivitiBeanToTest) this.activitiBeanRegistry.get("activitiBeanToTest");
        assertNotNull(activitiBeanToTest);
    }

    @Test
    public void shouldHaveTaskActivitiBean() throws Exception {
        TaskListenerToTest activitiBeanToTest = (TaskListenerToTest) this.activitiBeanRegistry.get("taskListenerToTest");
        assertNotNull(activitiBeanToTest);
    }

    @Test
    public void shouldHaveTaskCompleteBean() throws Exception {
        TaskCompleteListenerToTest activitiBeanToTest = (TaskCompleteListenerToTest) this.activitiBeanRegistry.get("taskCompleteListenerToTest");
        assertNotNull(activitiBeanToTest);
    }

    @Test
    public void shouldHaveTaskCreateBean() throws Exception {
        TaskCreateListenerToTest activitiBeanToTest = (TaskCreateListenerToTest) this.activitiBeanRegistry.get("taskCreateListenerToTest");
        assertNotNull(activitiBeanToTest);
    }

    @Test
    public void shouldNotHaveTaskCreateBean() throws Exception {
        assertNull(this.activitiBeanRegistry.get("ANotActivitiBeanToTest"));
    }

}
