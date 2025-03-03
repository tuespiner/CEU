const subir = document.getElementById("subir")
subir.addEventListener("click", () =>{
    location.hash = "#inicio"
})
$(document).ready(function(){
    if(sessionStorage.getItem('cookie') != 1){
        $('.privacidad').show().slideDown()
        $('body').css('overflow', 'auto')
        $('body').css('overflow-x', 'hidden')
    }
    $('.aceptar').click(function(){
        $('.privacidad').hide()
        $('body').css('overflow', 'auto')
        $('body').css('overflow-x', 'hidden')
        sessionStorage.setItem('cookie', 1)
    })
    $('.menu-movil').click(function(){
        $('.click-menu-movil').slideToggle()
    })
    $(window).resize(function(){
        if($(window).width() > 780){
            $('.click-menu-movil').slideUp()
        }
    })
    $('#cerrar').click(function(){
        $('.click-menu-movil').slideUp()
    })
})