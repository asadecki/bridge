package bridge.domain;

public class Condition {

	private String description;
	private Limit clubs;
	private Limit diamonds;
	private Limit hearths;
	private Limit spades;
	private Limit points;

	public Condition() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Limit getClubs() {
		return clubs;
	}

	public void setClubs(Limit clubs) {
		this.clubs = clubs;
	}

	public Limit getDiamonds() {
		return diamonds;
	}

	public void setDiamonds(Limit diamonds) {
		this.diamonds = diamonds;
	}

	public Limit getHearths() {
		return hearths;
	}

	public void setHearths(Limit hearths) {
		this.hearths = hearths;
	}

	public Limit getSpades() {
		return spades;
	}

	public void setSpades(Limit spades) {
		this.spades = spades;
	}

	public Limit getPoints() {
		return points;
	}

	public void setPoints(Limit points) {
		this.points = points;
	}
}
