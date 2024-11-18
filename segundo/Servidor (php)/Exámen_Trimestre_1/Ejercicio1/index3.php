<!DOCTYPE html>
<html lang="es_ES">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
    session_start(); // Abro sesión
    $total = 0; /* Defino una variable para tener la suma de los numeros 
                   seleccionados en la anterior página*/
    foreach($_SESSION["casillas"] as $casillas){ // foreach para hacer la suma de todos los datos
        $total+= $casillas;
    }
    ?>
    <div>
        <h1>TABLA DE UNA FILA CON CASILLAS DE VERIFICACIÓN (RESULTADO)</h1>
        <p>Ha marcado <span><?php echo count($_SESSION["casillas"]);?></span> casillas de un total de <span><?php echo $total;?></span>: 
        <span>
        <?php 
        foreach($_SESSION["casillas"] as $casillas){ // foreach para poner todos los numeros seleccionados 
            echo $casillas . " ";
        }
        ?>
        </span></p>
        <a href="index2.php">Volver a la tabla.</a>
        <a href="index1.php">Volver al formulario inicial.</a>
    </div>
</body>
</html>