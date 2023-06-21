
/* open mobile menu */

const barMenu = document.querySelector(".bar-menu");
const navMenu = document.querySelector(".nav-menu");

barMenu.addEventListener("click", mobileMenu);

function mobileMenu() {
    barMenu.classList.toggle("active");
    navMenu.classList.toggle("active");
}

/* close mobile menu when click on link */

const navLink = document.querySelectorAll(".nav-link");

navLink.forEach(n => n.addEventListener("click", closeMenu));

function closeMenu() {
    barMenu.classList.remove("active");
    navMenu.classList.remove("active");
}

/* Basic page */

  function resetForm() {
    document.getElementById("number1").value = "";
    document.getElementById("number2").value = "";
    document.getElementById("operation").selectedIndex = 0;
    document.getElementById("decimal").value = "1";
  }

  function swap() {
    var number1Value = document.getElementById("number1").value;
    var number2Value = document.getElementById("number2").value;

    document.getElementById("number1").value = number2Value;
    document.getElementById("number2").value = number1Value;
  }

  /* Percent page */

  function resetFormFirst() {
  document.getElementById("number1").value = "";
  document.getElementById("number2").value = "";
  document.getElementById("decimal1").value = "1";
}

function swapFirst() {
  var number1Value = document.getElementById("number1").value;
  var number2Value = document.getElementById("number2").value;

  document.getElementById("number1").value = number2Value;
  document.getElementById("number2").value = number1Value;
}

function resetFormSecond() {
  document.getElementById("number3").value = "";
  document.getElementById("number4").value = "";
  document.getElementById("decimal2").value = "1";
}

function swapSecond() {
  var number3Value = document.getElementById("number3").value;
  var number4Value = document.getElementById("number4").value;

  document.getElementById("number3").value = number4Value;
  document.getElementById("number4").value = number3Value;
}

function resetFormThird() {
  document.getElementById("number5").value = "";
  document.getElementById("number6").value = "";
  document.getElementById("decimal3").value = "1";
}

function swapThird() {
  var number5Value = document.getElementById("number5").value;
  var number6Value = document.getElementById("number6").value;

  document.getElementById("number5").value = number6Value;
  document.getElementById("number6").value = number5Value;
}

/* Average page */

function resetFormAverage() {
  document.getElementById("averageNumbers").value = "";
  document.getElementById("averageDecimal").value = "1";
}

function resetFormMedian() {
  document.getElementById("medianNumbers").value = "";
  document.getElementById("medianDecimal").value = "1";
}

/* Factorial page */

function resetFormFactorial() {
  document.getElementById("number").value = "";
}