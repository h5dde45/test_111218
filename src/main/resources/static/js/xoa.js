for (var i = 0; i < 9; i++) {
    document.getElementById('game').innerHTML += '<div class="block" id="' + i + '"></div> '
}

var hod = 0;
var playerNumber = document.getElementById("playerNumber");
playerNumber.innerHTML = "Ход 1 игрока";

document.getElementById('game').onclick = function (event) {

    if (event.target.className == 'block') {
        if (hod % 2 == 0) {
            event.target.innerHTML = 'X';
        } else {
            event.target.innerHTML = 'O';
        }

        if (event.target.style.pointerEvents != 'none') {
            checkWinner(event.target.id, function (data) {
                showX(data);
                event.target.style.pointerEvents = 'none';
            });
        }

        hod++;

        if (hod % 2 == 0) {
            playerNumber.innerHTML = "Ход 1 игрока"
        } else {
            playerNumber.innerHTML = "Ход 2 игрока"
        }
    }
};

var winner = document.getElementById("winner");
var showX = function (x) {
    winner.innerHTML = x;
    if (x != '') {
        document.getElementById('game').style.pointerEvents = 'none';
    }
};

function checkWinner(num, func) {
    var getter = new XMLHttpRequest();
    getter.open('GET', 'http://localhost:8080/xo/a/' + num + '/' + hod, true);
    getter.onreadystatechange = function () {
        if (getter.readyState == 4) {
            func(getter.responseText);
        }
    };
    getter.send();
}