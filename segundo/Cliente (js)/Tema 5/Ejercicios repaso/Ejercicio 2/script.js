const boton = document.getElementById("Mostrar")
const resultado = document.getElementById("resultado")
const url = "https://rickandmortyapi.com/api/character/";
async function obtenerPersonajes(){
    try{
        const response = await fetch(url)
        if(!response.ok){
            throw new Error(`HTTP error! status: ${response.status}`)
        }
        const data = await response.json()
        console.log(data)

    }catch(error){
        console.log(error.message)
    }
}

function crearPersonaje(div){
    var tarjeta = document.createElement("div")
    tarjeta.className = "Character-container"
    var elemento = document.createElement("img")
    
}

boton.addEventListener("click", () =>{
    obtenerPersonajes();
})