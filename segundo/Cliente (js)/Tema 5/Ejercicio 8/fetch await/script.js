function cambiarDatos(boton, element){
    let div = boton.parentElement
    div.children[0].src = element.picture.medium
    div.children[1].innerHTML = `Nombre: ${element.name.first} ${element.name.last}`
    div.children[2].innerHTML = `Correo: ${element.email}`
    div.children[3].innerHTML = `Calle: ${element.location.street.name} ${element.location.street.number}`
    div.children[4].innerHTML = `Ciudad: ${element.location.city} (${element.location.state})`
}
function crearElementos(){
    let div = document.createElement("div")
    let img = document.createElement("img")
    div.append(img)
    let p = document.createElement("p")
    div.append(p)
    p = document.createElement("p")
    div.append(p)
    p = document.createElement("p")
    div.append(p)
    p = document.createElement("p")
    div.append(p)
    let button = document.createElement("button")
    button.innerHTML = "Cambiar"
    button.addEventListener("click", e =>{
        console.log(e)
        fetch("https://randomuser.me/api/?results=1")
        .then(response => response.json())
        .then(data =>{
        cambiarDatos(e.target, data.results[0])
        });
    })
    div.append(button)
    document.body.append(div)
}
function inicio(){
    const src = "https://randomuser.me/api/?results=10"
    fetch(src)
    .then(response => response.json())
    .then(data =>{
        let contador = 0
        let boton = document.getElementsByTagName("button")
        data.results.forEach(element => {
            crearElementos()
            console.log(element)
            cambiarDatos(boton[contador], element)
            contador++
        });
    })
}

window.addEventListener("DOMContentLoaded", () =>{
    inicio()  
})