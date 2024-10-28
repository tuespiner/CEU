var input1;
var input2;
var boton1;
var boton2;
window.addEventListener("DOMContentLoaded", () =>{
    input1 = document.getElementById("inp1");
    input2 = document.getElementById("inp2");
    boton1 = document.getElementById("pulsame");
    boton2 = document.getElementById("cambia");

    input1.addEventListener("focus", () =>{
        input1.style.color = "red";
    });
    input1.addEventListener("blur", () =>{
        input1.style.color = "black";
    });

    input2.addEventListener("focus", () =>{
        input2.style.color = "red";
    });
    input2.addEventListener("blur", () =>{
        input2.style.color = "black";
    });

    boton1.addEventListener("focus", () =>{
        boton1.style.color = "blue";
    })

    boton2.addEventListener("mouseover", () =>{
        boton2.style.borderColor = "green";
    })
    boton2.addEventListener("mouseout", () =>{
        boton2.style.borderColor = "orange";
    })
})