//apikey eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFuc3BpbmVyODlAZ21haWwuY29tIiwianRpIjoiNDkwZTA2MWYtODgyMC00NDkzLTkxNjItMjk0ZWM4YWFhZmEwIiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE3MzQzNzYxMDQsInVzZXJJZCI6IjQ5MGUwNjFmLTg4MjAtNDQ5My05MTYyLTI5NGVjOGFhYWZhMCIsInJvbGUiOiIifQ.7x4fbxTF4akE1sBAFNWqxyww0Ukccoxfr76oL1uFxc0
const boton = document.getElementById("b1")
async function accesoApi2(url, div){
    try{
        const response = await fetch(url)
        if(!response.ok){
            console.log("no funsiono")
        }
        var data = await response.blob()
        console.log(data)
        var img = document.createElement("img")
        img.setAttribute("src", URL.createObjectURL(data))
        console.log(img)
        div.append(img)
    }catch(error){
        console.log(error.message)
    }
}
async function accesoApi1(url){
    try{
        var headers = new Headers({ "cache-control": "no-cache", });
        const response = await fetch(url, {
            method: "GET",
            mode: "cors",
            headers: headers
        })
        if(!response.ok){
            console.log("no funsiono")
        }
        var data = await response.json()
        console.log(data)
        var div = document.getElementById("mapa")
        accesoApi2(data.datos, div)
    }catch(error){
        console.log(error.message)
    }
}
boton.addEventListener("click", (e) =>{
    e.preventDefault();
    var textarea = document.getElementById("apikey")
    accesoApi1(`https://opendata.aemet.es/opendata/api/mapasygraficos/analisis?api_key=${textarea.value}`)
})