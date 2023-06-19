
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