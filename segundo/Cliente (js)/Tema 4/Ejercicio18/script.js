var tbody = document.getElementById("cuerpoTabla");
var tr = document.getElementsByTagName("thead")[0].children[0];
var objetosLiterales = [{id : 1, nombre : "nombre1", precio : 10, codigo : "1"},
    {id : 2, nombre : "nombre2", precio : 9, codigo : "2"},
    {id : 3, nombre : "nombre3", precio : 15, codigo : "3"},
    {id : 4, nombre : "nombre4", precio : 2, codigo : "4"}
]
var marcar = document.createElement("th")
marcar.innerHTML="Marcar"
tr.appendChild(marcar);

objetosLiterales.forEach(objeto =>{
    let tr = document.createElement("tr");
    tr.id = objeto.id;
    let contador = 1;
    for(let i = 0; i < 4; i++){
        let td = document.createElement("td")
        if(i == 0){
            td.innerHTML=objeto.nombre
        }else if(i == 1){
            td.innerHTML=`${objeto.precio}€`
        }else if(i == 2){
            td.innerHTML=objeto.codigo
        }else{
            td = document.createElement("input")
            td.id=`checkbox${contador}`
            td.type="checkbox"
            td.value="marcar"
            contador++
        }
        tr.appendChild(td);
    }
    tbody.appendChild(tr)
})