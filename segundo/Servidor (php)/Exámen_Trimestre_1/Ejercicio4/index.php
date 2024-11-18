<!DOCTYPE html>
<html lang="es_ES">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 4</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
        session_start(); // Abro la sesión
        $alturaERROR = ""; // Defino la variable de error de altura por si falta algún dato
        $pesoERROR = ""; // Defino la variable de error de peso por si falta algún dato
        $imc = ""; // Defino al variabl de imc para imprimirlo luego
        if((isset($_REQUEST["peso"]) && !empty($_REQUEST["peso"])) && 
        (isset($_REQUEST["altura"]) && !empty($_REQUEST["altura"]))){ // miro si se han introducido los datos
            $peso = intval($_REQUEST["peso"]); //paso el peso a int
            $altura = intval($_REQUEST["altura"]); //paso la altura a int
            $_SESSION["imc"] = round($peso / pow(($altura / 100) , 2)); // calculo el imc
            header("Location: resultado.php"); //Me redirijo a la página de resultado
        }else{
            if(empty($_REQUEST["altura"])){ // mensaje de error de altura
                $alturaERROR ="Falta introducir altura";
            }
            if(empty($_REQUEST["peso"])){ // mensaje de error de peso
                $pesoERROR = "Falta introducir peso";
            }
        }                                

    ?>

    <div>
        <h1>ÍNDICE DE MASA CORPORAL (FORMULARIO)</h1>
        <p>Escriba su peso en kilogramos y su altura en centímetros para calcular su índice de masa corporal.</p>
        <form action="#" method="POST">
            <p>Peso: <input type="number" name="peso"> kg</p>
            <span><?php echo $pesoERROR;?></span>
            <p>Altura: <input type="number" name="altura"> cm</p>
            <span><?php echo $alturaERROR;?></span>
            <div>
                <input type="submit" value="Calcular">
                <input type="reset" value="Borrar">
            </div>
            <?php echo $imc;?>
        </form>
    </div>
</body>
</html>