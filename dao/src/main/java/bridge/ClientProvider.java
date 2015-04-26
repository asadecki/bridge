package bridge;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

public class ClientProvider {

	public Client getClient() {
		Node node = nodeBuilder().node();
		return node.client();
	}
}
