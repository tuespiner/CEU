function crearEstrellaString(color){
    var x = parseInt(Math.random()*(100));
    var y = parseInt(Math.random()*(100));
    let cadSombra = `${x}vw ${y}vh 0px ${color}`;
    return cadSombra;
}
function crearEstrellas(color = "white"){
    let cadSombra = "";
    let cantEstrellas = 400;
    for(let i = 0; i <= cantEstrellas; i++){
        if(i <= (cantEstrellas-1)){
            cadSombra = cadSombra + crearEstrellaString(color) + ",";
        }else{
            cadSombra = cadSombra + crearEstrellaString(color) ;
        }
    }
    console.log(cadSombra)
    return cadSombra;
}
function capaEstrella(num, top = -100){
    var estrella = document.getElementById(`estrellas${num}`);
    estrella.style.setProperty("--tamaño", );
    let cad = crearEstrellas();
    console.log(cad);
    estrella.style.boxShadow = cad;
    /*estrella.animate([{marginTop:`${top}vh`},{marginTop:`100vh`}],{duration:10000,},);
    if(num == 3){
        var dysplaynone = () =>{
            estrella.style.display = "none"
        }
        setTimeout(dysplaynone,4900);
    }*/
}

function main(){
    var contador = 1;
    var cpb = () =>{//continious playback background ese es el nombre jajaja
        console.log("hola");
        if(contador == 1){
            capaEstrella(2);
            contador = 2;
        }else if(contador == 2){
            capaEstrella(1);
            contador = 1;
        }
       
    }
    capaEstrella(3, 0);
    capaEstrella(1);
    setInterval(cpb,5000);
    
}
capaEstrella(1,0);