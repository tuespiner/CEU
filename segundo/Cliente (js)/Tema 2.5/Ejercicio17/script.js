var ventana;
function crearObjeto(){
    ventana = window.open("ventana.html", "Ventana de creación de objeto", "width=800px,height=800px,left=300px,top=100px");
    console.log(taxiGeneral)

}
var taxiGeneral = {};
/*window.addEventListener("DOMContentLoaded",()=>{
    const formulario = document.getElementById("formulario");
})

formulario.addEventListener("submit", (evento)=>{
    evento.preventDefault();
    creacionObjeto();
})*/
function creacionObjeto(){
    var motor =stringValue.document.getElementById("tipoMotor").value;
    console.log(motor);
    var pasajeros = document.getElementById("numPasajeros").value;
    console.log(pasajero)
    var carga = document.getElementById("carga").value;
    console.log(carga)
    var velocidad = document.getElementById("velocidad").value;
    console.log(velocidad)
    var ruedas = document.getElementById("ruedas").value;
    console.log(ruedas)
    var taxi = {TipoMotor: motor, numPasajeros: pasajeros, carga: carga, velocidad: velocidad, numRuedas: ruedas, saludar: () => {
        console.log(`Hola soy un taxi de ${this.numRuedas} ruedas y ${this.numPasajeros} pasajeros`)
    }}
    taxiGeneral = taxi;
    window.opener.ventana.close();
    saludar();
}
function saludo(){
    taxiGeneral.saludar();
}

function crearObjetoPrompt(){
    var motor = prompt("Dime el tipo de motor");
    var pasajeros =  Number(prompt("Dime la cantidad de pasajeros (Numero)"));
    var carga = Number(prompt("Dime los kg de carga que permite (Numero)"))
    var velocidad = Number(prompt("Dime la velocidad máxima que permite (Numero)"));
    var ruedas = Number(prompt("Dime la cantidad de ruedas que tiene el taxi (Numero)"));
    console.log(ruedas)
   
    var taxi = {TipoMotor: motor, numPasajeros: pasajeros, carga: carga, velocidad: velocidad, numRuedas: ruedas, saludar: function() {
        console.log(`Hola soy un taxi de ${this.numRuedas} ruedas y ${this.numPasajeros} pasajeros`)
    }
    }

    console.log("HOla que tal")
    taxi.saludar();

    //taxiGeneral = taxi;
    //saludo();
}   