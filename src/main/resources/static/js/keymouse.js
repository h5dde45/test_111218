document.onkeypress = function (event) {
    if (!event.shiftKey && !event.altKey && !event.ctrlKey
        && (event.charCode > 47 && event.charCode < 58)) {
        checkK(event.charCode, function (data) {
            showK(data);
        });
    }
};
var kCode = document.getElementById('numCode');
var showK = function (x) {
    kCode.innerHTML = x;
};

function checkK(num, func) {
    var getter = new XMLHttpRequest();
    getter.open('GET', 'http://localhost:8080/keymouse/k/' + num, true);
    getter.onreadystatechange = function () {
        if (getter.readyState == 4) {
            func(getter.responseText);
        }
    };
    getter.send();
}

let tableMouse = document.getElementById("tableMouse");
tableMouse.onclick = function (event) {
    checkM(event.clientX, event.clientY, function (data) {
        showM(data);
    });
};
var mCode = document.getElementById('mCode');
var showM = function (x) {
    mCode.innerHTML = x;
};

function checkM(x, y, func) {
    var getter = new XMLHttpRequest();
    getter.open('GET', 'http://localhost:8080/keymouse/m/' + x + '/' + y, true);
    getter.onreadystatechange = function () {
        if (getter.readyState == 4) {
            func(getter.responseText);
        }
    };
    getter.send();
}