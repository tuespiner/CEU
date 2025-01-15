const buscaPersonaje = document.getElementById("personaje")
function crearPelicula(datos){
    let detallePelicula = document.getElementById("detallePeliculas")
    detallePelicula.innerHTML = ""
    let element = document.createElement("h1")
    element.innerHTML = datos.title
    detallePelicula.append(element)

    element = document.createElement("h2")
    element.innerHTML = `Fecha: ${datos.release_date}`
    detallePelicula.append(element)

    element = document.createElement("h2")
    let datosDirector = datos.director
    datosDirector = datosDirector.replace("{", "")
    datosDirector = datosDirector.replace("}", "")
    datosDirector = datosDirector.replace(`"`, "")
    datosDirector = datosDirector.replace(`"`, "")
    datosDirector = datosDirector.replace(`"`, "")
    datosDirector = datosDirector.replace(`"`, "")
    let arr =   datosDirector.split(":")
    let objeto = {id: arr[0], nombre: arr[1]}
    console.log(objeto)
    element.innerHTML = `Autor: ${objeto.nombre}`
    detallePelicula.append(element)

    element = document.createElement("h3")
    element.innerHTML = `Número total de personajes:`
    detallePelicula.append(element)

    element = document.createElement("p")
    console.log(datos.characters.length)
    if(datos.characters.length >=5){
        element.innerHTML = "Hay más de 5 personajes"
    }else{
        element.innerHTML = "Hay menos de 5 personajes"
    }
    element.title = `Hay ${datos.characters.length} personajes`
    detallePelicula.append(element)

    element = document.createElement("h4")
    element.innerHTML = `Url personajes:`
    detallePelicula.append(element)

    element = document.createElement("ul")
    datos.characters.forEach(personaje =>{
        let li = document.createElement("li")
        let a = document.createElement("a")
        if(datos.characters.length > 9){
            a.style.backgroundColor = "#be1283"
        }else{
            a.style.backgroundColor = "#ea82b6"
        }
        a.innerHTML = personaje
        li.append(a)
        element.append(li)
    })
    detallePelicula.append(element)
}
async function fetchPelicula(url){
    try{
        const response = await fetch(url)
        if(!response.ok){
            throw new Error(`HTTP error! satus:${response.status}`)
        }
        const data = await response.json()
        crearPelicula(data)
    }catch(error){
        console.log(error.message)
    }
}
function crearPersonaje(datos){
    let infoPersonaje = document.getElementById("informacionPersonaje")
    infoPersonaje.innerHTML = ""

    let elemento = document.createElement("h2")
    elemento.innerHTML = datos.name
    infoPersonaje.append(elemento)

    elemento = document.createElement("p")
    elemento.innerHTML = `Altura: ${datos.height}`
    infoPersonaje.append(elemento)

    elemento = document.createElement("p")
    elemento.innerHTML = `Color de pelo: ${datos.hair_color}`
    infoPersonaje.append(elemento)

    elemento = document.createElement("p")
    elemento.innerHTML = `Color de ojos: ${datos.eye_color}`
    infoPersonaje.append(elemento)

    elemento = document.createElement("h3")
    elemento.innerHTML = `Armas`
    infoPersonaje.append(elemento)

    elemento = document.createElement("ul")
    datos.weapons.forEach(arma => {
        let li = document.createElement("li")
        li.innerHTML = arma
        elemento.append(li)
    });
    infoPersonaje.append(elemento)

    elemento = document.createElement("h4")
    elemento.innerHTML = "Películas"
    infoPersonaje.append(elemento)

    elemento = document.createElement("ul")
    datos.films.forEach(pelicula => {
        let li = document.createElement("li")
        let a = document.createElement("a")
        a.innerHTML = pelicula
        a.href = "#"
        a.addEventListener("click", () =>{
            fetchPelicula(pelicula)
        })
        li.append(a)
        elemento.append(li)
    });
    infoPersonaje.append(elemento)
}

function busquedaPersonaje(id){
    var url = `https://lotrapi.co/api/v1/characters/${id}`
    const xhr = new XMLHttpRequest();
    xhr.open("GET", url)
    xhr.send()

    xhr.addEventListener("readystatechange", (e) =>{
        if(xhr.readyState !== 4) return;
        if(xhr.status >= 200 && xhr.status < 300){
            console.log("entró")
            let json = JSON.parse(xhr.responseText)
            console.log(json)
            crearPersonaje(json)
        }else{
            console.log("error")
            let message = xhr.statusText || "Ocurrió un error"
            $xhr.innerHTML = `Error ${xhr.status}: ${message}`
        }
    })
}

buscaPersonaje.addEventListener("click", () =>{
    var id = document.getElementById("personajeId").value
    if(id == ""){
        alert("Debe insertar un id")
    }else if(id < 1 || id > 10){
        alert("El id debe estar comprendido entre 1 y 10")
    }else{
        busquedaPersonaje(id);
    }
})