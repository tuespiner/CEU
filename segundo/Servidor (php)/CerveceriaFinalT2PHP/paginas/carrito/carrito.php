<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../styles/commonStyles.css">
    <link rel="stylesheet" href="../inputs/inputsStyles.css">
    <title>Document</title>
</head>
<body>
    <?php
        session_start();
        include '../inputs/header.php';
        ?>
    <main>
        <?php
            if(empty($_SESSION['usuario']['carrito']))
        ?>

        <div class="productoCarrito">
            <div class="imagen"></div>
            <div>
                <h2></h2>
                <ul>
                    <li><p>Marca: </p></li>
                    <li><p>Tipo: </p></li>
                    <li><p>Tamaño: </p></li>
                </ul>
                <div>
                    <p>PrecioTotal: </p>
                    <input type="number" value="">
                </div>
            </div>
        </div>
    </main>
    <?php include '../inputs/footer.php';?>
</body>
</html>