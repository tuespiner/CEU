<div class="inicio" id="inicio">
    <h1>INICIO SESIÓN</h1>
    <form action="index.php" method="GET">
        <div class="campoInput">
            <label for="correo">Correo</label>
            <input type="text" name="correo" id="correo">
            <?php
            if(isset($_REQUEST["correo"]) && $_REQUEST["correo"] == ""){
                echo "<p>El correo no puede estar vacio</p>";
            };
            ?>
        </div>
        <div class="campoInput">
            <label for="contrasena">Contraseña</label>
            <input type="password" name="contrasena" id="contrasena">
            <?php
            if(isset($_REQUEST["contrasena"]) && $_REQUEST["contrasena"] == ""){
                echo "<p>La contraseña no puede estar vacia</p>";
            };
            ?>
        </div>
        <?php
            if((isset($_REQUEST["correo"]) && isset($_REQUEST["contrasena"])) || 
            (isset($_COOKIE["correo"]) && isset($_COOKIE["contrasena"]))){
                if(!empty($_REQUEST["correo"]) && !empty($_REQUEST["contrasena"])){
                    $usuario = comprobarUsuario($_REQUEST["correo"], $_REQUEST["contrasena"]);
                    if($usuario != null){
                        $_SESSION["usuario"] = $usuario;
                        header("Location: ../catalogo/catalogo.php");
                    }
                }else if(!empty($_COOKIE["correo"]) && !empty($_COOKIE["contrasena"])){
                    $usuario = comprobarUsuario($_COOKIE["correo"], $_COOKIE["contrasena"]);
                    if($usuario != null){
                        $_SESSION["usuario"] = $usuario;
                        header("Location: ../catalogo/catalogo.php");
                    }
                }
            };
            ?>
        <input type="submit" value="Iniciar Sesión">
    </form>
    <a href="#" id="RegistrarseA">Registrarse</a>
</div>