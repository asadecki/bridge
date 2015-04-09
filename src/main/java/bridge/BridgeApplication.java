package bridge;

import bridge.domain.Deck;
import bridge.health.TemplateHealthCheck;
import bridge.resources.TableResource;
import bridge.shuffler.ShufflerService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;
import java.util.Random;

public class BridgeApplication extends Application<BridgeConfiguration> {

    public static void main(String[] args) throws Exception {
        new BridgeApplication().run(args);
    }

    @Override
    public String getName() {
        return "bridge";
    }

    @Override
    public void initialize(Bootstrap<BridgeConfiguration> bootstrap) {
    }

    @Override
    public void run(BridgeConfiguration configuration,
                    Environment environment) {

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
            environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        Deck deck = new Deck();
        Random random = new Random();

        ShufflerService shufflerService = new ShufflerService(random);

        final TableResource tableResource = new TableResource(shufflerService, deck);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck();


        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(tableResource);
    }
}
