var AppDispatcher = require('../dispatchers/AppDispatcher');
var Constants = require('../constants/AppConstants');

let cardValues = {
    'j': 1,
    'q': 2,
    'k': 3,
    '1': 4 // ace
};

module.exports = {

    getBidding: function () {

        console.log('BiddingActionGetter works');
        var $images = $("img");
        var colors = this.getCardsInColorMap($images);
        var pointsSum = this.getPointsSum($images);
        console.log('xxx');
        console.log(colors);
        console.log(pointsSum);
        console.log('xxx');

        $.get("http://localhost:8080/bidding", this.prepareDataMapForGet(pointsSum, colors), function (data) {
            data.forEach(function (item) {
                console.log(item.level + " " + item.biddingColor);
            });
        });

        //this.biddings = ['1c', '2s'];

        AppDispatcher.handleViewAction({
            type: Constants.ActionTypes.GET_BIDDING,
            biddings: this.biddings
        });
    },

    getCardsInColorMap: function (images) {

        var colors = {
            'C': 0,
            'D': 0,
            'H': 0,
            'S': 0
        };

        images.each(function (index, item) {
            colors[item.getAttribute("data-card-color")]++;
        });

        return colors;
    },

    getPointsSum: function (images) {

        var points = images.map(function (index, item) {
            var cardPoints = cardValues[item.getAttribute("data-card-value")] || 0;
            return cardPoints;
        });

        var pointsSum = 0;
        points.each(function (index, cardPoints) {
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
