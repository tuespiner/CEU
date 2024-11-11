var a1 = document.getElementById("enlace_1");
var a2 = document.getElementById("enlace_2");
var a3 = document.getElementById("enlace_3");
var p1 = document.getElementById("contenidos_1");
var p2 = document.getElementById("contenidos_2");
var p3 = document.getElementById("contenidos_3");
a1.addEventListener("click", (e) =>{
    e.preventDefault();
    cambiar(a1, p1, 1);
});
a2.addEventListener("click", (e) =>{
    e.preventDefault();
    cambiar(a2, p2, 2)
});
a3.addEventListener("click", (e) =>{
    e.preventDefault();
    cambiar(a3, p3, 3)
});
function cambiar(a, p, i){
    if(p.style.visibility == "visible"){
        a.innerHTML=`Mostrar contenido ${i}`;
        p.style.visibility="hidden";
    }else{
        p.style.visibility="visible";
        a.innerHTML=`Ocultar contenido ${i}`;
    }
}