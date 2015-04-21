package bridge.domain;

import java.util.List;

public class BiddingFullInfo {

	private Bidding convention;
	private String conventionName;
	private String type;
	private List<Condition> conditions;
	private List<BiddingFullInfo> answers;

	public BiddingFullInfo() {
	}

	public Bidding getConvention() {
		return convention;
	}

	public void setConvention(Bidding convention) {
		this.convention = convention;
	}

	public String getConventionName() {
		return conventionName;
	}

	public void setConventionName(String conventionName) {
		this.conventionName = conventionName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<BiddingFullInfo> getAnswers() {
		return answers;
	}

	public void setAnswers(List<BiddingFullInfo> answers) {
		this.answers = answers;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
}
