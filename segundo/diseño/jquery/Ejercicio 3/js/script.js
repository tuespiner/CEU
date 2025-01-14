$(document).ready(function(){
    $('.ocultado,.contenido').hide()
    $('.mostrado,.ocultado').on('click', function(){
        $('.mostrado,.ocultado,.contenido').toggle()
    })
})