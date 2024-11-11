<html lang="es">
<title>Resultado</title>
<?php
session_start();
$_SESSION["numero6"] = $_REQUEST["numero6"];
$num1 = $_SESSION["numero1"];
$num2 = $_SESSION["numero2"];
$num3 = $_SESSION["numero3"];
$num4 = $_SESSION["numero4"];
$num5 = $_SESSION["numero5"];
$num6 = $_SESSION["numero6"];
print $num1;
print $num2;
print $num3;
print $num4;
print $num5;
print $num6;
?>
</html>