var form;
var button;
var suma = 0;
window.addEventListener("DOMContentLoaded", () =>{
    button = document.getElementById("button");
    button.addEventListener("click", (e) =>{
        e.preventDefault();
        form = document.forms[0];
    for(input of form){
        if(input.type == "checkbox" && input.checked){
            suma+= Number(input.value);
        }
    }
    alert(suma);
    suma = 0;
    })
    
})