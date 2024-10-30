var form;
var nombre;
var apellidos;
var fecha;
var fechaBisiesto;
var boton;
var div;
getBisiesto = (e) =>{

}
window.addEventListener("DOMContentLoaded", () =>{
    div = document.getElementById("resultado");
    document.getElementById("abrirPagina").addEventListener("click", () =>{
        var ventana = window.open("pagina.html","Obtención de datos", "width=400px, height=300px");
        ventana.addEventListener("DOMContentLoaded", () =>{
            console.log("hola");
            form = ventana.document.getElementById("formulario");
            console.log(form);
            boton = form["mostrar"];
            boton.addEventListener("click", (e) =>{
                e.preventDefault();
                nombre = form["nombre"].value;
                apellidos = form["apellido"].value;
                fecha = new Date(form["fecha"].value);
                console.log(typeof fecha)
                var cad = `<p>Nombre: ${nombre}</p>`+
                          `<p>Apellidos: ${apellidos}`+
                          `<p>Fecha Nacimiento: ${fecha.getDate()+"/"+ fecha.getMonth()+"/"+fecha.getFullYear()}</p>`;
                div.innerHTML = cad;
            })
        })
    })
})
