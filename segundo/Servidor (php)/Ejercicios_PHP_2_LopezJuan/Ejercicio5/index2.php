<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página 2</title>
</head>
<body>
    <?php
        session_start();
        $_SESSION["numero1"] = $_REQUEST["numero1"];
    ?>
    <form action="index3.php" method="POST">
        <input type="number" name="numero2" placeholder="Escribe el segundo numero">
        <input type="submit" value="enviar">
    </form>
</body>
</html>