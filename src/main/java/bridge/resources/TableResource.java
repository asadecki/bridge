package bridge.resources;

import bridge.domain.Card;
import bridge.domain.Deck;
import bridge.domain.PlayerPlace;
import bridge.domain.Table;
import bridge.services.TableService;
import bridge.shuffler.ShufflerService;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hand")
@Produces(MediaType.APPLICATION_JSON)
public class TableResource {

	private TableService tableService;

    public TableResource(TableService tableService) {
	    this.tableService = tableService;
    }

    @GET
    @Timed
    public Table getTable() {
        return tableService.getTable();
    }

    @GET
    @Timed
    @Path("/{player}")
    public List<Card> getCards(@PathParam("player") String playerName) {
		return tableService.getHand(playerName).getCards();
    }
}