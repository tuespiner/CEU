window.addEventListener("DOMContentLoaded", () =>{
    var tabla = document.getElementById("tabla")
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "json.json")
    xhr.send();
    xhr.addEventListener("readystatechange", () =>{
        if(xhr.readyState !== 4)return;
        if(xhr.status >= 200 && xhr.status < 300){
            console.log("si")
            var json = JSON.parse(xhr.responseText)
            json.forEach(estudiante => {
                tabla.append(crearLinea(estudiante))
            });
        }else{
            console.log("no")
        }
    })
})
function crearLinea(e){
    let notas = "";
    let average = 0;
    let tr = document.createElement("tr")
    let td1 = document.createElement("td")
    td1.textContent = e.id
    let td2 = document.createElement("td")
    td2.textContent = e.nombre
    let td3 = document.createElement("td")
    e.notas.forEach(nota =>{
        average += nota
        if(notas == ""){
            notas = nota
        }else{
            notas = `${notas}, ${nota}`
        }
    } )
    td3.textContent = notas
    let td4 = document.createElement("td")
    td4.textContent = average / e.notas.length
    tr.append(td1)
    tr.append(td2)
    tr.append(td3)
    tr.append(td4)
    return tr
}