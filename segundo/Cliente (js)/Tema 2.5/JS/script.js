function Ejercicio1(){
    var fecha = new Date();
    var nacimiento = new Date(2005, 8, 4);
    console.log(`actual: ${fecha}\nnacimiento: ${nacimiento}`);

    console.log(`actual: ${fecha.getFullYear()}\nnacimiento: ${nacimiento.getFullYear()}`);

    fecha.setFullYear("2023");
    console.log(fecha.toLocaleDateString());

    var dia = fecha.getDate();
    var mes = fecha.getMonth();
    var año = fecha.getFullYear();
    console.log(`${dia}/${mes + 1}/${año}`)
}

function Ejercicio2(){
    var actual = new Date();
    var finCurso = new Date(actual.getFullYear() + 1, 5, 30);
    var restante = finCurso - actual;
    console.log(parseInt((((restante / 1000)/ 60)/60)/24));
}

function Ejercicio3(){
    var cumpleUsuario = new Date();
    cumpleUsuario.setDate(parseInt(prompt("Dime el día de tu cumpleaños")));
    cumpleUsuario.setMonth(parseInt(prompt("Dime el mes de tu cumpleaños"))-1);
    for(let i = cumpleUsuario.getFullYear(); i <= 2100; i++){
        cumpleUsuario.setFullYear(i);
        if(cumpleUsuario.getDay() == 0){
            console.log(i)
        }
    }
}

function Ejercicio4(){
    var fecha = new Date();
    console.log(fecha.toLocaleDateString());
    console.log(fecha.toDateString("en-EN"));
    console.log(fecha.toLocaleDateString()+" "+   fecha.toTimeString());
    console.log(fecha.toTimeString());
}
function Ejercicio5(){
    var nacimiento = prompt("Dime tu fecha de nacimiento en formato dd/mm/yyyy");
     nacimiento = nacimiento.split("/");
    var fechaNacimiento = new Date(parseInt(nacimiento[2]),parseInt(nacimiento[1])-1,parseInt(nacimiento[0]));
    var fechaActual = new Date();
    console.log(`Tiene ${parseInt((((((fechaActual- fechaNacimiento)/1000)/60)/60)/24)/365)} años`);
}
function Ejercicio6(){
    var fecha = new Date();
    switch(fecha.getDay()){
        case 0:
            console.log("Domingo");
            break;
        case 1:
            console.log("Lunes");
            break;
        case 2:
            console.log("Martes");
            break;
        case 3:
            console.log("Miercoles");
            break;
        case 4:
            console.log("Jueves");
            break;
        case 5:
            console.log("Viernes");
            break;
        case 6:
            console.log("Sabado");
            break;
    }
}
function Ejercicio7(){
    var fecha = new Date();
    var anyo = `${fecha.getFullYear()}`
    console.log(anyo.substring(anyo.length-2,anyo.length));
}
function Ejercicio8(){
    var caraOCruzR = parseInt(Math.random()*2);
    switch(caraOCruzR){
        case 0:
            var caraOCRuz = "cara";
            break;
        case 1:
            var caraOCRuz = "Cruz";
            break;
    }
    console.log(caraOCRuz);
    alert(caraOCRuz);
    document.write(caraOCRuz);
}
function Ejercicio9(){
    var random = parseInt(Math.random()*(10))+1 ;
    var introducido = parseInt(prompt("Se ha generado un numero random, intenta adivinarlo"));
    console.log(random);
    if(parseInt( introducido == random)){
        console.log("Lo adivinaste");
    }else{
        console.log("Suerte para la proxima")
    }
}
function Ejercicio10(){
    var suma = 0;
    var output = `La suma de los numeros `;
    for(let i = 0; i <= 10; i++){
        var random = parseInt(Math.random()*21);
        output = `${output} ${random}`;
        suma = suma + random;
    }
    output = `${output} es ${suma}`;
    console.log(output);
}
function Ejercicio11(){
    var nombre = prompt("Dime tu nombre");
    var fecha = new Date();
    var hora = fecha.getHours();
    console.log(hora);
    if(hora >=7 && hora < 12){
        alert(`Buenos dias ${nombre}`);
    }else if(hora >= 12 && hora < 20){
        alert(`Buenas tardes ${nombre}`);
    }else if(hora >=20 || hora <7){
        alert(`Buenas noches ${nombre}`);
    }
}
function Ejercicio15(){
    var abrirVentana = confirm("¿Abrir una ventana?");
    if(abrirVentana){
        var nuevaVentana = window.open("","Nueva ventana", "toolbar=no, location=no, menubar=no, width=200px, height=80px, top=500px, left=500px, resizable=yes, scrollbar=yes");
        nuevaVentana.document.write("<h1>Entorno Cliente</h1>");
    }
}
function Ejercicio16(){
    var ejercicio16 = window.open("indexEj16.html","index","width=1920px,height=1020px");
}
function Ejercicio17(){
    var ejercicio17 = window.open("indexEj17.html","Selector de colores","width=600px,height=600px,left=500px,top=200px");
}
function Ejercicio21(){
    var ejercicio21 = window.open("indexEj21.html","Ejercicio 21","width=1920px,height=1020px");
}
function Ejercicio18(){
    var ejercicio18 = window.open("indexEj18.html","Ejercicio 18", "width=500px,height=500px");
}
function Ejercicio19(){
    var ejercicio19 = window.open("indexEj19.html","Ejercicio 19", "width=500px,height=500px");
}
function Ejercicio20(){
    var ejercicio20 = window.open("indexEj20.html","Ejercicio 20", "width=500px,height=500px");
}