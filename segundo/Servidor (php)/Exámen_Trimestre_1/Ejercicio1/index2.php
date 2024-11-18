<!DOCTYPE html>
<html lang="es_ES">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
    session_start(); // Abro la sesión 
    if(isset($_REQUEST["opcion"])){ // Miro si se han seleccionado los checkbox
        $_SESSION["casillas"] = $_REQUEST["opcion"]; /*Defino una variable en la sesión con los datos
                                                       introducidos por los checkbox*/ 
        header("location: index3.php"); // Me redirijo a la siguiente página
    }
    ?>
    <div>
        <h1>TABLA DE UNA FILA CON CASILLAS DE VERIFICACIÓN (FORMULARIO 2)</h1>
        <p>Marque las casillas de verificación que quiera y contraré cuántas ha marcado.</p>
        <form action="#" method="POST">
            <table>
                <tr>
                    <?php
                    for($i = 1;$i <= $_SESSION["numero_columnas"]; $i++ ){
                        echo '<td><input type="checkbox" name="opcion[]" value="'.$i.'">'.$i.'</td>';
                    }
                    ?>
                </tr>
            </table>
            <div>
                <input type="submit" value="Contar">
                <input type="reset" value="Borrar">
            </div>
        </form>
        <a href="index1.php">Volver al formulario.</a>
    </div>
</body>
</html>