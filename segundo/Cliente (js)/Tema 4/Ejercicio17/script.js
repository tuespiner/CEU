var tbody = document.getElementById("cuerpoTabla");
var objetosLiterales = [{id : 1, nombre : "nombre1", precio : 10, codigo : "1"},
    {id : 2, nombre : "nombre2", precio : 9, codigo : "2"},
    {id : 3, nombre : "nombre3", precio : 15, codigo : "3"},
    {id : 4, nombre : "nombre4", precio : 2, codigo : "4"}
]

objetosLiterales.forEach(objeto =>{
    let tr = document.createElement("tr");
    tr.id = objeto.id;
    for(let i = 0; i < 3; i++){
        let td = document.createElement("td")
        if(i == 0){
            td.innerHTML=objeto.nombre
        }else if(i == 1){
            td.innerHTML=`${objeto.precio}€`
        }else{
            td.innerHTML=objeto.codigo
        }
        tr.appendChild(td);
    }
    tbody.appendChild(tr)
})