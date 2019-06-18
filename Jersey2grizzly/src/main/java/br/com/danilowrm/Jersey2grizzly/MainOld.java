/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly;

import br.com.danilowrm.Jersey2grizzly.conf.InitApplication;
import br.com.danilowrm.Jersey2grizzly.conf.WebServiceBinderCDI;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jaxb.internal.XmlCollectionJaxbProvider.App;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.jboss.weld.environment.se.Weld;

/**
 *
 * @author washington-muniz
 */
public class MainOld {

    private static final URI BASE_URI = URI.create("http://localhost:8080/api/");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Jersey sCDI Example App");

//            final Weld weld = new Weld();c
//            weld.initialize();
//            weld.initialize();
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createJaxRsApp(), false);
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    server.shutdownNow();
//                    weld.shutdown();
                }
            }));
            server.start();

            System.out.println(String.format("Application started.\nTry out %s%s\nStop the application using CTRL+C",
                    BASE_URI, "application.wadl"));

            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ResourceConfig createJaxRsApp() {
//        ResourceConfig resourceConfig = new ResourceConfig(new InitApplication().getClasses());
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages("br.com.danilowrm.Jersey2grizzly");
        // Features.
        //resourceConfig.register(MvcBeanValidationFeature.class);
        // Providers.
        resourceConfig.register(LoggingFeature.class);
        resourceConfig.register(WebServiceBinderCDI.class);
        return resourceConfig;
    }

}
