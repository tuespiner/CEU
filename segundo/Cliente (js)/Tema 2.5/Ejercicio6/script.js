var arr = ["lunes", "martes", "miercoles", "jueves","viernes","sabado","domingo"]
function ejercicio6(){
    var masLargo = "";
    arr.forEach((palabra) =>{
        console.log(`${palabra}: ${palabra.length}`);
        if(palabra.length >= masLargo.length){
            masLargo = palabra;
        }
    })
    console.log(`El nombre del dia de la semana mas largo es ${masLargo}`);
}
ejercicio6();