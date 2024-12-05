window.addEventListener("DOMContentLoaded", () =>{
    var lista = document.getElementById("lista")
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "https://opentdb.com/api.php?amount=5&type=multiple")
    xhr.send();
    xhr.addEventListener("readystatechange", () =>{
        if(xhr.status !== 4)return;

        if(xhr.statusText >= 200 && xhr.statusText < 300){
            console.log("ci")
            let json = JSON.parse(xhr.responseText)
            
        }else{
            console.log("no")
        }
    })
})