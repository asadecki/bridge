package bridge.services;

import bridge.bidding.BiddingProvider;
import bridge.domain.BalanceWithPoints;
import bridge.domain.Bidding;
import bridge.domain.BiddingColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BiddingService {

	private BiddingProvider biddingProvider;

	public BiddingService(BiddingProvider biddingProvider) {
		this.biddingProvider = biddingProvider;
	}

	public List<Bidding> getBiddings(BalanceWithPoints balance) {
		List<Bidding> biddings = new ArrayList<>();

		Optional<Bidding> c1 = biddingProvider.c1(balance);
		if (c1.isPresent()) {
			biddings.add(c1.get());
		}

		return biddings;
	}




}
