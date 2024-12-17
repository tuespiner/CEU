var array = [];
var contador = 0;
async function getImagenes(e){
    console.log("hola")
    const url = "https://randomuser.me/api?results=1000"
    try{
        const response = await fetch(url)
        if(!response.ok){
            console.log("no funsiono")
        }
        const datos = await response.json()
        datos.results.forEach(imagen => {
            array.push(imagen.picture.large)
        })
        var interval = setInterval(()=>{
            imagenesNuevas(interval)
        }, 200)
        
    }catch(error){
        console.log(error.message)
    }
}
function barajarArray(){
    var anterior 
    var posterior
    for(let i = 0; i < array.length; i++){
        let posicion1 = Math.floor(Math.random() * 1000)
        anterior = array[posicion1]
        let posicion2 = Math.floor(Math.random() * 1000)
        posterior = array[posicion2]
        array[posicion1] = posterior
        array[posicion2] = anterior
    }
}
function imagenesNuevas(e){
    console.log(contador)
    if(contador == 100){
        clearInterval(e)
    }
    contador++
    var div = document.getElementById("contenido")
    barajarArray()
    if(div.children.length == 0){
        for(let i = 0; i < 50; i++){
            crearImagen(array[i], div)
        } 
    }else{
        for(let i = 0; i < 50; i++){
            div.children[i].src = array[i]
        } 
    }
    
}
function crearImagen(url,div){
    var img = document.createElement("img")
    img.src = url
    div.append(img)
}
window.addEventListener("DOMContentLoaded", () => {
    getImagenes()
})