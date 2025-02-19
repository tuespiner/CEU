<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    <title>Document</title>
</head>
<body>
    <header class="flex justify-between items-center w-screen p-4 bg-yellow-700 text-white">
        <div class="rounded-full"></div>
        <h2 class="text-3xl">Cerveceria Juan</h2>
        <nav clas="flex gap-12">
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