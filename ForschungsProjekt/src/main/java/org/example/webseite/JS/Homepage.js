// funktion für drei linien zum drehen und öffnen des menüs
function myFunction(x) {
    var container = document.querySelector('.container');
    var menü = document.querySelector('.menü');

    //drehe die balken
    container.classList.toggle("click")

    // öffne und schließe drop menü
    menü.classList.toggle("open-drop-down")
}
