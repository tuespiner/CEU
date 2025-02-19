<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/catalogoStyle.css">
    <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    <title>Cerveceria Juan</title>
</head>
<body class="min-h-screen w-screen">
    <?php
    session_start(); 
    include '../consultas/consultarProducto.php';
    include '../inputs/header.php';
    $_SESSION['productos'] = getProductos();
    ?>
    <main class="w-screen min-h-screen py-12 px-24">
        <?php
        if($_SESSION['productos'] != null){
            if($_SESSION['usuario']['perfil'] == 'admin'){
                include 'catalogoAdmin.php';
            }else{
                include 'catalogoUsuario.php';
            }
        }else{
            echo "<h2>No hay productos en la base de datos</h2>";
        }
            
        ?>
    </main>
    <?php include '../inputs/footer.php'?>
</body>
</html> 