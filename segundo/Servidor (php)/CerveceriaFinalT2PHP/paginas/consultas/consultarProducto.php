<?php
include_once 'conexion.php';

function consulta($query){
    global $conn;
    $resultado = $conn->query($query);
        if(str_starts_with($query, "SELECT") && $resultado->num_rows == 0){
            $resultado = null;
        }
        return $resultado;
}

function getProductos(){
    $query = "SELECT * FROM producto";
    $resultado = consulta($query);
    if ($resultado->num_rows > 0) {
        return $resultado;
    } else {
        return null;
    }
}
?>