window.addEventListener("DOMContentLoaded", ()=>{
    async function getRandom(){
        try{
            const url = " https://randomuser.me/api/"
            const response = await fetch(url)
            if(!response.ok){
                console.log("maricon")
            }
            const data = await response.json();
            let imagen = document.getElementById("imagen")
            imagen.src = data.results[0].picture.large
            let nombre = document.getElementById("nombre")
            nombre.innerHTML = `Nombre: ${data.results[0].name.first} ${data.results[0].name.last}`
            let correo = document.getElementById("correo")
            correo.innerHTML = `Correo: ${data.results[0].email}`
            let ciudad = document.getElementById("ciudad")
            ciudad.innerHTML = `Ciudad: ${data.results[0].location.city}`
        }catch(error){
            console.log(error.message)
        }

    } 
    const boton = document.getElementById("boton")
    boton.addEventListener("click", getRandom)
})