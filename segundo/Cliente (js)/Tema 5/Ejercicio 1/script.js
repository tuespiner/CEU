window.addEventListener("DOMContentLoaded", () =>{
    const xhr = new XMLHttpRequest();
    const div = document.getElementById("resultado");
    xhr.open("GET", "https://jsonplaceholder.typicode.com/users/5");
    xhr.send();
    xhr.addEventListener("readystatechange", (e) =>{
        if(xhr.readyState !== 4) return;

        if(xhr.status >= 200 && xhr.status < 300){
            console.log("entro")
            let json = JSON.parse(xhr.responseText);
            console.log(json)
            let h1 = document.createElement("h1")
            h1.textContent = `Nombre: ${json.name}`
            let p1 = document.createElement("p")
            p1.textContent = `Usuario: ${json.username}`
            let p2 = document.createElement("p")
            p2.textContent = `Correo: ${json.email}`
            let p3 = document.createElement("p")
            p3.textContent = `Dirección: ${json.address.street} ${json.address.suite} ${json.address.city}`
            div.append(h1)
            div.append(p1)
            div.append(p2)
            div.append(p3)
        }else{
            console.log("error");
            let message = xhr.statusText || "Ocurrió un error";
            xhr.innerHTML = `Error ${xhr.status}: ${message}`;

        }
    })
})
