function accesoApi(url, tipoConsulta, id){
    fetch(url)
    .then(response => response.json())
    .then(data => {
        if(tipoConsulta == "consultas"){
            cargarPosts(data)
        }else if(tipoConsulta == "consulta"){
            cargarPost(data)
        }else if(tipoConsulta == "comentarios"){
            cargarComments(data, id)
        }
    })
}
function crearPost(resultado){
    let div2 = document.createElement("div")
    div2.id = resultado.id
    div2.addEventListener("click", () =>{
        accesoApi(`https://jsonplaceholder.typicode.com/posts/${resultado.id}/comments`, "comentarios",resultado.id )
    })
    let h1 = document.createElement("h1")
    h1.innerHTML = resultado.title
    let p = document.createElement("p")
    p.innerHTML = resultado.body
    div2.append(h1)
    div2.append(p)
    return div2
}
function cargarPosts(data){
    const div = document.getElementById("posts-list")
    if(div.children.length != 0){
        for(let i = 0; i < 5; i++){
            div.removeChild(div.children[0])
        }
    }
    data.forEach(resultado =>{
        div2 = crearPost(resultado)
        div.append(div2)
    })
}
function cargarComments(data, id){
    var divComments = document.getElementById("post-details")
    if(divComments.children.length != 0){
        cantChilds = divComments.children.length
        for(let i = 0; i < cantChilds; i++){
            divComments.removeChild(divComments.children[0])
        }
    }
    data.forEach(elemento =>{
        var div2 = document.createElement("div")
        var p = document.createElement("p")
        p.innerHTML = elemento.email
        div2.append(p)
        p = document.createElement("p")
        p.innerHTML = elemento.body
        div2.append(p)
        divComments.append(div2)
    })
}
function cargarPost(data){
    var divComments = document.getElementById("post-details")
    if(divComments.children.length != 0){
        cantChilds = divComments.children.length
        for(let i = 0; i < cantChilds; i++){
            divComments.removeChild(divComments.children[0])
        }
    }
    divComments.append(crearPost(data))
}
window.addEventListener("DOMContentLoaded", () =>{
    var pagina = 1;
    var url = `https://jsonplaceholder.typicode.com/posts?_page=${pagina}&_limit=5`
    accesoApi(url, "consultas", 0)
    var loadMore = document.getElementById("load-more-btn")
    loadMore.addEventListener("click", () =>{
        pagina++
        url = `https://jsonplaceholder.typicode.com/posts?_page=${pagina}&_limit=5`
        accesoApi(url, "consultas", 0)
    })
    var buscar = document.getElementById("search-btn")
    buscar.addEventListener("click",() =>{
        var input = document.getElementById("search-input")
        if(input.value != ""){
            accesoApi(`https://jsonplaceholder.typicode.com/posts/${input.value}`, "consulta", 0)
        }
    })
})