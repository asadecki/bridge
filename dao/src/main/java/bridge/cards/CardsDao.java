package bridge.cards;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

import java.sql.Timestamp;
import java.util.Date;

public class CardsDao {

	private Client client;

	public CardsDao(Client client) {
		this.client = client;
	}

	public String insertTable(String table) {

		IndexResponse response = client.prepareIndex("games", "table")
			.setSource(table)
			.execute()
			.actionGet();

		return response.getId();
	}
}
