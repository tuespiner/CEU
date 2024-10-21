const arr = [
    {nombre: "estudiante1", calificacion: [1, 6, 5, 10, 7]},
    {nombre: "estudiante2", calificacion: [6, 6, 2, 8, 6]},
    {nombre: "estudiante3", calificacion: [5, 6, 3, 6, 2]},
    {nombre: "estudiante4", calificacion: [8, 6, 9, 10, 7]},
    {nombre: "estudiante5", calificacion: [9, 6, 1, 7, 5]},
    {nombre: "estudiante6", calificacion: [3, 6, 5, 10, 7]},
];

const notaMedia = [];
arr.forEach((obj) =>{
    var sumaNotas = 0;
    obj.calificacion.forEach((obj2) =>{
        sumaNotas += obj2;
    })
    var media = sumaNotas / obj.calificacion.length;
    if(media >= 7){
        notaMedia.push({nombre: `${obj.nombre}`, notaMedia: media});
    }
})

notaMedia.forEach((obj) =>{
    console.log(`Estudiante: ${obj.nombre}\nNota media: ${obj.notaMedia}`)
})

