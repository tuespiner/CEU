var tamanoCampox = 400
var tamanoCampoy = 400
var cuerpoSerpiente = [
    {
        top: 5,
        left: 0,
    },
    {
        top: 15,
        left: 0,
    },
    {
        top: 25,
        left: 0,
    },
    {
        top: 35,
        left: 0,
    },
    {
        top: 45,
        left: 0,
    }
]
var interval
var recordedKey = 'up'
$(document).ready(function(){
    $('#fin').hide()
    $(document).on('keydown', function(event){
        detecBotones(event)
    })
    interval = setInterval(ini, 60)
})
function ini(){
    $('#fin').hide()
    pintar()
    moverse()
}
function detecBotones(event ){
    if(event.key == 'ArrowUp' || event.key == 'w'){
        recordedKey = 'up'
    }else if(event.key == 'ArrowDown' || event.key == 's'){
        recordedKey = 'down'
    }else if(event.key == 'ArrowLeft' || event.key == 'a'){
        recordedKey = 'left'
    }else if(event.key == 'ArrowRight' || event.key == 'd'){
        recordedKey = 'right'
    }
}

function pintar(){
    $('#selpiente').text('')
    cuerpoSerpiente.forEach(tramo => {
        let tlamo = document.createElement('div')
        tlamo.id = 'tramo'
        tlamo.style.top = `calc(50% - 5px + ${tramo.top}px)`
        tlamo.style.left = `calc(50% - 5px + ${tramo.left}px)`
        $('#selpiente').append(tlamo)
    })
}


function moverse(){
    let posAnteriorTop
    let posAnteriorLeft
    let posNuevaTop = cuerpoSerpiente[0].top
    let posNuevaLeft = cuerpoSerpiente[0].left
    if(recordedKey == 'up'){
        cuerpoSerpiente[0].top = cuerpoSerpiente[0].top - 10
    }else if(recordedKey == 'left'){
        cuerpoSerpiente[0].left = cuerpoSerpiente[0].left - 10
    }else if(recordedKey == 'right'){
        cuerpoSerpiente[0].left = cuerpoSerpiente[0].left + 10
    }else if(recordedKey == 'down'){
        cuerpoSerpiente[0].top = cuerpoSerpiente[0].top + 10
    }
    for(let i = 0; i < cuerpoSerpiente.length; i++){
        posAnteriorTop = cuerpoSerpiente[i + 1].top
        posAnteriorLeft = cuerpoSerpiente[i + 1].left
        if(cuerpoSerpiente[i + 1] != undefined){
           cuerpoSerpiente[i + 1].top = posNuevaTop 
           cuerpoSerpiente[i + 1].left = posNuevaLeft
        }else{
            cuerpoSerpiente[i].top = posNuevaTop 
            cuerpoSerpiente[i].left = posNuevaLeft
        }
        posNuevaTop = posAnteriorTop
        posNuevaLeft = posAnteriorLeft
        if(cuerpoSerpiente[0].top == 200){
            console.log('mecaguen10')
        }
        if(cuerpoSerpiente[0].top > 200 ||
             cuerpoSerpiente[0].top < -200 ||
              cuerpoSerpiente[0].left > 200 ||
               cuerpoSerpiente[0].left < -200){
                fin()
               }
    }
}

function fin(){
    clearInterval(interval)
    $('#fin').show()
    $('#reintentar').on('click', function(){
         location.reload()
    })
}
 s
