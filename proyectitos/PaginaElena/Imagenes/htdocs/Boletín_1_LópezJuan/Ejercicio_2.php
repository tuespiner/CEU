<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 2</title>
</head>
<body>
    <?php
    $radio = 4;
    $pi = 3.14;
    $area = $pi * ($radio**2);
    echo "<h1>CALCULAR ÁREA DEL CIRCULO CON RADIO 4</h1><br><p>",$area,"</p>";
    $circunferencia = (2*$pi)*$radio;
    echo"<h1>CALCULAR CIRCUNFERENCIA DEL CIRCULO CON RADIO 4</h1><br><p>",$circunferencia,"</p>";
    ?>
</body>
</html>