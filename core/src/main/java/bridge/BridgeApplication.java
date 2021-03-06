package bridge;

import bridge.bidding.BiddingProvider;
import bridge.cards.CardsDao;
import bridge.domain.Deck;
import bridge.health.TemplateHealthCheck;
import bridge.resources.BiddingResource;
import bridge.resources.TableResource;
import bridge.services.BiddingService;
import bridge.services.TableService;
import bridge.shuffler.ShuffleAndDivideService;
import bridge.shuffler.ShufflerService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.elasticsearch.client.Client;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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

		BiddingProvider biddingProvider = new BiddingProvider();

		Client elasticSearchClientProvider = new ClientProvider().getClient();

		CardsDao cardsDao = new CardsDao(elasticSearchClientProvider);

		ShufflerService shufflerService = new ShuffleAndDivideService(cardsDao);
		TableService tableService = new TableService(shufflerService, deck);
		BiddingService biddingService = new BiddingService(biddingProvider);

		final TableResource tableResource = new TableResource(tableService);
		final BiddingResource biddingResource = new BiddingResource(biddingService);

		final TemplateHealthCheck healthCheck = new TemplateHealthCheck();

		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(tableResource);
		environment.jersey().register(biddingResource);
	}
}
