package it.cosenonjaviste.alfresco.annotations.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by albertorugnone on 28/03/16.
 */
@Configuration
@ComponentScan("it.cosenonjaviste.alfresco.annotations.test") // search the com.company package for @Component classes
@ImportResource("classpath:alfresco/application-context.xml")
public class TestConfiguration {
}
