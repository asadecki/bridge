package bridge.resources;

import bridge.domain.Card;
import bridge.domain.Deck;
import bridge.domain.PlayerPlace;
import bridge.domain.Table;
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

    private ShufflerService shufflerService;
    private Deck deck;

    public TableResource(ShufflerService shufflerService, Deck deck) {
        this.shufflerService = shufflerService;
        this.deck = deck;
    }

    @GET
    @Timed
    public Table getTable() {
        return shufflerService.shuffle(deck);
    }

    @GET
    @Timed
    @Path("/{player}")
    public List<Card> getHand(@PathParam("player") String playerName) {
        return shufflerService.shuffle(deck).getPlayers()
            .stream()
            .filter(player -> player.getName().equals(PlayerPlace.valueOf(playerName)))
            .findFirst()
            .get()
            .getHand()
            .getCards();
    }
}