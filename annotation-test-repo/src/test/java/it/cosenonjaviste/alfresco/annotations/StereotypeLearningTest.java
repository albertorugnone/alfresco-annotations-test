package it.cosenonjaviste.alfresco.annotations;

import it.cosenonjaviste.alfresco.annotations.test.ActivitiBeanToTest;
import it.cosenonjaviste.alfresco.annotations.test.TaskCreateListenerToTest;
import javassist.tools.reflect.Reflection;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by albertorugnone on 28/03/16.
 */
public class StereotypeLearningTest {

    final private static Logger LOGGER = Logger.getLogger(StereotypeLearningTest.class.getCanonicalName());
    @Test
    public void shouldHasManyAnnotations() throws Exception {
        final TaskCreateListenerToTest taskCreateToTest = new TaskCreateListenerToTest();
        final Annotation[] annotations = taskCreateToTest.getClass().getAnnotations();
        LOGGER.info(Arrays.toString(annotations));


        final ActivitiBeanToTest activitiBeanToTest = new ActivitiBeanToTest();

        final Annotation[] annotations2 = activitiBeanToTest.getClass().getAnnotations();
        LOGGER.info(Arrays.toString(annotations2));


    }
}
