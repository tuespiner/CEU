window.addEventListener("DOMContentLoaded", () =>{
    var boton = document.getElementById("boton");
    boton.addEventListener("click", () =>{
        var nombre = document.getElementById("nombre");
        var p = document.createElement("p").appendChild(document.createTextNode(nombre.value));
        var div = document.getElementsByTagName("div")[0];
        div.setAttribute("class", "resultado");
        div.appendChild(p);
    })
})