function setupSolutionButtonOnclickEvent () {
    var xxx = document.getElementById("senderButton");
    xxx.onclick = function() {
        $.get( "http://localhost:8080/bidding", {points: 5}, function( data ) {
            alert( data );
        });
    }
}

(function(){
    setupSolutionButtonOnclickEvent();
})();