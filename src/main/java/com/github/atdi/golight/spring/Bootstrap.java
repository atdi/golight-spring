package com.github.atdi.golight.spring;

import com.github.atdi.golight.spring.config.JerseyConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;

/**
 * Created by aurelavramescu on 29/09/15.
 */
public class Bootstrap {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8000);
        ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/");
        servletContextHandler.addServlet(DefaultServlet.class, "/");
        ServletHolder jerseyServletHolder = new ServletHolder(new ServletContainer());
        jerseyServletHolder.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getCanonicalName());
        servletContextHandler.addServlet(jerseyServletHolder, "/api/*");
        server.start();
        server.join();
    }
}
