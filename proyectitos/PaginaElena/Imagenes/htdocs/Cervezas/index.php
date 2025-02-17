<link rel="stylesheet" href="styles.css"/>
<style>label{font-weight:bold;}</style>
<?php
    $error = [];
    
    $tipoCerveza = "<li><label>Tipo de cerveza:</label> ".$_REQUEST['tipoCerveza']."</li>";
    $denominacion = "<li><label>Denominacion:</label>".$_REQUEST['Denominacion']."</li>";
    $cantNeta = "<li><label>Cantidad neta:</label> ".$_REQUEST['cantNeta']."</li>";
    $observaciones = "<li><label>Observaciones:</label> ".$_REQUEST['Observaciones']."</li>";

    if(empty($_REQUEST['embase'])){
        $error[count($error)+1] = "<li><label>Es obligatorio poner el envase</label></li>";
    }else{
        $envase =  "<li><label>Embase:</label> ".$_REQUEST['embase']."</li>";
    }
    if(empty($_REQUEST['marca'])){
        $error[count($error)+1] = "<li><label>Se requiere marca</label></li>";
    }else{
        $marca = "<li><label>Marca:</label> ".$_REQUEST['marca']."</li>";
    }
    if(empty($_REQUEST['advertenciaAbuso'])){
        $error[count($error)+1] = "<li><label>Es obligatoria la advertencia del consumo del alcohol</label></li>";
    }else{
        $advertenciaAbuso = "<li><label>Advertencia de abuso:</label> ".$_REQUEST['advertenciaAbuso']."</li>";
    }
    if(empty($_REQUEST['consumoPreferente'])){
        $error[count($error)+1] = "<li><label>No ha introducido fecha</label></li>";
    }else{
        $consumoPreferente = "<li><label>Consumo preferente:</label> ".$_REQUEST['consumoPreferente']."</li>";
    }
    if(!isset($_REQUEST['alergenos'])){
        $error[count($error)+1] = "<li><label>Es obligatorio incluir alergenos</label></li>";
    }else{
        $alergenos = $_REQUEST['alergenos'];
    }
    if(empty($error)){
        print "<h1>Estos son los datos introducidos:</h1> <ul>";
        print $tipoCerveza;
        print $denominacion;
        print $embase;
        print $cantNeta;
        print $marca;
        print $advertenciaAbuso;
        print $consumoPreferente;
        print $observaciones;
        print "<li><label>Alergenos:</label><ul>";
        foreach($alergenos as $alergeno){
            print "<li>".$alergeno."</li>";
        }
        print "</ul></li></ul>";
    }else{
        print "<h1>Se requieren estos campos:</h1> <ul>";
        foreach ($error as $cad){
            print $cad;
        }
        print "</ul>";
    }
    print "<p>[<a href='index.html'>Volver</a>]</p>";
?>