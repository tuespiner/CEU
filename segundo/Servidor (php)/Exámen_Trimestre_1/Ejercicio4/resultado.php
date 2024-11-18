<!DOCTYPE html>
<html lang="es_ES">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 4</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php session_start(); // inicio la sesión para poder acceder al?>
    <div>
        <h1>RESULTADO DE IMC</h1>
        <p><span style="color:black; margin:0px;">imc:</span> <?php echo $_SESSION["imc"]; // pongo el imc en la página?></p>
        <a href="index.php">Volver a la calculadora</a>
    </div>
    <?php session_destroy(); // borro la sesión?>
</body>
</html>