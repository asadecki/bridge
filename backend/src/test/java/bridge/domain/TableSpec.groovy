package bridge.domain

import spock.lang.Specification

class TableSpec extends Specification {

    Table table

    def setup() {
        table = new Table()
    }

    def "Players should be properly set up"() {
        when:
        Player player0 = table.getPlayerSouth()
        Player player1 = table.getPlayerNorth()
        Player player2 = table.getPlayerEast()
        Player player3 = table.getPlayerWest()

        then:

        player0.getPosition() == 0
        player0.getName().equals(PlayerPlace.SOUTH)

        player1.getPosition() == 1
        player1.getName().equals(PlayerPlace.NORTH)

        player2.getPosition() == 2
        player2.getName().equals(PlayerPlace.EAST)

        player3.getPosition() == 3
        player3.getName().equals(PlayerPlace.WEST)
    }
}