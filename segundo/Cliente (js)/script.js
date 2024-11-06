window.addEventListener("DOMContentLoaded", () => {
    let resultado = document.getElementById("resultado");
    let edadInput ;
    document.getElementById("enviar").addEventListener("click", (e) => {
      e.preventDefault();
      edadInput = Number(document.getElementById("edad").value);
      if (isNaN(edadInput)) {
        resultado.innerText = "No es un número";
        resultado.setAttribute("class", "rojo");
      } else {
        if (edadInput >= 18) {
          resultado.innerText = "Es mayor de edad";
          resultado.setAttribute("class", "verde");
        } else {
          resultado.innerText = "No es mayor de edad";
          resultado.setAttribute("class", "rojo");
        }
      }
    });
  });