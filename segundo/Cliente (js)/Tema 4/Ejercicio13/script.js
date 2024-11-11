var section = document.getElementById("ContentFormulario");
var button = section.getElementsByTagName("button")[0];
button.addEventListener("click", () =>{
    var formulario = document.createElement("form");
    formulario.action = "https://www.google.com";
    formulario.method = "GET";
    var input1 = document.createElement("input");
    input1.type = "text"
    input1.placeholder = "Nombres"
    input1.className="inputs"
    var input2 = document.createElement("input");
    input2.type = "text"
    input2.placeholder = "Apellidos"
    input2.className="inputs"
    var input3 = document.createElement("input");
    input3.type = "text"
    input3.placeholder = "email"
    input3.className="inputs"
    var input4 = document.createElement("input");
    input4.type = "text"
    input4.placeholder = "asunto"
    input4.className="inputs"
    var input5 = document.createElement("input")
    input5.type = "text"
    input5.placeholder = "mensaje"
    input5.className="mensaje"
    var input6 = document.createElement("input")
    input6.type = "submit"
    input6.value = "Enviar"
    input6.className = "enviar"
    input6.addEventListener("click", () =>{
        alert("Formulario enviado")
    })
    formulario.appendChild(input1);
    formulario.appendChild(input2);
    formulario.appendChild(input3);
    formulario.appendChild(input4);
    formulario.appendChild(input5);
    formulario.appendChild(input6);
    document.body.appendChild(formulario);
})