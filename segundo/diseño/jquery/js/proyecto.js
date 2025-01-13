$(document).ready(function(){
    $('.bloque').hide();
})
$('button').click(function(){
    if($(this).text() == "mostrar"){
        $(this).text("ocultar")
    }else{
        $(this).text("mostrar")
    }
   $('.bloque').toggle();
})