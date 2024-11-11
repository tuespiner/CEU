
<html lang="es">
<title>Ejercicio 2</title>
<?php
    $var = [NULL, true, false, 0, 3.8, '0', '10', '6 metros', 'hola'];
    echo "Conversión a int <br><ul>";
    foreach($var as $element){
        echo "<li>".$element. " = ". intval($element)."</li>";
    }
    echo "</ul>Conversión a boolean <br><ul>";
    foreach($var as $element){
        echo "<li>".$element. " = ". (boolean)$element."</li>";
    }
    echo "</ul>Conversión a string <br><ul>";
    foreach($var as $element){
        echo "<li>".$element. " = ". strval($element)."</li>";
    }
    echo "</ul>Conversión a float <br><ul>";
    foreach($var as $element){
        echo "<li>".$element. " = ". floatval($element)."</li>";
    }
    echo "</ul>";
?>
</html>