package bridge.resources;

import bridge.domain.BalanceWithPoints;
import bridge.domain.Bidding;
import bridge.domain.BiddingFullInfo;
import bridge.services.BiddingService;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/bidding")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BiddingResource {

	private BiddingService biddingService;

	public BiddingResource(BiddingService biddingService) {
		this.biddingService = biddingService;
	}

	@GET
	@Timed
	public Response getBidding(@BeanParam BalanceWithPoints balance) {
		List<Bidding> biddings = biddingService.getBiddings(balance);
		return Response.ok(biddings).build();
	}
}