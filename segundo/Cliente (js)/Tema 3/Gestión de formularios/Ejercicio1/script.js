window.addEventListener("DOMContentLoaded", () =>{
    var p = document.getElementsByTagName("p"); 
    if(confirm("¿Quieres cambiar el texto?")){
        p[0].innerHTML = "Texto Cambiado"
    }
    if(confirm("¿Quiere cambiar el color de la letra?")){
        p[0].style.color = "orange";
    }
})