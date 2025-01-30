$(document).ready(function(){
    $('.login, .signup').hide()
    $('#inicia').on('click', function(){
        $('.login-signup, .login').toggle()
        $('#titulo').text('Cuenta')
    })
    $('#registra').on('click', function(){
        $('.login-signup, .signup').toggle()
    })
})