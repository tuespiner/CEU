<!DOCTYPE html>
<html lang="es_ES">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1</title>
</head>
<body>
    <?php
    session_start();
    if(!isset($_SESSION["intentos"])){
        $_SESSION["intentos"] = 6;
    }
    if(!isset($_SESSION["aleatorio"])){
        $_SESSION["aleatorio"] = rand(1, 50);
    }
    $aleatorio = $_SESSION["aleatorio"];
    $error = "";
    $adivinado = "";
    $resultado = $_REQUEST["numero"];
    if($_SESSION["intentos"] != 0){
        if(!empty($resultado)){
            if($resultado == $aleatorio){
                $adivinado = "¡Correcto!, el número es ".$aleatorio;
            }else{
                $_SESSION["intentos"]--;
                if($resultado <1 || $resultado > 50){
                    $error = "¡ERROR! El número debe esta entre 1 y 50";
                }else{
                    $error = "¡Casi! Sigue intentandolo";
                }
            }
        }
    }else{
        $error = "¡Se Acabó! Te quedate sin intentos";
        if(isset($_SESSION["intentos"])){
            unset($_SESSION["intentos"]);
            unset($_SESSION["aleatorio"]);
            session_destroy();
        }
    }
    ?>
    <style>
        .error{ 
            color:red;
        }
        .adivinado{
            color:green;
        }
    </style>
    <h1>¡Adivina el número!</h1>
    <p>Reglas:</p>
    <ol>
        <li>El número a adivinar está entre el 1 y el 50.</li>
        <li>Tienes un máximo de <?php echo $_SESSION["intentos"]?> intentos.</li>
    </ol>
    <form action="#<?php echo $_SESSION["intentos"]?>" method="POST">
        <p>Creo que es el número... <input type="number" name="numero"> <input type="submit" value="Intentar"></p>
    </form>
    <p class="error"><?php echo $error;?></p>
    <p class="adivinado"><?php echo $adivinado;?></p>
</body>
</html>