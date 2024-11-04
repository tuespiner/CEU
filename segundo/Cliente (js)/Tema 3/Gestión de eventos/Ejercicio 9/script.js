var form;
var nombre;
var apellidos;
var fecha;
var fechaBisiesto;
var boton;
var div;
var array = [];
getBisiesto = (e) =>{
    var fechaActual = new Date();
    for( let i = e.getFullYear(); i <= fechaActual.getFullYear(); i++){
        if((i%4)==0){
            array.push(i);
        }
    }
}
window.addEventListener("DOMContentLoaded", () =>{
    div = document.getElementById("resultado");
    document.getElementById("abrirPagina").addEventListener("click", () =>{
        var ventana = window.open("pagina.html","Obtención de datos", "width=400px, height=300px");
        ventana.addEventListener("DOMContentLoaded", () =>{
            form = ventana.document.getElementById("formulario");
            boton = form["mostrar"];
            boton.addEventListener("click", (e) =>{
                e.preventDefault();
                nombre = form["nombre"].value;
                apellidos = form["apellido"].value;
                fecha = new Date(form["fecha"].value);
                getBisiesto(fecha);
                var cad = `<p>Nombre: ${nombre}</p>`+
                          `<p>Apellidos: ${apellidos}</p>`+
                          `<p>Fecha Nacimiento: ${fecha.getDate()+"/"+ fecha.getMonth()+"/"+fecha.getFullYear()}</p>`+
                          `<ul><li>Años bisiestos</li>`;

                for(variable of array){
                    cad+= `<li>${variable}</li>`;
                }
                cad += `</ul>`
                div.innerHTML = cad;
            })
        })
    })
})
