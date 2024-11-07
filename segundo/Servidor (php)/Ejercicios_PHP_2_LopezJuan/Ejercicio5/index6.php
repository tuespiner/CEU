<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página 6</title>
</head>
<body>
    <?php
        session_start();
        $_SESSION["numero5"] = $_REQUEST["numero5"];
    ?>
    <form action="index.php" method="POST">
        <input type="number" name="numero6" placeholder="Escribe el sexto numero">
        <input type="submit" value="enviar">
    </form>
</body>
</html>