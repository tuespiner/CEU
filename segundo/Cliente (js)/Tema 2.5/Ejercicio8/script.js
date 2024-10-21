var arr = ["hola", "adios", 1];
var flecha = (array) =>{
    if(Array.isArray(array)){
        if(array.length > 0){
            var num = array.forEach((valor) =>{
                if(typeof valor != "number"){
                    return false;
                }
                
            })
        }else{
            console.log("El array esta vacío");
        }
    }else{
        console.log("No es un array")
    }
}
flecha(arr);
document.body.innerHTML = "hola"