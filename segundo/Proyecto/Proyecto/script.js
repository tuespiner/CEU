const subir = document.getElementById("subir")
subir.addEventListener("click", () =>{
    location.hash = "#inicio"
})
$(document).ready(function(){
    if(sessionStorage.getItem('cookie') != 1){
        $('.privacidad').show()
        $('body').css('overflow', 'auto')
        $('body').css('overflow-x', 'hidden')
    }
})