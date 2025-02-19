<div class="register" id="register">
    <h1>REGISTRO</h1>
    <form action="">
        <div class="campoInput">
            <label for="correo2">Correo</label>
            <input type="text" name="correo" id="correo2">
            <?php
            
            $_SESSION['registerListo']=[
                "correo" => true,
                "edad" => true,
                "contrasena" => true
            ];
            if(isset($_REQUEST["correo"])){
                if($_REQUEST["correo"] == ""){
                    $_SESSION['registerListo']['correo'] = false;
                    echo "<p>El correo no puede estar vacio</p>";
                }
            }else{
                $_SESSION['registerListo']['correo'] = false;
            };
            ?>
        </div>
        <div class="campoInput">
            <label for="edad">Edad</label>
            <input type="text" name="edad" id="edad">
            <?php
            if(isset($_REQUEST["edad"])){
                if($_REQUEST["edad"] == ""){
                    $_SESSION['registerListo']['edad'] = false;
                    echo "<p>La edad no puede estar vacia</p>";
                }
            }else{
                $_SESSION['registerListo']['edad'] = false;
            };
            ?>
        </div>
        <div class="campoInput">
            <label for="contrasena2">Contraseña</label>
            <input type="password" name="contrasena" id="contrasena2">
            <?php
            if(isset($_REQUEST["contrasena"])){
                if($_REQUEST["contrasena"] == ""){
                    $_SESSION['registerListo']['contrasena'] = false;
                    echo "<p>La contraseña no puede estar vacia</p>";
                }
            }else{
                $_SESSION['registerListo']['contrasena'] = false;
            };
            ?>
        </div>
        <?php  
        if($_SESSION['registerListo']['contrasena'] == true && 
        $_SESSION['registerListo']['correo'] == true &&
        $_SESSION['registerListo']['edad'] == true){
         if(anadirUsuario($_REQUEST["contrasena"], $_REQUEST["correo"], $_REQUEST["edad"])){
             $usuario = comprobarUsuario($_REQUEST["correo"], $_REQUEST["contrasena"]);
             $_SESSION["usuario"] = $usuario;
             header("Location: ../catalogo/catalogo.php");
         }else{
             echo "<p>Algo no fue bien o hay otro usuario con los mismos datos</p>";
         }
        }
        ?>
        <input type="submit" value="Registrarse">
    </form>
    <a href="index.php?accion=cambiar" id="iniciarSesionA">Iniciar sesion</a>
</div>