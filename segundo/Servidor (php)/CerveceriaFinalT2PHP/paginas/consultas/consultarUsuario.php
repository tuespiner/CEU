<?php
    //incluir la conexion de la bbdd
    include_once 'conexion.php';

    //funcion que hace las consultas para no repetir codigo
    function consulta($query){
        global $conn;
        $resultado = $conn->query($query);
            if(str_starts_with($query, "SELECT") && $resultado->num_rows == 0){
                $resultado = null;
            }
            return $resultado;
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
        return $resultado;
    }
    function anadirUsuario($contrasena, $correo, $edad){
        if(comprobarUsuario($correo, $contrasena) == NULL){
            $query = "INSERT INTO `usuario`(`correo`, `edad`, `contraseña`, `perfil`) 
            VALUES ('".$correo."','".$edad."','".$contrasena."','usuario')";
            $resultado = consulta($query);
            return $resultado;
        }else{
            return false;
        }
        
    }
    function comprobarUsuario($correo, $contrasena){
        $usuario = consultarUsuario($correo, $contrasena);
        if($usuario == null || !$usuario){
            echo "<p>Algun valor no es correcto</p>";
            return null;
        }else{
            while($fila = $usuario->fetch_assoc()){
                return $fila;
            }
        };
    }
?>