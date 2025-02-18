<?php 
    //Dato para hacer la consulta
    $servidor = '127.0.0.1:3307';
    $usuario = 'root';
    $clave = '';
    $baseDatos = 'aquinovendemoscruzcampo';

    //Crear conexion a bbdd
    $conn = new mysqli($servidor, $usuario, $clave, $baseDatos);

    //Verificar conexion bbdd
    if ($conn->connect_error){
        die('error de conexion: '.$conn->connect_error);
    }    
?>