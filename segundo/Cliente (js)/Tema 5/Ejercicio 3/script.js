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
            }else{
                console.log("Non")
            }
        })
    })
})