package bridge.shuffler

import bridge.domain.Deck
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class ShufflerSpec extends Specification {

    Shuffler shuffler
    Deck deck
    Random random

    def setup() {
        random = new Random()
        shuffler = new Shuffler(random)
        deck = new Deck()

    }

    def "Shuffler should distribute 52 hands to 4 hands"() {
        when:
        def table = shuffler.shuffle(deck)

        def playerNorth = table.players.get(0)
        def playerSouth = table.players.get(1)
        def playerEast = table.players.get(2)
        def playerWest = table.players.get(3)

        def cardsNorth = playerNorth.getHand().getCards()
        def cardsSouth = playerSouth.getHand().getCards()
        def cardsEast = playerEast.getHand().getCards()
        def cardsWest = playerWest.getHand().getCards()

        then:
        cardsNorth.size() == 13
        cardsSouth.size() == 13
        cardsEast.size() == 13
        cardsWest.size() == 13
    }
}