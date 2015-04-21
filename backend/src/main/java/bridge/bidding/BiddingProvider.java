package bridge.bidding;

import bridge.domain.BalanceWithPoints;
import bridge.domain.Bidding;
import bridge.domain.BiddingFullInfo;
import bridge.domain.Condition;
import bridge.domain.Limit;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BiddingProvider {

	public static final String BIDDINGS_JSON_FILE = "./backend/src/main/resources/biddings.json";

	public List<Bidding> getBiddings(BalanceWithPoints balance) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			BiddingFullInfo biddingFullInfo = mapper.readValue(new File(BIDDINGS_JSON_FILE), BiddingFullInfo.class); // TODO this mapping should be done only one
			return biddingFullInfo
				.getAnswers()
				.stream()
				.map(answer -> getBidding(answer, balance))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	private Optional<Bidding> getBidding(BiddingFullInfo answer, BalanceWithPoints balance) {
		Bidding convention = answer.getConvention();
		if (answer.getConditions().stream().filter(cond -> checkConditions(cond, balance)).findAny().isPresent()) {
			return Optional.of(convention);
		}

		return Optional.empty();
	}

	private boolean checkConditions(Condition condition, BalanceWithPoints balance) {
		return checkLimit(condition.getClubs(), balance.getNumberOfClubs()) &&
			checkLimit(condition.getDiamonds(), balance.getNumberOfDiamonds()) &&
			checkLimit(condition.getHearths(), balance.getNumberOfHearts()) &&
			checkLimit(condition.getSpades(), balance.getNumberOfSpades()) &&
			checkLimit(condition.getPoints(), balance.getPoints());
	}

	private boolean checkLimit(Limit limit, int value) {
		return limit.getMax() >= value && value >= limit.getMin();
	}
}
