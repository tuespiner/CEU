<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/catalogoStyle.css">
    <title>Cerveceria Juan</title>
</head>
<body>
    <main>
        <?php
            while ($fila = $_SESSION['productos']->fetch_assoc()){
                echo '<div>';
                echo '<div class="imagen"></div>';
                echo '<h2>'.$fila['formato'].'</h2>';
                echo '<ul><li><p>Marca: '.$fila['marca'].'</p></li>';
                echo '<li><p>Tipo: '.$fila['tipo'].'</p></li>';
                echo '<li><p>Tamaño: '.$fila['tamano'].'</p></li>';
                echo '<li><p>Precio: '.$fila['precio'].'€</p></li></ul>';
                echo '<div><a href="">AÑADIR AL CARRITO</a>';
                echo '<a href="">VER MÁS</a></div></div>';
            }
        ?>
    </main>
</body>
</html>