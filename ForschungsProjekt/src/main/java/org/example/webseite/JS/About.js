<<<<<<< HEAD

// Funktion für drei Linien zum Drehen und Öffnen des Menüs
function myFunction(x) {
    var container = document.querySelector(".container");
    var menü = document.querySelector(".menü");

    // Drehe die Balken
    container.classList.toggle("click");

    // öffnen und schließen des menüs
    menü.classList.toggle("menü-geöffnet");
}

=======

// Funktion für drei Linien zum Drehen und Öffnen des Menüs
function myFunction(x) {
    var container = document.querySelector(".container");
    var menü = document.querySelector(".menü");

    // Drehe die Balken
    container.classList.toggle("click");

    // öffnen und schließen des menüs
    menü.classList.toggle("menü-geöffnet");
}

// beim initialisieren der seite direkt mit einem bild anfangen
let slideIndex = 1;
showSlides(slideIndex);

// vorher nachher funtkion
function plusSlides(n) {
    showSlides(slideIndex += n);
}

// punkte anzeige
function currentSlide(n) {
    showSlides(slideIndex = n);
}

// funktionalität der slides
function showSlides(n) {
    let i;

    // html classen hollen
    let slides = document.getElementsByClassName("section");
    let dots = document.getElementsByClassName("dot");

    // wenn das ende der slides errecht wurde von rechts
    if (n > slides.length) {slideIndex = 1}

    // ende von links
    if (n < 1) {slideIndex = slides.length}

    // zeige nichts an
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }

    // nehme den aktuellen slide und zeige punkt als auch den slide an
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
}

>>>>>>> 25a3f21bc69b6e6aedb220022d38b1417de0891a
