window.addEventListener("DOMContentLoaded", () =>{
    const boton = document.getElementById("boton")
    boton.addEventListener("click", () =>{
        const url = "https://yesno.wtf/api"
        async function getImgAnswer(){
            const response = await fetch(url)
            if(!response.ok){
                console.log("mamaheiuvo")
            }
            const data = await response.json()
            if(boton.textContent == "ver imagen"){
                let img = document.getElementById("imagen")
                console.log(data.answer)
                img.src = data.image
            }else{
                let p = document.getElementById("p")
                console.log(data.answer)
                p.innerHTML = data.answer
            }
        }
        getImgAnswer()
    })

})