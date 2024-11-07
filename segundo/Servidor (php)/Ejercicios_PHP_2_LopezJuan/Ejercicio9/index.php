<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 9</title>
</head>
<body>
    <?php
    $Nombre = $_REQUEST["nombre"];
    $Edad = $_REQUEST["edad"];
    $Email = $_REQUEST["mail"];
    echo gettype(filter_var($Email, FILTER_VALIDATE_EMAIL));
    $error = "";
    echo $error;
    if(filter_var($Email, FILTER_VALIDATE_EMAIL) !== true){
        $error = $error . "<li>El email es incorrecto</li>";
    }else if(($Edad > 3 && $Edad < 130) !== true){
        $error = $error . "<li>La edad no es correcta, tiene que estar entre 3 y 130 y ser un numero</li>";
    }else if(filter_var($Nombre, FILTER_VALIDATE_INT) !== true){
        $error = $error . "<li>El nombre no puede ser un numero</li>";
    }
    ?>
    <style>
        .error{
            color: red;
        }
    </style>
    <ul class="error">
        <?php echo $error; ?>
    </ul>
    <form action="#" method="POST">
        <p>Nombre<input type="text" name="nombre" id="nombre"></p>
        <p>Edad <input type="number" name="edad" id="edad"></p>
        <p>E-mail <input type="email" name="mail" id="mail"></p>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>