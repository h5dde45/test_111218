for (var i = 0; i < 9; i++) {
    document.getElementById('game').innerHTML += '<div class="block" id="' + i + '"></div> '
}

var hod = 0;
var numDiv = 0;
var playerNumber = document.getElementById("playerNumber");
playerNumber.innerHTML = "Ход 1 игрока";

document.getElementById('game').onclick = function (event) {

    if (event.target.className == 'block') {
        event.target.innerHTML = 'X';

        if (event.target.style.pointerEvents != 'none') {
            checkWinner(event.target.id, function (data) {
                showX(data);
                event.target.style.pointerEvents = 'none';
            });
        }

        playerNumber.innerHTML = "Ход AI";
        hod++;
    }
};

document.getElementById('batt').onclick = function (event) {

        numberRequest(function (data) {
            numDivData(data);
        });

        checkWinner(numDiv, function (data) {
            showX(data);
        });

        playerNumber.innerHTML = "Ход 1 игрока";
        hod++;

};



var winner = document.getElementById("winner");
var showX = function (x) {
    winner.innerHTML = x;
    if (x != '') {
        document.getElementById('game').style.pointerEvents = 'none';
    }
};

var numDivData = function (x) {
    document.getElementById(x).innerHTML = 'O';
    numDiv = x;
};

function checkWinner(num, func) {
    var getter = new XMLHttpRequest();
    getter.open('GET', 'http://localhost:8080/xo/b/' + num + '/' + hod , true);
    getter.onreadystatechange = function () {
        if (getter.readyState == 4) {
            func(getter.responseText);
        }
    };
    getter.send();
}

function numberRequest(func) {
    var getter = new XMLHttpRequest();
    getter.open('GET', 'http://localhost:8080/xo/b/ai' , true);
    getter.onreadystatechange = function () {
        if (getter.readyState == 4) {
            func(getter.responseText);
        }
    };
    getter.send();
}