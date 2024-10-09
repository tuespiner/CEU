var finDeSemana = () =>{
    var fecha = new Date();
    var url = "";
    if(fecha.getDay() == 6 || fecha.getDay() == 0){
        url = `image/feliz.pgn`;
    }else{
        url = `image/triste.png`;
    }
    var ventana = window.open("Ejercicio6_1.html","Ejercicio6_1", "width=400px, height=400px");
    ventana.document.write(`<img src="${url}">`);
}