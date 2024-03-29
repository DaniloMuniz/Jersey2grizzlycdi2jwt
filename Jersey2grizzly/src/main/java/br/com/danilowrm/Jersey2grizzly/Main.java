package br.com.danilowrm.Jersey2grizzly;

import com.google.common.flogger.FluentLogger;
import com.google.common.flogger.LoggerConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.threadpool.GrizzlyExecutorService;
import org.glassfish.grizzly.threadpool.ThreadPoolConfig;
import org.glassfish.jersey.grizzly2.servlet.GrizzlyWebContainerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Main class.
 *
 */
public class Main {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
     * application.
     *
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() throws IOException {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        final ResourceConfig rc = new ResourceConfig()
                .setClassLoader(Thread
                        .currentThread()
                        .getContextClassLoader())
                .packages("br.com.danilowrm.Jersey2grizzly")
                .register(new LoggingFeature(Logger.getGlobal(),
                        LoggingFeature.Verbosity.PAYLOAD_ANY))
                .register(JacksonFeature.class)
                .register(MoxyXmlFeature.class)
                .register(MultiPartFeature.class);
//                .register(new WebServiceBinderCDI());
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
//        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
//        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
        Map<String, String> initParams = new LinkedHashMap<>();
        Map<String, String> contextInitParams = new LinkedHashMap<>();
        HttpServer httpServer = GrizzlyWebContainerFactory.create(URI.create(BASE_URI), 
                new ServletContainer(rc),
                initParams, contextInitParams);
        // create the thread pool configuration 
        // reconfigure the thread pool 
        NetworkListener listener = httpServer.getListeners().iterator().next();
        ThreadPoolConfig thx = listener.getTransport().getWorkerThreadPoolConfig(); // no thx a gente epode configurar um monte de coisas!!! 
        thx.setCorePoolSize(10);
        thx.setMaxPoolSize(500);
        GrizzlyExecutorService threadPool = (GrizzlyExecutorService) listener.getTransport().getWorkerThreadPool();
        threadPool.reconfigure(thx);
        return httpServer;
    }

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final HttpServer server = startServer();
        LoggerConfig.of(logger).setLevel(Level.INFO);
        LoggerConfig.getPackageConfig(Main.class);
        logger.atInfo().log("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI
        );
        System.in.read();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                server.shutdownNow();
            }
        }));
        server.start();

        Thread.currentThread().join();
    }
}
