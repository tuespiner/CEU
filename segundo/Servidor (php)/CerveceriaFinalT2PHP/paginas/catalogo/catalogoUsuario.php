<?php
    $posicion = 0;
    while ($fila = $_SESSION['productos']->fetch_assoc()){
        $posicion++;
        echo '<div class="producto">';
        echo '<div class="imagen"><img src="'.$fila['foto'].'"></div>';
        echo '<div><h2>'.$fila['formato'].'</h2>';
        echo '<ul><li><p><span>Marca:</span> '.$fila['marca'].'</p></li>';
        echo '<li><p><span>Tipo:</span> '.$fila['tipo'].'</p></li>';
        echo '<li><p><span>Tamaño:</span> '.$fila['tamano'].'</p></li>';
        echo '<li><p><span>Precio:</span> '.$fila['precio'].'€</p></li></ul>';
        if(isset($_SESSION['posicionVerMas']) && $_SESSION['posicionVerMas'] == $posicion){
            for()
            echo '<ul><li><p><span>Denominacion: </span>'.$fila['denominacion'].'</p></li>';
            echo '<li><p><span>Fecha Consumo: </span>'.$fila['fecha_consumo'].'</p></li>';
            echo '<li><p><span>Alergias: </span>'.$fila['alergias'].'</p></li></ul>';
        }
        echo '<div><a href="">AÑADIR AL CARRITO</a>';
        echo '<a href="catalogo.php?posicionVerMas='.$posicion.'">VER MÁS</a></div></div></div>';
    }
?>