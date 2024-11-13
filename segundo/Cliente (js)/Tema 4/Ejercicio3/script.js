var div = document.getElementById("div1");
var p = document.createElement("p");
p.innerHTML="Soy el nuevo"
p.id = "p3"
div.appendChild(p);
var p2 = document.createElement("p")
p2.innerHTML="Soy el primero ahora"
div.insertBefore(p2, div.children[0])