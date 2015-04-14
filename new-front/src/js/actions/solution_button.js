// TODO remove this file - put this functions in proper place

var cardValues = {
    'j': 1,
    'q': 2,
    'k': 3,
    '1': 4 // ace
};


function setupSolutionButtonOnclickEvent() {
    var $senderButton = document.getElementById("senderButton");
    $senderButton.onclick = function () {

        var $images = $("img");
        var colors = getCardsInColorMap($images);
        var pointsSum = getPointsSum($images);

        $.get("http://localhost:8080/bidding", prepareDataMapForGet(pointsSum, colors), function (data) {
            var $solutions = $("#solutions");
            $solutions.empty();
            data.forEach(function (item) {
                $solutions.append("<p>" + (item.level == 0 ? "" : item.level) + " " + item.biddingColor + "</p>");
            });
        });
    }
}

function getCardsInColorMap($images) {

    var colors = {
        'C': 0,
        'D': 0,
        'H': 0,
        'S': 0
    };

    $images.each(function (index, item) {
        colors[item.getAttribute("data-card-color")]++;
    });

    return colors;
}

function getPointsSum($images) {

    var points = $images.map(function (index, item) {
        var cardPoints = cardValues[item.getAttribute("data-card-value")] || 0;
        return cardPoints;
    });

    var pointsSum = 0;
    points.each(function (index, cardPoints) {
        pointsSum += cardPoints
    });

    return pointsSum;
}

function prepareDataMapForGet(pointsSum, colors) {
    return {
        points: pointsSum,
        numberOfClubs: colors["C"],
        numberOfDiamonds: colors["D"],
        numberOfHearts: colors["H"],
        numberOfSpades: colors["S"]
    };
}
