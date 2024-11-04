var form;
var enviar;
validar = (e) =>{
    e.preventDefault();
    var nombre = form["nombre"];
    var apellidos = form["apellidos"];
    var edad = form["edad"];
    var provincia = form["provincia"];
    if(nombre.value == ""){
        
    }else if(apellidos.value = ""){

    }else if(edad.value = ""){
        
    }
}
inicio = () =>{
    form = document.getElementById("formulario");
    enviar = form["enviar"];
    enviar.addEventListener("click", validar);
}
window.addEventListener("DOMContentLoaded", inicio);