package com.github.atdi.golight.spring.config;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.spring.bridge.api.SpringBridge;
import org.jvnet.hk2.spring.bridge.api.SpringIntoHK2Bridge;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;

/**
 * Created by aurelavramescu on 29/09/15.
 */
public class JerseyConfig extends ResourceConfig {

    @Inject
    public JerseyConfig(ServiceLocator serviceLocator) {
        SpringBridge.getSpringBridge().initializeSpringBridge(serviceLocator);
        SpringIntoHK2Bridge springBridge = serviceLocator.getService(SpringIntoHK2Bridge.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultConfig.class);
        springBridge.bridgeSpringBeanFactory(context);
        packages("com.github.atdi.golight.spring.resources");
    }
}
