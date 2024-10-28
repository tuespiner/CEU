var checked;
var boton;
var contador;
inicio = () =>{
    document.getElementById("boton").addEventListener("click", () =>{
        contador = 0;
        checked = document.getElementsByTagName("input");
        for(imprimir of checked){
            if(imprimir.type == "checkbox" && imprimir.checked){
                contador++;
            }
        }
        if(contador <3){
            alert("No hay 3 elementos marcados");
        }else{
            alert("Hay 3 o mas elementos marcados");
        }
    })
}
window.addEventListener("DOMContentLoaded", inicio);