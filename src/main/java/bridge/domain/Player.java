package bridge.domain;

public class Player {

    private PlayerPlace name;
    private int position;
    private Hand hand;

    public Player(PlayerPlace name, int position) {
        this.name = name;
        this.position = position;
        this.hand = new Hand();
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }


    public PlayerPlace getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Hand getHand() {
        return hand;
    }
}
