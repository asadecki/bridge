var AppDispatcher = require('../dispatchers/AppDispatcher');
var Constants = require('../constants/AppConstants');
var BiddingButtonHelper = require('../helpers/BiddingButtonHelper');


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
        var imagesArray = [].slice.call($images);

        var colors = this.getCardsInColorMap(imagesArray);
        var pointsSum = this.getPointsSum(imagesArray);

        var $biddingsNorth = $(".list-group-item.north");
        var $biddingsSouth = $(".list-group-item.south");
        var biddingsArrayNorth = [].slice.call($biddingsNorth);
        var biddingsArraySouth = [].slice.call($biddingsSouth);

        var mergedBiddings = this.mergeBiddings(biddingsArrayNorth, biddingsArraySouth);

        $.ajax({
            traditional: true,
            url: 'http://localhost:8080/bidding',
            dataType: 'json',
            data: this.prepareDataMapForGet(pointsSum, colors, mergedBiddings),
            async: false,
            success: function (data) {
                this.biddings = data[0]; // FIXME backend should return only one bidding
                if (mergedBiddings.length > 0 && data.length == 0) {
                    BiddingButtonHelper.hideBiddingButtons();
                }
            }.bind(this),
            error: function (xhr, status, err) {
            }.bind(this)
        });

        AppDispatcher.handleViewAction({
            type: Constants.ActionTypes.GET_BIDDING,
            biddings: this.biddings,
            player: event.target.id.replace('bidding-list-', '')
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
            colors[item.getAttribute('data-card-color')]++;
        });

        return colors;
    },

    mergeBiddings: function (biddingsArrayNorth, biddingsArraySouth) {
        var merged = [];

        for (var index = 0; index < biddingsArrayNorth.length; index++) {
            var shortCutN = this.shortenBidding(biddingsArrayNorth[index].innerHTML);
            merged.push(shortCutN);
            if (biddingsArraySouth[index]) {
                var shortCutS = this.shortenBidding(biddingsArraySouth[index].innerHTML);
                merged.push(shortCutS);
            }
        }

        return merged;
    },

    shortenBidding: function (biddingText) {
        var level = biddingText.substring(0, 1);
        var color = biddingText.substring(1, biddingText.length);
        var shortCut = level;

        if (color == 'PAS') {
            return 'PAS';
        }

        if (color == 'NOTRUMP') {
            shortCut += 'nt';
        } else {
            shortCut += color.substring(0, 1);
        }
        return shortCut;
    },

    getPointsSum: function (images) {

        var points = images.map(function (item) {
            var cardPoints = cardValues[item.getAttribute('data-card-value')] || 0;
            return cardPoints;
        });

        var pointsSum = 0;
        points.forEach(function (cardPoints) {
            pointsSum += cardPoints
        });

        return pointsSum;
    },

    prepareDataMapForGet: function (pointsSum, colors, biddings) {
        return {
            biddings: biddings,
            points: pointsSum,
            numberOfClubs: colors['C'],
            numberOfDiamonds: colors['D'],
            numberOfHearts: colors['H'],
            numberOfSpades: colors['S']
        };
    }
};
