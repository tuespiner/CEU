var sumar;
var restar;
var valor = 5;
var p;
cambiarValor = (e) =>{
    if(e.target.value == "sumar"){
        valor++;
    }else{
        valor--;
    }
    p.innerHTML = valor;
}
inicio = () =>{
    sumar = document.getElementById("sumar");
    restar = document.getElementById("restar");
    p = document.getElementById("div");
    sumar.addEventListener("click", cambiarValor);
    restar.addEventListener("click", cambiarValor);
}

window.addEventListener("DOMContentLoaded", inicio);