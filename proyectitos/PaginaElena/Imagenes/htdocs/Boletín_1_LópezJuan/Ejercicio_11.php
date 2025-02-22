<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 11</title>
</head>
<body>
    <h1>POST</h1>
    <form action="#" method="POST">
        <p>Nombre: <input type="text" name="nombre" id="nombre"></p>
        <p>Submit<input type="submit" name="submit" id="submit"></p>
    </form>
    <h1>GET</h1>
    <form action="#" method="GET">
    <p>Nombre: <input type="text" name="nombre" id="nombre"></p>
    <p>Submit<input type="submit" name="submit" id="submit"></p>
    </form>
    <?php
    $nombre = "";
    if($_POST==null){
        $nombre = $_GET['nombre'];
    }else{
        $nombre = $_POST['nombre'];
    };
    echo "Buenos días ",$nombre;
    
    ?>
</body>
</html>