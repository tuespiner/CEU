window.addEventListener("DOMContentLoaded", () =>{
    var objetosLiterales = [{id : 1, nombre : "nombre1", precio : 10, codigo : "1"},
        {id : 2, nombre : "nombre2", precio : 9, codigo : "2"},
        {id : 3, nombre : "nombre3", precio : 15, codigo : "3"},
        {id : 4, nombre : "nombre4", precio : 2, codigo : "4"}
    ]
    var contador = 1;

    var tbody = document.getElementById("cuerpoTabla");
    var tr = document.getElementsByTagName("thead")[0].children[0];
    var buttons = document.getElementsByTagName("button");
    var boton1 = buttons[0]
    var boton2 = buttons[1]
    var boton3 = buttons[2]
    
    var marcar = document.createElement("th")
    marcar.innerHTML="Marcar"
    tr.appendChild(marcar);
    //Función de creación de la tabla
    function crearElemento(objeto){
        //creación de la fila
        let tr = document.createElement("tr");
        tr.id = objeto.id; // se le pone el id
        tr.className = "elemento" // se le pone el nombre de la clase
        //variable td (esto es como una variable comodín)
        let td = document.createElement("td")
        for(let i = 0; i < 4; i++){
            //creación de la columna
            let td = document.createElement("td")
            //los if son para ver que va en cada columna, la 0 es esto, la 1 es esto, etc
            if(i == 0){
                let a = document.createElement("a")
                a.href = "#"
                a.innerHTML=objeto.nombre
                td.appendChild(a)
            }else if(i == 1){
                td.innerHTML=`${objeto.precio}€`
            }else if(i == 2){
                td.innerHTML=objeto.codigo
            }else{
                td = document.createElement("input")
                td.id=`checkbox${contador}`
                td.type="checkbox"
                td.value="marcar"
                contador++
            }
            //se añade la columna a la fila
            tr.appendChild(td);
        }
        //se añade la fila a la tabla
        tbody.appendChild(tr)
    }
    
    objetosLiterales.forEach(objeto =>{
        crearElemento(objeto)
    })
    function button(e){
        let checkbox = document.getElementsByTagName("input")
        if(e == 1){
            for(let i = 0; i < checkbox.length; i++){
                checkbox[i].checked = true
            }
        }else if(e == 2){
            for(let i = 0; i < checkbox.length; i++){
                checkbox[i].checked = false
            }
        }else{
            for(let i = 0; i < checkbox.length; i++){
                if(checkbox[i].checked){
                    checkbox[i].parentElement.remove()
                }
            }
        }
    }
    boton1.addEventListener("click", () =>{
        button(1)
    })
    boton2.addEventListener("click", () =>{
        button(2)
    })
    boton3.addEventListener("click", () =>{
        button(3)
    })

    var botonAñadir = document.getElementById("add")
    botonAñadir.addEventListener("click", () =>{
        let inputs = document.getElementsByTagName("div")[0].children;
        let array = []
        for( let child of inputs){
            if(child.type == "text"){
                array.push(child)
            }
        }
        let objeto = {id : Number(tbody.children.length)+1, nombre: array[0].value, precio: array[1].value, codigo: array[2].value}
        crearElemento(objeto)
    })
})