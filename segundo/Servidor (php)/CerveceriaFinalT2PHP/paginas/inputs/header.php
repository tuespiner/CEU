<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="inputsStyles.css">
    <title>Document</title>
</head>
<body>
    <header>
        <div></div>
        <h2>Cerveceria Juan</h2>
        <nav>
            <?php
                if($_SESSION["usuario"]["perfil"] == "admin"){
                    echo '<a href="../home/home.php">Home</a>';
                }
            ?>
            <a href="../catalogo/catalogo.php">Catálogo</a>
            <?php
                if($_SESSION["usuario"]["perfil"] == "usuario"){
                    echo '<a href="../carrito/carrito.php">Carrito</a>';
                }
            ?>
            <a href="../index/index.php?accion=cerrarSesion">Cerrar Sesión</a>
        </nav>
    </header>   
</body>
</html>