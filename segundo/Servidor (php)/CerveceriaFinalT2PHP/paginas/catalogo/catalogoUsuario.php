<?php
    while ($fila = $_SESSION['productos']->fetch_assoc()){
        echo '<div class="producto">';
        echo '<div class="imagen"><img src="'.$fila['foto'].'"></div>';
        echo '<div><h2>'.$fila['formato'].'</h2>';
        echo '<ul><li><p>Marca: '.$fila['marca'].'</p></li>';
        echo '<li><p>Tipo: '.$fila['tipo'].'</p></li>';
        echo '<li><p>Tamaño: '.$fila['tamano'].'</p></li>';
        echo '<li><p>Precio: '.$fila['precio'].'€</p></li></ul>';
        echo '<div><a href="">AÑADIR AL CARRITO</a>';
        echo '<a href="">VER MÁS</a></div></div></div>';
    }
?>