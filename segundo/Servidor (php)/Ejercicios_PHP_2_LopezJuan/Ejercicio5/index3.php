<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página 3</title>
</head>
<body>
    <?php
        session_start();
        $_SESSION["numero2"] = $_REQUEST["numero2"];
    ?>
    <form action="index4.php" method="POST">
        <input type="number" name="numero3" placeholder="Escribe el tercer numero">
        <input type="submit" value="enviar">
    </form>
</body>
</html>