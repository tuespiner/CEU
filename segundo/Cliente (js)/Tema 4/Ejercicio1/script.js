var div = document.getElementById("myDIV").children
var p1 = div[0];
var p2 = div[1];

p1.style.backgroundColor = "yellow"
p2.style.backgroundColor = "orange"
//se puede hacer igual con getElementsByName solo que 
//cambiando el div.lenght por document.getElementsByname("p").lenght
for(let i = 0; i < div.length; i++){
    div[i].style.color = "red"
}