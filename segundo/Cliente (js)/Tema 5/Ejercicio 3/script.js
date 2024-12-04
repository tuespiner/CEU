window.addEventListener("DOMContentLoaded", () =>{
    const boton1 = document.getElementById("boton1")
    const boton2 = document.getElementById("boton2") 
    boton1.addEventListener("click", () =>{
        let xhr = new XMLHttpRequest();
        xhr.open("GET", "https://yesno.wtf/api")
        xhr.send();
        xhr.addEventListener("readystatechange", () =>{
            if(xhr.readyState !== 4)return;

            if(xhr.status >= 200 && xhr.status < 300){
                console.log("ci")
                let json = JSON.parse(xhr.responseText)
                console.log(json)
                let p = document.getElementById("p")
                console.log(json.answer)
                p.innerHTML = json.answer
            }else{
                console.log("Non")
            }
        })
    })
    boton2.addEventListener("click", () =>{
        let xhr = new XMLHttpRequest();
        xhr.open("GET", "https://yesno.wtf/api")
        xhr.send();
        xhr.addEventListener("readystatechange", () =>{
            if(xhr.readyState !== 4)return;

            if(xhr.status >= 200 && xhr.status < 300){
                console.log("ci")
                let json = JSON.parse(xhr.responseText)
                console.log(json)
                let img = document.getElementById("imagen")
                console.log(json.answer)
                p.src = json.image
            }else{
                console.log("Non")
            }
        })
    })
})