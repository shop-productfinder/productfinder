// Funktion für drei Linien zum Drehen und Öffnen des Menüs
function myFunction(x) {
  var container = document.querySelector(".container");
  var menü = document.querySelector(".menü");

  // Drehe die Balken
  container.classList.toggle("click");

  // öffnen und schließen des menüs
  menü.classList.toggle("menü-geöffnet");
}


// initialisieren
document.addEventListener("DOMContentLoaded", function() {
  let slideIndex = 0;
  showSlides();

  function showSlides() {
    console.log("showSlides Funktion wird aufgerufen");

    let slides = document.getElementsByClassName("meine-slides");
    let dots = document.getElementsByClassName("dot");

    // gehe durch alle slides und zeige sie nicht an
    for (let i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
    }

    slideIndex++;

    // prüfen ob man ans ende gekommen ist
    if (slideIndex > slides.length) {
      slideIndex = 1;
    }

    // gehe durch alle punkte und zeige sie nicht an
    for (let i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
    }

    // zeige jeweiligen slide und punkt an und warte 2 sekunden
    slides[slideIndex - 1].style.display = "block";
    dots[slideIndex - 1].className += " active";
    setTimeout(showSlides, 10000); // Change image every 2 seconds
  }
});