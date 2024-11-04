window.addEventListener("DOMContentLoaded", () =>{
    var inputs = document.getElementsByTagName("input");
    var text
    var enviar
    for(value of inputs){
        if(value.type == "text"){
            text = value;
        }else if(value.type == "submit") {
            enviar = value
        }
    }
    console.log(typeof(text) + typeof(enviar))
    enviar.addEventListener("click", () =>{
        enviar.value = "enviado"
        text.value = prompt("dime tu nombre")
    })
})