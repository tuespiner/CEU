function contarVocales(){
    var cad = prompt("Dime una palabra")
    var arr = cad.split("")
    var arrVocales = ["a", "e", "i", "o", "u"]
    var contador = 0;
    arr.forEach((pal) =>{
        arrVocales.forEach((voc) =>{
            if(pal == voc){
                contador++;
            }
        })
    })
    console.log(`La palabra ${cad} tiene ${contador} vocales`)
}
contarVocales();