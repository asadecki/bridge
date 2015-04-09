package bridge.resources;

import bridge.domain.BalanceWithPoints;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/power")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HandPowerResource {

	public HandPowerResource() {
	}

	@GET
	@Timed
	public Response getBidding(@BeanParam BalanceWithPoints balance) {
		return Response.ok().build();
	}
}