async function iniciarApi(){
    const url = "https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json"
    try{
        const response = await fetch(url)
        if(!response.ok){
            console.log("no funsiono")
        }
        const data = await response.json()
        cambiarEquipo(data.squadName, data.homeTown, data.formed)
    }catch(error){
        console.log(error.message)
    }
}
function cambiarEquipo(nombre, ciudad, fecha){
    var header = document.getElementById("header")
    var h1 = document.createElement("h1")
    h1.innerHTML = nombre
    var p = document.createElement("p")
    p.innerHTML = `Hometown: ${ciudad} // Formed: ${fecha}`
    header.append(h1)
    header.append(p)
}
function crearSuperheroe(nombre, identidad, edad, poderes){
    var array = [identidad, edad, poderes]
    var section = document.getElementById("section")
    var div = document.createElement("div")
    var elemento = document.createElement("h2")
    elemento.innerHTML = nombre
    div.append(elemento)
    for(let i = 0; i < array.length; i++){
        elemento = document.createElement("p")
        elemento.innerHTML = array[i]
        div.append(elemento)
    }
}
window.addEventListener("DOMContentLoaded", () =>{
    iniciarApi()
})