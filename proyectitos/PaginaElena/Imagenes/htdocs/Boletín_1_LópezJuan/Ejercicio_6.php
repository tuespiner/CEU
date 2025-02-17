<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 6</title>
</head>
<body>
    <?php
    $cadena = "Harry";
    $entero = 123456789012345678;
    $variable = NULL;
    $var;
    for($i = 0; $i <3; $i++){
        if($i == 0){
            $var = $cadena;
        }elseif($i == 1){
            $var = $entero;
        }else{
            $var = $variable;
        }
        if(is_string($var)){
            echo "<p>string</p>";
        }elseif (is_int($var)){
            echo "<p>int</p>";
        }elseif (is_null($var)){
            echo "<p>null</p>";
        }
    }
    
    ?>
</body>
</html>