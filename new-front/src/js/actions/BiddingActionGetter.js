var AppDispatcher = require('../dispatchers/AppDispatcher');
var Constants = require('../constants/AppConstants');

let cardValues = {
    'JACK': 1,
    'QUEEN': 2,
    'KING': 3,
    'ACE': 4 // ace
};

module.exports = {

    getBidding: function (event) {
        var $playerPanel = event.target.closest(".player-panel");
        var $images = $playerPanel.querySelectorAll("img");
        var imagesArray  = [].slice.call($images);

        var colors = this.getCardsInColorMap(imagesArray);
        var pointsSum = this.getPointsSum(imagesArray);

        $.ajax({
            url: 'http://localhost:8080/bidding',
            dataType: 'json',
            data: this.prepareDataMapForGet(pointsSum, colors),
            async: false,
            success: function (data) {
                // FIXME only one bidding should be returned
                this.biddings = data[0];
            }.bind(this),
            error: function (xhr, status, err) {
            }.bind(this)
        });


        AppDispatcher.handleViewAction({
            type: Constants.ActionTypes.GET_BIDDING,
            biddings: this.biddings,
            player: event.target.id.replace("bidding-list-", "")
        });
    },

    getCardsInColorMap: function (images) {

        var colors = {
            'C': 0,
            'D': 0,
            'H': 0,
            'S': 0
        };

        images.forEach(function (item) {
            colors[item.getAttribute("data-card-color")]++;
        });

        return colors;
    },

    getPointsSum: function (images) {

        var points = images.map(function (item) {
            var cardPoints = cardValues[item.getAttribute("data-card-value")] || 0;
            return cardPoints;
        });

        var pointsSum = 0;
        points.forEach(function (cardPoints) {
            pointsSum += cardPoints
        });

        return pointsSum;
    },

    prepareDataMapForGet: function (pointsSum, colors) {
        return {
            points: pointsSum,
            numberOfClubs: colors["C"],
            numberOfDiamonds: colors["D"],
            numberOfHearts: colors["H"],
            numberOfSpades: colors["S"]
        };
    }
};
