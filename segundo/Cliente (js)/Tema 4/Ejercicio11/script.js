var array = ["Invierno", "Primavera", "Verano", "Otoño"];
var continentes = ["Asia", "Europa", "Ameria", "Oceania", "Africa"];
var ul = document.createElement("ul");
array.forEach((valor) =>{
    let li = document.createElement("li");
    li.textContent=valor;
    ul.appendChild(li);
});

document.body.appendChild(ul);
var cad = "<ul>";
continentes.forEach((valor) =>{
    cad+= `<li>${valor}</li>`;
})
cad+="</ul>";
document.body.innerHTML+=cad;
