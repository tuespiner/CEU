<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../styles/commonStyles.css">
    <link rel="stylesheet" href="../inputs/inputsStyles.css">
    <link rel="stylesheet" href="../../styles/catalogoStyle.css">
    <title>Cerveceria Juan</title>
</head>
<body>
    <?php
    session_start(); 
    include '../consultas/consultarProducto.php';
    include '../inputs/header.php';
    $_SESSION['productos'] = getProductos();
    if(!isset($_SESSION['posicionVerMas'])){
        $_SESSION['posicionVerMas'] =[];
    }
    if (isset($_GET['posicionVerMas'])) {
        if(in_array($_GET['positionVerMas'], $_SESSION['posicionVerMas'])){
            $arrayNuevo = [];
            foreach($_SESSION['posicionVerMas'] as $posicion){
                if($posicion != $_GET['positionVerMas']){
                    array_push($arrayNuevo, $posicion);
                }
            }
        }
        array_push($_SESSION['posicionVerMas'], $_GET['posicionVerMas']);
    }
    ?>
    <main>
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