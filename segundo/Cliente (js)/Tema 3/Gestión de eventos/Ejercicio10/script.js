var temporizador;
var iniciar;
var pausar;
var reiniciar;
var valor = 29;
var intervalo;
window.addEventListener("DOMContentLoaded", () =>{
    temporizador = document.getElementById("temporizador");
    iniciar = document.getElementById("iniciar");
    pausar = document.getElementById("pausar");
    reiniciar = document.getElementById("reiniciar");
    iniciar.addEventListener("click", () =>{
        console.log("holi")
        intervalo = setInterval(() =>{
        console.log(valor);
        valor--;
        if(valor==0){
            temporizador.innerHTML = "¡Tiempo agotado!";
            clearInterval(intervalo);
        }else{
            temporizador.innerHTML = valor;
        }
        }
        , 1000)
    })
    pausar.addEventListener("click", () =>{
        clearInterval(intervalo);
    })
    reiniciar.addEventListener("click", () =>{
        clearInterval(intervalo);
        valor = 30;
        temporizador.innerHTML = valor;
    })

})