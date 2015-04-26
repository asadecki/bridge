package bridge;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import java.io.IOException;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

public class BasicClient {

	public static void main(String[] args) throws IOException {
		// on startup

		Node node = nodeBuilder().node();
		Client client = node.client();


		IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
			.setSource(jsonBuilder()
					.startObject()
					.field("user", "kimchy")
					.field("postDate", new Date())
					.field("message", "trying out Elasticsearch")
					.endObject()
			)
			.execute()
			.actionGet();

		System.out.println(response);
	}

}
