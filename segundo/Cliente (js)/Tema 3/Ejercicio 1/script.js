var input;
convertirMayus = () =>{
    input.value = input.value.toUpperCase();
    input.select();
};
nombre = () =>{
    input = document.getElementById("input");
    input.addEventListener("blur", convertirMayus);
}
window.addEventListener("DOMContentLoaded",nombre);