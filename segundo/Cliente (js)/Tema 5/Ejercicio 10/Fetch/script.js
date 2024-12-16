const boton = document.getElementById("b1")
async function accesoApi(url){
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
        var img = document.createElement("img")
        try{
            var response2 = await fetch(data.datos)
            if(!response2.ok){
                console.log("no funsiono")
            }
            console.log(response)
            var data2 = await response.json()
            img.setAttribute("src", URL.createObjectURL(data2))   
            var mapa = document.getElementById("mapa")
            mapa.append(img)
        }catch(error){
            console.log(error.message)
        }
    }catch(error){
        console.log(error.message)
    }
}
boton.addEventListener("click", (e) =>{
    e.preventDefault();
    var textarea = document.getElementById("apikey")
    accesoApi(`https://opendata.aemet.es/opendata/api/mapasygraficos/analisis?api_key=${textarea.value}`)
})