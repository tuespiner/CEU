const arr = [{nombre: "producto1", precio: 10.0, categoria: "limpieza"},
    {nombre: "producto2", precio: 10.50, categoria: "Ropa"},
    {nombre: "producto3", precio: 2.0, categoria: "Alimentación"},
    {nombre: "producto4", precio: 5.99, categoria: "limpieza"},
]
function toMayus(){
    var arr2 = [];
    arr.forEach((obj, i)=>{
        arr2[i] = obj.nombre.toUpperCase();
    })
    var join = arr2.join("-");
    console.log(join)
    document.body.innerHTML=join;
}
toMayus();
