const button = document.getElementById("boton")
async function getTarta(){
    const url = "https://www.themealdb.com/api/json/v1/1/random.php"
    const div = document.getElementById("div")  
    div.innerHTML = "";   
    
    try{
        const response = await fetch(url)
        if(!response.ok){
            console.log("no funsiono")
        }

        const data = await response.json()
        const comida = data.meals[0]

        var h2 = document.getElementById("h2")
        h2.innerHTML = comida.strMeal

        var array = []

        for(let key in comida){
            if(key.startsWith("strIngredient") && 
            comida[key] != null && 
            comida[key] != ""){
                array.push(comida[key])
            }
        }
        rellenarDiv(div, comida.strMealThumb, array, comida.strSource)
        
    }catch(error){
        console.log(error.message)
    }
}

function rellenarDiv(div, src, lista, href){
    var elemento = document.createElement("img")
    elemento.src = src
    div.append(elemento)
    elemento = document.createElement("ol")
    
    lista.forEach(element => {
        var li = document.createElement("li")
        li.innerHTML = element
        elemento.append(li)
    });
    div.append(elemento)
    elemento = document.createElement("a")
    elemento.innerHTML = "Web Receta"
    if(href == null){
        elemento.href = "#"
    }else{
        elemento.href = href
    }
    div.append(elemento)
}
button.addEventListener("click", () =>{
    getTarta()
})