window.addEventListener("DOMContentLoaded", () =>{
    async function getUser5(){
        const url = "https://jsonplaceholder.typicode.com/users"
        try{
            const response = await fetch(url)
            if(!response.ok){
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json();
            data.forEach(element => {
                if(element.id == 5){
                    imprimir(element)
                    return
                }
            });
        }catch(error){
            console.log(error.message)
        }
    }
    getUser5();

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