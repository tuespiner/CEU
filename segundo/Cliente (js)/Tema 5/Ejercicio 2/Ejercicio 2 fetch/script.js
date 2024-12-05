window.addEventListener("DOMContentLoaded", () =>{
    const button = document.getElementById("boton")
    button.addEventListener("click", () =>{
        let tabla = document.getElementById("tabla") 
        const url = "https://jsonplaceholder.typicode.com/posts"
        fetch(url)
        .then(response => response.json())
        .then(data => {
            crearThead(tabla)
            crearTbody(data, tabla)
        })
    })
})

function crearThead(tabla){
    let thead = document.createElement("thead")
    let tr = document.createElement("tr")
    let th = document.createElement("th")
    th.textContent = "Title"
    tr.append(th)
    th = document.createElement("th")
    th.textContent = "Body"
    tr.append(th)
    thead.append(tr)
    tabla.append(thead)
}
function crearTbody(datos, tabla){
    let tbody = document.createElement("tbody")
    datos.forEach(element => {
         let tr = document.createElement("tr")
         let td = document.createElement("td")
         td.textContent=element.title
         tr.append(td)
         td = document.createElement("td")
         td.textContent=element.body
         tr.append(td)
         tbody.append(tr)
    });
    tabla.append(tbody)
}