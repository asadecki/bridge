// TODO require js
function setupSolutionButtonOnclickEvent() {
    var $senderButton = document.getElementById("senderButton");
    $senderButton.onclick = function () {
        $.get("http://localhost:8080/bidding", {points: 13, numberOfClubs: 3, numberOfDiamonds: 3, numberOfHearts: 4, numberOfSpades: 3}, function (data) {
            var $solutions = $("#solutions");
            $solutions.empty();
            data.forEach(function(item) {
                $solutions.append("<p>" + item.level + " " + item.biddingColor + "</p>");
            });
        })
    }
}
