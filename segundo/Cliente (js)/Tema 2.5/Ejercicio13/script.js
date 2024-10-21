const usuarios = [
    {nombre: "nombre1", edad: 18},
    {nombre: "nombre2", edad: 22},
    {nombre: "nombre3", edad: 10}
];

const mayorEdad = [];
var i = 0;
usuarios.forEach((obj) =>{
    if(obj.edad >= 18){
        mayorEdad[i] = {nombre: `${obj.nombre} (Edad ${obj.edad} años)`}
        i++;
    }
})
mayorEdad.forEach((obj) =>{
    console.log(obj.nombre);
})