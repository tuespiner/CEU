function crearTabla(datos){
    let tbody = document.getElementById("tbody")
    let tr = document.createElement("tr")
    let td = document.createElement("td")
    td.textContent = datos.title
    tr.append(td)
    td = document.createElement("td")
    td.textContent = datos.body
    tr.append(td)
    tbody.append(tr)
}


window.addEventListener("DOMContentLoaded", () =>{
    const tabla = document.getElementById("tabla")
    const xhr = new XMLHttpRequest();
    const boton = document.getElementById("boton")
    xhr.open("GET", "https://jsonplaceholder.typicode.com/posts")
    boton.addEventListener("click", () =>{
        xhr.send();
        if(tabla.children.length == 0){
            let thead = document.createElement("thead")
            let tbody = document.createElement("tbody")
            tbody.id = "tbody"
            let tr = document.createElement("tr")
            let th = document.createElement("th")
            th.textContent = "Title"
            tr.append(th)
            th = document.createElement("th")
            th.textContent = "Body"
            tr.append(th)
            thead.append(tr)
            tabla.append(thead)
            tabla.append(tbody)
        }
        xhr.addEventListener("readystatechange", () =>{
            if(xhr.readyState !== 4) return;

            if(xhr.status >= 200 && xhr.status < 300){
                console.log("ci")
                let json = JSON.parse(xhr.responseText)
                console.log(json)
                json.forEach(elemento => {
                    crearTabla(elemento)
                });
            }else{
                console.log("mamahuevo")
            }
        })
    })
})