async function getPokemon(url){
    try{
        const response = await fetch(url)
        if(!response.ok){
            console.log("no fufa")
        }
        const data = await response.json()
        crearPokemon(data)
    }catch(error){
        console.log(error.message)
    }
}
function crearPokemon(data){
    const div = document.getElementById("resultado")
    div.innerHTML = ""
    let elemento = document.createElement("img")
    elemento.src = data.sprites.front_default
    div.append(elemento)
    elemento = document.createElement("h3")
    elemento.innerHTML = "NOMBRE"
    div.append(elemento)
    elemento = document.createElement("p")
    elemento.innerHTML = data.name
    div.append(elemento)
    elemento = document.createElement("h3")
    elemento.innerHTML = "ABILIDADES"
    div.append(elemento)
    let lista = document.createElement("ol")
    for(let i = 0; i < data.abilities.length; i++){
        let fila = document.createElement("li")
        elemento = document.createElement("p")
        console.log(data.abilities[i].ability)
        elemento.innerHTML = data.abilities[i].ability.name
        fila.append(elemento)
        lista.append(fila)
    }
    div.append(lista)
}

window.addEventListener("DOMContentLoaded", () =>{
    const submit = document.getElementById("buscar")
    submit.addEventListener("click", (e) =>{
        e.preventDefault();
        let numero = document.getElementById("numeroPokemon")
        let url = `https://pokeapi.co/api/v2/pokemon/${numero.value}/`
        getPokemon(url)
    })
})