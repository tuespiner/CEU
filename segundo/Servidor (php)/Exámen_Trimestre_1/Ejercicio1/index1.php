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
    session_start(); // Abro la sesión para poder tener los datos en todas las distintas páginas
    if(isset($_REQUEST["tamaño_tabla"])){ /* Miro si el tamaño de la tabla se ha introducido para 
                                             evitar que salga un error*/  
        $_SESSION["numero_columnas"] = $_REQUEST["tamaño_tabla"]; /* Defino el tamaño de la tabla en una
                                                                     Variable de la sesión*/ 
        if($_SESSION["numero_columnas"] > 0 && $_SESSION["numero_columnas"] <= 20){ // Valido los datos
            header("Location: index2.php"); // Me redirijo a la siguiente página
        }
    }
    ?>
    <div>
    <h1>TABLA DE UNA FILA CON CASILLAS DE VERIFICACIÓN (FORMULARIO 1)</h1>
    <p>Escriba un número (0 < número &le; 20) y mostraré una fila de ese tamaño con casillas de verificación en cada celda.</p>
        <form action="#" method="POST">
            <p>Tamaño de la tabla <input type="number" name="tamaño_tabla"></p>
            <div>
                <input type="submit" value="Mostrar">
                <input type="reset" value="Borrar">
            </div>
        </form>
    </div>
</body>
</html>