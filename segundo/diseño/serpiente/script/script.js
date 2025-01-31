var tamanoCampox = 400
var tamanoCampoy = 400
var cuerpoSerpiente = [
    {
        top: 5,
        left: 0,
        key: null
    },
    {
        top: 15,
        left: 0,
        key: null
    },
    {
        top: 25,
        left: 0,
        key: null
    },
    {
        top: 35,
        left: 0,
        key: null
    },
    {
        top: 45,
        left: 0,
        key: null
    }
]
var recordedKey = 'left'

$(document).ready(function(){
    var interval = setInterval(ini, 333)
})
function ini(){
    pintar()
    moverse()
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
    let posAnterior
    let posNueva = 0
    console.log('mama')
    for(let i = 0; i < cuerpoSerpiente.length; i++){
        console.log('hola')
        if(cuerpoSerpiente[i - 1] != undefined){
                posAnterior = cuerpoSerpiente[i -1]
                cuerpoSerpiente[i -1] = cuerpoSerpiente[i]
                console.log('hoila')
            if(i == 0){
                if(recordedKey == 'top'){
                    cuerpoSerpiente[i].top = cuerpoSerpiente[i].top - 10
                }else if(recordedKey == 'left'){
                    cuerpoSerpiente[i].left = cuerpoSerpiente[i].left - 10
                }else if(recordedKey == 'right'){
                    cuerpoSerpiente[i].left = cuerpoSerpiente[i].left + 10
                }else if(recordedKey == 'bottom'){
                    cuerpoSerpiente[i].top = cuerpoSerpiente[i].top + 10
                }
            }
        }
        
    }
}

