<style>
    span{
        font-weight:bold;
    }
    .contenedor{
        width: 300px;
        display:grid;
        grid-template-columns:repeat(2,50%);
        gap:1rem;
        align-items:center;
    }
</style>
<?php
$nombre = $_REQUEST["nombre"];
$apellidos = $_REQUEST["apellidos"];
$sexo = $_REQUEST["sexo"];
$correoElectronico = $_REQUEST["mail"];
$numeroTel = $_REQUEST["tel"];
$experiencia = $_REQUEST["experiencia"];
$estudios = $_REQUEST["estudios"];
$jornada =  $_REQUEST["jornada"];
$idiomas = $_REQUEST["idiomas"];

function lista($var){
    $cad = "";
    foreach($var as $elemento){
        $cad = $cad . "<li>".$elemento."</li>";
    }
    return $cad;
}

print "<h1>Curriculum Vitae</h1>";
print "<div class='contenedor'><span>Nombre</span><p>".$nombre."</p></div>";
print "<div class='contenedor'><span>Apellidos</span><p>".$apellidos."</p></div>";
print "<div class='contenedor'><span>Sexo</span><p>".$sexo."</p></div>";
print "<div class='contenedor'><span>E-mail</span><p>".$correoElectronico."</p></div>";
print "<div class='contenedor'><span>Teléfono</span><p>".$numeroTel."</p></div>";
print "<div class='contenedor'><span>Experiencia Laboral</span><p>".$experiencia."</p></div>";
print "<div class='contenedor'><span>Estudios realizados</span><p>".$estudios."</p></div>";
print "<div class='contenedor'><span>Jornada laboral</span><p>".$jornada."</p></div>";
print "<div class='contenedor'><span>idiomas</span><ul>".lista($idiomas)."</p></div>";
?>