function additionFunc(p1, p2) {
    return console.log(p1 + p2);
}

additionFunc(5, 6);

setTimeout(loadingFunc, 3000);

function loadingFunc() {
    document.getElementById("load").innerHTML = "My name is Dillon Juriansz";
}

setInterval(timeFunc, 1000);

function timeFunc() {
    document.getElementById("time").innerHTML = new Date().toLocaleTimeString();
}
