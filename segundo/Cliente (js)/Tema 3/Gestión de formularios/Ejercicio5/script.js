var inputs;
var button;
var cad = "Los radio seleccionados estan en la posicion "
window.addEventListener("DOMContentLoaded", () =>{
    button = document.getElementsByTagName("button")[0];
    button.addEventListener("click", () =>{
        inputs = document.getElementsByTagName("input");
        for(elements of inputs){
            if(elements.checked){
                cad += elements.value;
            }
        }
        alert(cad);
        cad = "Los radio seleccionados estan en la posicion ";
    })
})