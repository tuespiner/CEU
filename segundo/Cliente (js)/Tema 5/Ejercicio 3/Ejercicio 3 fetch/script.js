window.addEventListener("DOMContentLoaded", () =>{
    const boton = document.getElementById("boton")
    boton.addEventListener("click", () =>{
        const url = "https://yesno.wtf/api"
        fetch(url)
        .then(response => response.json())
        .then(data  =>{
            if(boton.textContent == "ver imagen"){
                let img = document.getElementById("imagen")
                console.log(data.answer)
                img.src = data.image
            }else{
                let p = document.getElementById("p")
                console.log(data.answer)
                p.innerHTML = data.answer
            }
        })
    })

})