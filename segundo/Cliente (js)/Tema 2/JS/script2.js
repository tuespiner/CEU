function Ejercicio11(){
    var nombre = prompt("Dime tu nombre");
    var apellido = prompt("Dime tus apellido");
    var salario = Number(prompt("Dime tu salario en decimales"));
    var edad = Number(prompt("Dime tu edad"));

    if(salario <= 2000 && salario > 1000){
        if(edad > 45){
            salario = salario*1.03;
        }else if(edad <= 45 ){
            salario = salario*1.1;
        }
    }else{
        if(edad < 30){
            salario = 1100;
        }else if(edad >=30 && edad < 45){
            salario = salario*1.03;
        }else{
            salario = salario*1.15;
        }
    }
    console.log(`Nombre: ${nombre}\nApellido: ${apellido}\nSalario: ${salario}\nEdad: ${edad}`);
}

function Ejercicio12(){
    var cad = prompt("Dime un texto para mostrarlo al reves");
    var cadReves = "";
    for(let i = cad.length; i >= 0; i--){
        cadReves = cadReves + cad.substring(i-1, i);
    }
    console.log(cadReves);
}

function Ejercicio13(){
    var num1 = Number(prompt("Le voy a pedir 3 numeros\nDime el primer numero"));
    var num2 = Number(prompt("Dime el segundo numero"));
    var num3 = Number(prompt("Dime el tercer numero"));
    var promedio = (num1 + num2 + num3) / 3;
    if(promedio >= 7){
        alert("Promocionado");
    }
}

function Ejercicio14(){
    var lado = Number(prompt("Dime el lado de un cuadrado"));
    for(let i = 0; i <=lado; i++){
        document.write("* <br>");
    }
    document.write(`El perimetro es ${lado * 4}`);
}
function Ejercicio15(){
    var base = Number(prompt("Dime la base del cuadrado"));
    var altura = Number(prompt("Dime la altura del cuadrado"));
    for(let i = 0; i<= altura;i++){
        for(let j = 0; j<= base; j++){
            if(i == 0 || i == altura){
                document.write("* ");
            }else if(j == 0 || j == base){
                document.write("* ");
            }else{
                document.write("&nbsp &nbsp");
            }
        }
        document.write("<br>");
    }
}

function Ejercicio16(){
    var asteriscos = Number(prompt("Dime el numero de asteriscos"));
    for(let i = asteriscos; i >= 0; i--){
        for(let j = 0;j<= asteriscos;j++){
            if(j <i){
                document.write("&nbsp &nbsp");
            }else{
                document.write("* ");
            }
        }
        document.write("<br>");
    }
}
function Ejercicio17(){
    var numero = Number(prompt("Dime un numero del 1 al 10"));
    do{
        numero = Number(prompt("El numero tiene que ser del 1 al 10"));
    }while(!(numero > 0 && numero < 11));
    for(let i = 1; i <=10; i++){
        console.log(`${numero} * ${i} = ${numero*i}`);
    }
}

function Ejercicio20(){
    var sueldo = Number(prompt("Indique su salario"));
    var antiguedad = Number(prompt("Indique sus años de antiguedad"));

    if(sueldo <500){
        if(antiguedad >=10){
            alert("Por tener un sueldo ingerior a 500 euros y \nuna antiguedad de 10 o mas años se le otroga un incremento\ndel 20% al sueldo ("+ (sueldo * 1.2)+")");
        }else{
            alert("Por tener un sueldo inferior a 500 euros y \nuna antiguedad menor de 10 años se le otorga un incremento\ndel 5% al sueldo("+ (sueldo * 1.05)+")");
        }
    }else{
        alert(sueldo);
    }
}