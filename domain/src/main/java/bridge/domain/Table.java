package bridge.domain;

import java.util.Date;

public class Table {


	private Player playerSouth;
	private Player playerNorth;
	private Player playerEast;
	private Player playerWest;

	public Table() {
		init();
	}

	private void init() {
		playerSouth = new Player(PlayerPlace.SOUTH, 0);
		playerNorth = new Player(PlayerPlace.NORTH, 1);
		playerEast = new Player(PlayerPlace.EAST, 2);
		playerWest = new Player(PlayerPlace.WEST, 3);
	}

	public Player getPlayerSouth() {
		return playerSouth;
	}

	public Player getPlayerNorth() {
		return playerNorth;
	}

	public Player getPlayerEast() {
		return playerEast;
	}

	public Player getPlayerWest() {
		return playerWest;
	}

}
