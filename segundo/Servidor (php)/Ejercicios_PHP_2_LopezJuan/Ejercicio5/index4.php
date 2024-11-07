<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página 4</title>
</head>
<body>
    <?php
        session_start();
        $_SESSION["numero3"] = $_REQUEST["numero3"];
    ?>
    <form action="index5.php" method="POST">
        <input type="number" name="numero4" placeholder="Escribe el cuarto numero">
        <input type="submit" value="enviar">
    </form>
</body>
</html>