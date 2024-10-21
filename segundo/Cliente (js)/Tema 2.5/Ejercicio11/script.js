const arr = [
    {nombre: "obj1", cantidad: 10, precio: 2.5},    
    {nombre: "obj2", cantidad: 5, precio: 10},    
    {nombre: "obj3", cantidad: 50, precio: 1},    
    {nombre: "obj4", cantidad: 1, precio: 150},    
    {nombre: "obj5", cantidad: 120, precio: 22}
]
var arr2 = [];
for(let i = 0; i < arr.length; i++){
    var valorBolsa = arr[i].cantidad * arr[i].precio;
    arr2[i] = {nombre: `${arr[i].nombre}`, precioBolsa: Number(valorBolsa)}
}
arr2.forEach((obj) =>{
    var cad = `nombre: ${obj.nombre}\nvalor en bolsa: ${Math.round(obj.precioBolsa, 2)}€ `;
    console.log(cad);
})