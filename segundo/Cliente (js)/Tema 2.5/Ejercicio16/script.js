const productos = [
    {nombre: "producto1", precio: 5, categoria: {nombre: "Electrónica", descripcion: "descripcion1"}},
    {nombre: "producto2", precio: 10, categoria: {nombre: "categoria2", descripcion: "descripcion2"}},
    {nombre: "producto3", precio: 7, categoria: {nombre: "Electrónica", descripcion: "descripcion3"}},
    {nombre: "producto4", precio: 2, categoria: {nombre: "categoria4", descripcion: "descripcion4"}},
    {nombre: "producto5", precio: 3.5, categoria: {nombre: "categoria5", descripcion: "descripcion5"}},
];

var categoria = productos.filter((cat) => cat.categoria.nombre == "Electrónica");
categoria.forEach((obj) => {
    var cad = `Nombre: ${obj.nombre}\nPrecio: ${obj.precio}€\nCategoria:\n\tNombre: ${obj.categoria.nombre}\n\tDescriptión: ${obj.categoria.descripcion}`
    console.log(cad);
})

