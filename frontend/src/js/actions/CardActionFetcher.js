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

            }.bind(this)
        });

        AppDispatcher.handleViewAction({
                type: Constants.ActionTypes.FETCH_ALL_CARDS,
                cards: this.cards
            }
        );
    },

    getInitState: function () {
        return {
            cards: {
                playerNorth: {
                    hand: {
                        cards: [
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'}
                        ]
                    }
                },
                playerSouth: {
                    hand: {
                        cards: [
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'},
                            {color: '', cardValue: 'none'}
                        ]
                    }
                }
            }

        }
    }
};

