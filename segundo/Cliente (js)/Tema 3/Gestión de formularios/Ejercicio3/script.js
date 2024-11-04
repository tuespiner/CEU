var boton;
var checkbox;
window.addEventListener("DOMContentLoaded", () =>{
    boton = document.getElementById("boton");
    checkbox = document.getElementById("checkbox");
    boton.addEventListener("click", () =>{
        checkbox.checked = true;
    })
})