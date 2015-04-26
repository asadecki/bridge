package bridge.shuffler

import bridge.domain.Deck
import spock.lang.Specification

class ShufflerSpec extends Specification {

    ShufflerService shuffler
    Deck deck

    def setup() {
        shuffler = new ShuffleAndDivideService()
        deck = new Deck()

    }

    def "Shuffler should distribute 52 hands to 4 hands"() {
        when:
        def table = shuffler.shuffle(deck)

        def playerNorth = table.getPlayerNorth()
        def playerSouth = table.getPlayerSouth()
        def playerEast = table.getPlayerEast()
        def playerWest = table.getPlayerWest()

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