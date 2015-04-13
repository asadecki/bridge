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

		add1LevelBiddings(balance, biddings);

		if (biddings.isEmpty()) {
			biddings.add(new Bidding(0, BiddingColor.PAS));
		}
		return biddings;
	}

	private void add1LevelBiddings(BalanceWithPoints balance, List<Bidding> biddings) {
		addBidding(biddings, biddingProvider.c1(balance));
		addBidding(biddings, biddingProvider.d1(balance));
		addBidding(biddings, biddingProvider.h1(balance));
		addBidding(biddings, biddingProvider.s1(balance));
		addBidding(biddings, biddingProvider.nt1(balance));
	}

	private void addBidding(List<Bidding> biddings, Optional<Bidding> optionalBidding) {
		if (optionalBidding.isPresent()) {
			biddings.add(optionalBidding.get());
		}
	}


}
