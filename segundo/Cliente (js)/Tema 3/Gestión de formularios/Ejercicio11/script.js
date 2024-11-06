window.addEventListener("DOMContentLoaded", () =>{
    var form = document.forms[0];
    var submit = form.getElementsByTagName("input")[0];
    submit.addEventListener("click", (e) =>{
        e.preventDefault();
        var textArea = form.getElementsByTagName("textarea")[0];
        var p = document.getElementsByTagName("p")[0];
        if(textArea.value >= 18){
            p.setAttribute("class","mayor");
            p.innerHTML="Es mayor de edad"
        }else{
            p.setAttribute("class","menor");
            p.innerHTML="Es menor de edad"
        }
        document.body.appendChild(p);
    })
})