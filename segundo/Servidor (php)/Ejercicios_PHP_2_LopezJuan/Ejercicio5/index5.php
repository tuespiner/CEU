<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página 5</title>
</head>
<body>
    <?php
        session_start();
        $_SESSION["numero4"] = $_REQUEST["numero4"];
    ?>
    <form action="index6.php" method="POST">
        <input type="number" name="numero5" placeholder="Escribe el quinto numero">
        <input type="submit" value="enviar">
    </form>
</body>
</html>