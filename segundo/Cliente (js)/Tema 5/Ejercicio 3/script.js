window.addEventListener("DOMContentLoaded", () =>{
    const boton = document.getElementById("boton")
    boton.addEventListener("click", () =>{
        const xhr = new XMLHttpRequest();
        xhr.open("GET", "https://yesno.wtf/api")
        xhr.send();
        xhr.addEventListener("readystatechange", () =>{
            if(xhr.status !== 4)return;

            if(xhr.statusText >= 200 && xhr.statusText < 300){
                console.log("ci")
                let json = JSON.parse(xhr.responseText)
                console.log(json)
                let p = document.getElementById("p")
                p.textContent = json.answer
                let boton2 = document.createElement("button")
                boton2.textContent = "ver Imagen"
                document.body.append(buton2)
                boton2.addEventListener("click", () =>{
                    
                })
            }else{
                console.log("Non")
            }
        })
    })
})