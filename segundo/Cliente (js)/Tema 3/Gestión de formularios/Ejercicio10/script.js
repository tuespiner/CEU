window.addEventListener("DOMContentLoaded", () =>{
    var form1 = document.forms[0];
    var form2 = document.forms[1];
    var submit1 = form1.elements[1];
    var submit2 = form2.elements[1];
    var select;
    submit1.addEventListener("click", (e) =>{
        e.preventDefault();
        select = form1.elements[0];
        var opcionSeleccionadas = select.selectedIndex;
        var descripción = select.options[opcionSeleccionadas];
        alert(`posición: ${opcionSeleccionadas}\ndescripción: ${descripción.value}`)
    })
    submit2.addEventListener("click", (e) =>{
        e.preventDefault();
        select = form2.elements[0];
        var opcionSeleccionadas = select.selectedOptions;
        var cad = "";
        for(valor of opcionSeleccionadas){
            cad = `${cad}posición: ${valor.value}\n descripción: ${valor.innerHTML}\n\n`;
        }
        
        alert(cad)
    })
})