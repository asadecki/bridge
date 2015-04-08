package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Table {

    private List<Player> players;

    public Table() {
        players = new ArrayList<>();
        init();
    }

    public Optional<Player> findPlayerByPosition(int position) {
        return players.stream().filter(player -> player.getPosition() == position).findFirst();
    }

    public List<Player> getPlayers() {
        return Optional.ofNullable(players).orElse(Collections.emptyList());
    }

    private void init() {
        addPlayer(0, PlayerPlace.NORTH);
        addPlayer(1, PlayerPlace.SOUTH);
        addPlayer(2, PlayerPlace.EAST);
        addPlayer(3, PlayerPlace.WEST);
    }

    private void addPlayer(int position, PlayerPlace place) {
        players.add(new Player(place, position));
    }


}
