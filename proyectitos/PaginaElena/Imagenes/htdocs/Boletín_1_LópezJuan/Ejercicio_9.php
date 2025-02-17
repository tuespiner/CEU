<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $estatura = array("Rosa" => 168, "Ignacio" => 175, "Daniel" => 172, "Rubén" => 182);
    $cadena = $estatura["Daniel"];  //los array no se pueden concatenar como en java, se tiene que hacer variables para que se puedan concatenar
                                    //(Por lo menos no se pueden concatenar con print) y print se concatena las variables poniendolas simplemente
    print "La estatura de Daniel es $cadena  cm";
    ?>
</body>
</html>