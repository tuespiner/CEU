var name = false
var mail = false
var passwd = false
var cnfpaswd = false
var date = false
var checkbox = false
$(document).ready(function(){
    $('.login, .signup, #proveedor, #cliente, .error').hide()
    $('#inicia').on('click', function(){
        $('.login-signup, .login').toggle()
        $('#titulo').text('Cuenta')
    })
    $('#registra').on('click', function(){
        $('.login-signup, .signup').toggle()
        $('#titulo').text('Cuenta')
    })
    $('.botonProveedor').on('click', function(){
        $('.signup, #proveedor').toggle()
        $('#titulo').text('Crear una cuenta Proveedor')
    })
    $('.botonCliente').on('click', function(){
        $('.signup, #cliente').toggle()
        $('#titulo').text('Crear una cuenta Cliente')
    })
    $('input').change(function(){
        if($(this).attr('name') == 'nombre'){
            if($(this).val()!= null){
                name = true
            }else{
                name = false
            }
        }else if($(this).attr('name') == 'email'){
            if($(this).val()!= null){
                mail = true
            }else{
                mail = false
            }
        }else if($(this).attr('name') == 'contrasena'){
            if($(this).val()!= null){
                passwd = true
            }else{
                passwd = false
            }
        }else if($(this).attr('name') == 'confContrasena'){
            if($(this).val()!= null){
                cnfpaswd = true
            }else{
                cnfpaswd = false
            }
        }else if($(this).attr('name') == 'fecha'){
            date = true
        }else if($(this).attr('type') == 'checkbox'){
            if(this.checked){
                checkbox = true
            }else{
                checkbox = false
            }
        }
        if(name && passwd && mail && cnfpaswd && date && checkbox){
            $('#submitProveedor').removeAttr('disabled')
            $('#submitProveedor').attr('class', 'submitEnabled')
        }else{
            $('#submitProveedor').attr('disabled')
            $('#submitProveedor').removeAttr('class', 'submitEnabled')
        }
    })
})