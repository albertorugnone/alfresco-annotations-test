package it.cosenonjaviste.alfresco.annotations;

import com.tradeshift.test.remote.Remote;
import com.tradeshift.test.remote.RemoteTestRunner;
import it.cosenonjaviste.alfresco.annotations.test.*;
import it.omniagroup.product.rule.JUnitRemoteEndpoint;
import org.activiti.engine.delegate.TaskListener;
import org.alfresco.repo.workflow.activiti.tasklistener.TaskCompleteListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by albertorugnone on 28/03/16.
 */
@RunWith(RemoteTestRunner.class)
@Remote(runnerClass = SpringJUnit4ClassRunner.class, endpoint = JUnitRemoteEndpoint.URL)
@ContextConfiguration(classes=TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class ActivitiBeanIntegrationTest {

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
