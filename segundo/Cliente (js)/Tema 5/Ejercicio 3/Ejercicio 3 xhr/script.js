window.addEventListener("DOMContentLoaded", () =>{
    const boton = document.getElementById("boton")
    boton.addEventListener("click", () =>{
        let xhr = new XMLHttpRequest();
        xhr.open("GET", "https://yesno.wtf/api")
        xhr.send();
        xhr.addEventListener("readystatechange", () =>{
            if(xhr.readyState !== 4)return;

            if(xhr.status >= 200 && xhr.status < 300){
                console.log("ci")
                let json = JSON.parse(xhr.responseText)
                console.log(json)
                if(boton.textContent == "ver imagen"){
                    let img = document.getElementById("imagen")
                    console.log(json.answer)
                    img.src = json.image
                }else{
                    let p = document.getElementById("p")
                    console.log(json.answer)
                    p.innerHTML = json.answer
                }
            }else{
                console.log("Non")
            }
        })
    })

})