window.addEventListener("DOMContentLoaded", () =>{
        const url = "https://jsonplaceholder.typicode.com/users"
        fetch(url)
        .then(response => response.json())
        .then(data =>{
            data.forEach(element => {
                if(element.id == 5){
                    imprimir(element)
                    return
                }
            });
        })

    function imprimir(obj){
        var h1 = document.createElement("h1")
        h1.textContent = `Nombre: ${obj.name}`
        document.body.append(h1)
        var p = document.createElement("p")
        p.textContent = `Usuario: ${obj.username}`
        document.body.append(p)
        p = document.createElement("p")
        p.textContent = `Correo: ${obj.email}`
        document.body.append(p)
        p = document.createElement("p")
        p.textContent = `Dirección: ${obj.address.street}, ${obj.address.suite}, ${obj.address.city}`
        document.body.append(p)
    }
})