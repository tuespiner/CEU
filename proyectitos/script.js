function crearColor(){
    let random = Math.random() * 1;
    let cad = `rgb(255,255,255,${random})`;
    return cad ;
}
function crearEstrellaString(){
    var x = parseInt(Math.random()*(100));
    var y = parseInt(Math.random()*(100));
    var tamaño = parseInt(Math.random()*4);
    let cadSombra = `${x}vw ${y}vh 0px ${tamaño}px ${crearColor()}`;
    return cadSombra;
}
function crearEstrellas(){
    let cadSombra = "";
    let cantEstrellas = 400;
    for(let i = 0; i <= cantEstrellas; i++){
        if(i <= (cantEstrellas-1)){
            cadSombra = cadSombra + crearEstrellaString() + ",";
        }else{
            cadSombra = cadSombra + crearEstrellaString() ;
        }
    }
    return cadSombra;
}
function capaEstrella(str, num = 0, top = "-100vh", duration = 10000){
    var estrella = str;
    var estrellas = document.getElementById(estrella);
    let cad = crearEstrellas();
    estrellas.style.boxShadow = cad;
    estrellas.animate([{marginTop:`${top}`},{marginTop:`100vh`}],{duration: duration,},);
    if(num == 3){
        var dysplaynone = () =>{
            estrellas.style.display = "none"
        }
        setTimeout(dysplaynone,4600);
    }
}
function capaEstrella1(){
    capaEstrella("estrellas1");
}
function capaEstrella2(){
    capaEstrella("estrellas2");
}
function capaEstrella3(){
    capaEstrella("estrellas3", 3, 0, 5000);
}


function main(){
    var contador = 1;
    var cpb = () =>{//continious playback background ese es el nombre jajaja
        if(contador == 1){
            capaEstrella2();
            contador = 2;
        }else if(contador == 2){
            capaEstrella1();
            contador = 1;
        }
       
    }
    capaEstrella3();
    capaEstrella1();
    setInterval(cpb,5000);
    
}
main();