function crearArray(){
    var arr = [];
    let intro;
    for(let i = 0; i < 3; i++){
        intro = prompt("introduce la cadena");
        console.log(intro);
        if(intro != null){
            arr[i] = intro;
        }else{
            arr[i] = "";
        }
    }
    var printArr = "";
    arr.forEach((cad)=>{    
        printArr = `${printArr}, ${cad}`; 
    })
    console.log(printArr);
    var arr2 = arr.filter(arr => arr.toLowerCase().startsWith("c"));
    printArr = "";
    arr2.forEach((cad)=>{
        printArr = `${printArr} ${cad}`;
    })
    console.log(printArr);
}
crearArray();