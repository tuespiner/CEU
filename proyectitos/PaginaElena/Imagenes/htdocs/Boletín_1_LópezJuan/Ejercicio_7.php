<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 7</title>
</head>
<body>
    <?php
    $valor1 = "qwert";
    $valor2 = 12345678901234567890;
    $valor3 = true;
    $valor4 = 1234;
    $valor5 = NULL;
    $var;
    for($i = 0; $i <5; $i++){
        switch ($i){
            case 0:
                $var = $valor1;
                break;
            case 1:
                $var = $valor2;
                break;
            case 2:
                $var = $valor3;
                break;
            case 3:
                $var = $valor4;
                break;
            case 4:
                $var = $valor5;
                break;
        }
        if(is_string($var)){
            echo "<p>string</p>";
        }elseif (is_int($var)){
            echo "<p>int</p>";
        }elseif (is_null($var)){
            echo "<p>null</p>";
        }elseif (is_bool($var)){
            echo "<p>boolean</p>";
        }elseif (is_float($var)){
            echo "<p>float</p>";
        }
    }
    ?>
</body>
</html>