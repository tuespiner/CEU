var inputs;
var validar1 = false;
var validar2 = false;
comprobar = (e) =>{
    e.preventDefault();
    inputs = document.getElementsByTagName("input");
    var nombre = inputs[0].value;
    console.log(nombre)
    if(nombre.startsWith("a") ||
        nombre.startsWith("e") ||
        nombre.startsWith("i") ||
        nombre.startsWith("o") ||
        nombre.startsWith("u")){
            document.getElementById("nombre").innerHTML = "";
            validar1 = true;
        }else{
            document.getElementById("nombre").innerHTML = "EL nombre no empieza por vocal";
        }
    if(inputs[1].value.split(" ").length < 2){
        document.getElementById("apellido").innerHTML = "Tienes que poner los dos apellidos";
    }else{
        document.getElementById("apellido").innerHTML = "";
        validar2 = true;
    }
    if(validar1 && validar2){
        window.location.href = "https://ceu.es";
    }
}
inicio = (e) =>{
    document.getElementById("validar").addEventListener("click", comprobar);
}
window.addEventListener("DOMContentLoaded", inicio);