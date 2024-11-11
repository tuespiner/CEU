window.addEventListener("DOMContentLoaded", () =>{
    var form = document.forms["formulario"];
    var boton = form["enviar"];
    var lista = document.getElementById("lista");
    boton.addEventListener("click", (e) =>{
        e.preventDefault();
        let li = document.createElement("li");
        let texto = document.createTextNode(form["texto"].value)
        li.appendChild(texto);
        lista.appendChild(li);
    })
})

