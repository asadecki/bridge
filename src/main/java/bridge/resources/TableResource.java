package bridge.resources;

import bridge.domain.Deck;
import bridge.domain.Table;
import bridge.shuffler.ShufflerService;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/table")
@Produces(MediaType.APPLICATION_JSON)
public class TableResource {

    private ShufflerService shufflerService;
    private Deck deck;

    public TableResource(ShufflerService shufflerService, Deck deck) {
        this.shufflerService = shufflerService;
        this.deck = deck;
    }

    @GET
    @Timed
    public Table table() {
        return shufflerService.shuffle(deck);
    }
}