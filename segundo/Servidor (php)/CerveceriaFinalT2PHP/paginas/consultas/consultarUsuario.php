<?php
    //incluir la conexion de la bbdd
    include_once 'conexion.php';

    //funcion que hace las consultas para no repetir codigo
    function consulta($query){
        global $conn;
        if(str_starts_with($query, 'INSERT')){
        }else{
            $resultado = $conn->query($query);
            return $resultado;
        }
    }


    function consultarUsuarios(){
        $query = 'SELECT * FROM usuario';
        $resultado = consulta($query);

        if ($resultado->num_rows > 0) {
            // Recorrer los resultados y mostrar los usuarios
            while ($fila = $resultado->fetch_assoc()) {
                echo "ID: " . $fila["id"] . " - Correo: " . $fila["correo"] . "<br>";
            }
        } else {
            echo "No hay usuarios en la base de datos.";
        }
    }

    function consultarUsuario($correo, $contrasena){
        $query = "SELECT * FROM usuario WHERE correo like '".$correo."' and contraseña like '".$contrasena."'";
        $resultado = consulta($query);

    }
    function anadirUsuarios(){
        $query = "INSERT INTO usuario () VALUES ()"
    }
?>