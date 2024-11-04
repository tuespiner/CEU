var input;
var div;
funcion = (e) =>{
    div.innerHTML = e.target.value;
}
inicio = () =>{
    input = document.getElementsByTagName("input");
    div = document.getElementById("div");
    for(elements of input){
        elements.addEventListener("click", funcion)
    }

}
window.addEventListener("DOMContentLoaded", inicio);