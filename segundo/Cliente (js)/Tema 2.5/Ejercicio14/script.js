const libros = [
    {titulo: "titulo1", nPaginas: 150},
    {titulo: "titulo2", nPaginas: 450},
    {titulo: "titulo3", nPaginas: 350},
    {titulo: "titulo4", nPaginas: 500},
    {titulo: "titulo5", nPaginas: 200},
    {titulo: "titulo6", nPaginas: 100},
    {titulo: "titulo7", nPaginas: 250},
    {titulo: "titulo8", nPaginas: 350},
];
const mas300p = [];
libros.forEach((obj) =>{
    if(obj.nPaginas >= 300){
        mas300p.push(obj);
    }
})
mas300p.forEach((obj) =>{
    console.log(obj.titulo);
})