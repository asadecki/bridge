package bridge.domain.bidding;

import javax.ws.rs.QueryParam;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BiddingHistory {

	@QueryParam("biddings")
	private List<String> biddings;

	public BiddingHistory() {
	}

	public List<String> getBiddings() {
		return Optional.ofNullable(biddings).orElse(Collections.emptyList());
	}

	public void setBiddings(List<String> biddings) {
		this.biddings = biddings;
	}
}

