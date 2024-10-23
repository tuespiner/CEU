var arr = [1, 5, 10, 6, 7, 2, 4];
var flecha = (array) =>{
    if(Array.isArray(array)){
        if(array.length > 0){
            var num = true
                array.forEach((valor) =>{
                    if(typeof valor != "number"){
                        num = false;
                        return false;
                }
                
            })
            if(num){
                var par = array.filter(number => number%2 == 0);
                var impar = array.filter(number => number%2 == 1);
                par.forEach((number) => {
                    console.log(`par: ${number}`);
                });
                impar.forEach((number) => {
                    console.log(`impar: ${number}`);
                })
            }else{
                console.log("Solo puede haber numeros en el array")
            }
        }else{
            console.log("El array esta vacío");
        }
    }else{
        console.log("No es un array")
    }
}
flecha(arr);
document.body.innerHTML = "hola"