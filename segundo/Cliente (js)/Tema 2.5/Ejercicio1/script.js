const arr = [2, 3, 4, 5, 0]
function primero(){
    var suma = 0;
arr.forEach((numero) =>{
    suma += numero
});
console.log(suma + " primero");
return suma;
}
primero();
function segundo(){
    let suma = primero();
    let media = suma / arr.length;
    console.log(media + " segundo");
    return media;
}
segundo();
function tercero(){
    var arr2 = [];
    var contador = 0;
    arr.forEach((numero) =>{
        arr2[contador] = numero * 3;
        contador++;
    })
    console.log(" tercero");
    arr2.forEach((numero) =>{
        console.log(numero);
    })
    return arr2;
}
tercero();
function cuarto(){
    for (let i = 0; i < arr.length; i++){
        arr[i] = arr[i]*3;
    }
    console.log("cuarto")
    arr.forEach((numero) =>{
        console.log(numero)
    })
}
cuarto();