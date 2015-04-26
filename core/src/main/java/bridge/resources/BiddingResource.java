package bridge.resources;

import bridge.domain.BalanceWithPoints;
import bridge.domain.bidding.Bidding;
import bridge.domain.BiddingHistory;
import bridge.services.BiddingService;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
	public Response getBidding(@BeanParam BalanceWithPoints balance, @BeanParam BiddingHistory biddingHistory) {
		List<Bidding> biddings = biddingService.getBiddings(balance, biddingHistory);
		return Response.ok(biddings).build();
	}
}