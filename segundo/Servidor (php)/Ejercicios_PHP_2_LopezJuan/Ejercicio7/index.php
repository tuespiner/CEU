<!DOCTYPE html>
<html lang="es_ES">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 7</title>
</head>
<body>
    <?php
    session_start();
    if(!isset($_SESSION["numeros"])){
        $_SESSION["numeros"] = [];
    }
    if(isset($_REQUEST["numero"])){
        $numero = $_REQUEST["numero"];
    }
    function esPrimo($num) {
        if ($num <= 1) {
            return false;
        }
        for ($i = 2; $i <= sqrt($num); $i++) {
            if ($num % $i == 0) {
                return false;
            }
        }
        return true;
    }
    if($numero > 0){
        array_push($_SESSION["numeros"], $numero);
    }else{
        $media = 0;
        $máximo = 0;
        $mínimo;
        $primos = 0;
        foreach($_SESSION["numeros"] as $valor){
            if(!isset($mínimo)){
                $mínimo = $valor;
            }
            $media+= $valor;
            if($valor > $máximo){
             $máximo = $valor;
            }else if($valor < $mínimo){
                $mínimo = $valor;
            }
            if(esPrimo($valor)){
                $primos++;
            }
        }
        $media = round(($media / count($_SESSION["numeros"])), 2);
        unset($_SESSION["numeros"]);
        session_abort();
    }
    
    ?>
    <h1>MEDIA DE NUMEROS POSITIVOS</h1>
    <p>Si dices un numero negativo te vamos a decir la media, el mñaximo, el mínimo y los números primos</p>
   <form action="#" method="POST">
    <p>Dime el numero <input type="number" name="numero"></p>
    <input type="submit" value="Enviar">
   </form> 
   <ul>
        <li>
            <p>Media: <?php echo $media; ?></p>
        </li>
        <li>
            <p>Máximo: <?php echo $máximo; ?></p>
        </li>
        <li>
            <p>Mínimo: <?php echo $mínimo; ?></p>
        </li>
        <li>
            <p>Primos: <?php echo $primos; ?></p>
        </li>
   </ul>
</body>
</html>