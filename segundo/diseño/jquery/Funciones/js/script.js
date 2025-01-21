var pixeles = 0
var contador = 0
var interval
$(document).ready(function(){
    $('#Ejercicio1').click( function() {
        ejercicio1(this)
    })
    $(document).on("keydown", function(event){
        ejercicio2(event)
    })
})
function ejercicio1(button){
    $(button).hide()
}

function ejercicio2(event){
    if(event.key == "ArrowUp"){
        console.log('arriba')
    }else if(event.key == "ArrowDown"){
        console.log('abajo')
    }else if(event.key == "ArrowLeft"){
        console.log('izquierda')
    }else if(event.key == "ArrowRight"){
        var interval = setInterval(function(){
            contador++
            if(contador == 6){
                clearInterval(interval)
                contador=0
            }
            $('div').css("margin-left",pixeles+=10)
        }, 250)
        console.log('derecha')
    }
}
