// Funktion für drei Linien zum Drehen und Öffnen des Menüs
function myFunction(x) {
    var container = document.querySelector(".container");
    var menü = document.querySelector(".menü");

    // Drehe die Balken
    container.classList.toggle("click");

    // öffnen des menüs
    menü.classList.toggle("open-drop-down")
}
