var AppDispatcher = require('../dispatchers/AppDispatcher');
var Constants = require('../constants/AppConstants');

module.exports = {

    fetchAllCards: function () {

        $.ajax({
            url: 'http://localhost:8080/hand',
            dataType: 'json',
            async: false,
            success: function (data) {
                this.cards = data;
            }.bind(this),
            error: function (xhr, status, err) {
                console.error('blah');
                this.cards = {
                    playerNorth: {
                        hand: {
                            cards : [{color: 'CLUB', cardValue: 'KING'}]
                        }
                    }
                };
            }.bind(this)
        });
        AppDispatcher.handleViewAction({
                type: Constants.ActionTypes.FETCH_ALL_CARDS,
                cards: this.cards
            }
        );
    },

    clearList: function () {
        console.warn('clearList action not yet implemented...');
    },

    completeTask: function (task) {
        console.warn('completeTask action not yet implemented...');
    }
}
;
