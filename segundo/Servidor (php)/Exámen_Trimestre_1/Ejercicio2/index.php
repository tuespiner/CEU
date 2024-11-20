<!DOCTYPE html>
<html lang="es_ES">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 2</title>
</head>
<body>
    <?php
    //abro la sesón
    session_start();
    //miro si se ha definido la variable agenda en la sesion
    if(!isset($_SESSION["agenda"])){
        $_SESSION["agenda"] = [];
    }
    //pongo la variable global request en una local para tener los datos mas accesibles
    $request = $_REQUEST;
    $advertencia = "";
    //miro si el nombre se ha introducido
    if(emtpy($request["nombre"])){
        $advertencia = '<span style="color:red;">No se ha introducido el nombre</span>';
    }
    
    ?>
    <div>
        <?php
        //si no pone el nombre
        echo $advertencia;


        ?>
    </div>
    <form action="#" method="POST">
        <p>Introduzca los datos al listín</p>
        <div>
            <p>Nombre</p>
            <input type="text" name="nombre">
        </div>
        <div>
            <p>Teléfono</p>
            <input type="text" name="telefono">
        </div>
        <input type="submit" value="Aplicar cambios">
    </form>
</body>
</html>