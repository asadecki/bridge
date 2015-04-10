// TODO require js
function setupSolutionButtonOnclickEvent() {
    var xxx = document.getElementById("senderButton");
    console.log('zxczxc');
    xxx.onclick = function () {
        $.get("http://localhost:8080/bidding", {points: 5}, function (data) {
            alert(data);
        });
    }
}

function init() {
    // setupSolutionButtonOnclickEvent();
}

init();

$(document).ready(function () {

});
