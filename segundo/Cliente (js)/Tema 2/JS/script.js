function Ejercicio1(){
    console.log("Bienvenido\n\'hola que tal\'\n\"bien y tu\"");
alert("Juan López Carmona");
var nombre = "Juan López Carmona";
alert(nombre)
}

function Ejercicio2(){
    var nombre = prompt("Indique cuál es si nombre");
    document.write(nombre);
}

function Ejercicio3(){
    var mayorDeEdad = confirm("¿Eres mayor de edad?");
    if(mayorDeEdad){
        console.log("Soy mayor de edad");
    }else{
        console.log("NO soy mayor de edad");
    }
}

function Ejercicio4(){
    var var1 = 'mundo';
    var var2 = 'hola mundo';
    console.log(var2.indexOf(var1.substring(0,1)));
    var2 = var2.replace('mundo', 'universo');
    console.log(var2.toUpperCase());
    console.log(var2.toLocaleLowerCase());
    console.log("Juan " + "López Carmona");
    var var3 = 'Cliente';
    console.log(var3.substring(0, var3.indexOf('i') + 1));
    console.log(var3.substring(var3.indexOf('e'), var3.lastIndexOf('e') + 1))
}

function Ejercicio6(){
    var nombre = prompt("Indique su nombre");
    var correo = prompt("Indique su correo electronico");
    document.write('<h1>'+nombre+'</h1>\n<h2>'+correo+'</h2>');
}

function Ejercicio7(){
    var numero1 = prompt("Dime un numero");
    var numero2 = prompt("Dime otro numero");
    console.log(`La suma de ${numero1} y ${numero2} es ${Number(numero1) + Number(numero2)}`);
    console.log(`La resta de ${numero1} y ${numero2} es ${Number(numero1) - Number(numero2)}`);
}

function Ejercicio8(){
    var precio = prompt("Dime el precio del articulo que quiere comprar");
    var cant = prompt("Dime la cantidad de articulos que queire comprar");
    document.write((Number(precio) * Number(cant)).toFixed(2));
}

function Ejercicio9(){
    var num = prompt("Dime un numero");
    var longitud = num.length;
    document.write(`<div style="font-style:italic;color:blue;">
                        <h1>${longitud}</h1>
                    </div>`);
}