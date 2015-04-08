package bridge;

import bridge.domain.Deck;
import bridge.health.TemplateHealthCheck;
import bridge.resources.TableResource;
import bridge.shuffler.ShufflerService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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

        Deck deck = new Deck();
        Random random = new Random();

        ShufflerService shufflerService = new ShufflerService(random);

        final TableResource tableResource = new TableResource(shufflerService, deck);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck();

        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(tableResource);
    }
}
