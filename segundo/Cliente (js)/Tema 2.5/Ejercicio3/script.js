const arr = [{nombre: "nombre1", edad: 18, ciudad: "Sevilla"},
    {nombre: "nombre2", edad: 10, ciudad: "Sevilla"},
    {nombre: "nombre3", edad: 11, ciudad: "Madrid"},
    {nombre: "nombre4", edad: 24, ciudad: "Barcelona"},
    {nombre: "nombre5", edad: 20, ciudad: "Málaga"}]
function mostrarPersona(array){
    cad = "";
    array.forEach((obj)=>{
        cad = `${cad}${obj.nombre}, ${obj.ciudad}, ${obj.edad}\n`;
    })
    console.log(cad);
}
function parte1(){
    console.log("mostrar personas mayores de edad")
    var cad = "";
    var mayorEdad = arr.filter(mayor => mayor.edad >= 18);
    mostrarPersona(mayorEdad);
}
parte1();
function parte2(){
    console.log("mostrar personas de sevilla")
    var cad = "";
    var sevilla = arr.filter(ciudad => ciudad.ciudad == "Sevilla");
    mostrarPersona(sevilla);
}
parte2()