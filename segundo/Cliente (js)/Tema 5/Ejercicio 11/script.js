// aJRWVlBLad2Xfb6TMo3KGBsqeDixRR9GOiAZHYWk
const apiKey = prompt("Dime la api key")
const input = document.getElementById("fecha")
input.addEventListener("change", () =>{
    var url = ` https://api.nasa.gov/planetary/apod?api_key=${apiKey}&date=${input.value}`
    getImagen(url)
})
async function getImagen(url){
    const figure = document.getElementById("imagen")
    try{
        const response = await fetch(url)
        if(!response.ok){
            console.log("mamahuevo")
        }
        const data = await response.json()
        if(figure.children.length == 0){
            var img = document.createElement("img")
            figure.append(img)
        }
        figure.children[0].src = data.url
    }catch(error){
        console.log(error.message)
    }
}