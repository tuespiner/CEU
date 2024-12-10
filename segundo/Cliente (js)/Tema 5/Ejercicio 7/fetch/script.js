window.addEventListener("DOMContentLoaded", ()=>{
    function getRandom(){
        const url = " https://randomuser.me/api/"
        fetch(url)
        .then(response => response.json())
        .then(data => {
            let imagen = document.getElementById("imagen")
            imagen.src = data.results[0].picture.large
            let nombre = document.getElementById("nombre")
            nombre.innerHTML = `Nombre: ${data.results[0].name.first} ${data.results[0].name.last}`
            let correo = document.getElementById("correo")
            correo.innerHTML = `Correo: ${data.results[0].email}`
            let ciudad = document.getElementById("ciudad")
            ciudad.innerHTML = `Ciudad: ${data.results[0].location.city}`
        })
    }
    const boton = document.getElementById("boton")
    boton.addEventListener("click", getRandom)
})