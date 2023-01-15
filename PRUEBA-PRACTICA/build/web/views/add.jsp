<%-- 
    Document   : add
    Created on : 14/01/2023, 03:00:01 PM
    Author     : NEHO-KSB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Usuarios</title>
    </head>
    <body class="container">
        <div class="col-lg-4">
            <h3>Crear Usuario</h3>
            <form action="Controller">
                <input class="form-control" placeholder="Documento" type="number" name="txtDni" required><br>
                <input class="form-control" placeholder="Nombres" type="text" name="txtNom" required><br>
                <input class="form-control" placeholder="Apellidos" type="text" name="txtApe"><br>
                <input class="form-control" placeholder="Telefono" type="text" name="txtTelf"><br>
                <input class="form-control" placeholder="Correo" type="text" name="txtMail"><br>
                <input class="form-control" placeholder="Estado" type="text" name="txtEdo"><br>
                <input class="form-control" placeholder="Usuario" type="text" name="txtUsr"><br>
                <input class="form-control" placeholder="Contraseña" type="password" name="txtPass"><br>
                <select class="form-select" name="txtRol" required>
                    <option selected>Seleccione el Rol</option>
                    <option value="1">Administrador</option>
                    <option value="2">Soporte</option>
                    <option value="3">Asistente</option>
                </select><br>
                <select class="form-select" name="txtCargo" required>
                    <option selected>Seleccione el Cargo</option>
                    <option value="1">Auditor</option>
                    <option value="2">Administrador</option>
                    <option value="3">Desarrollador</option>
                    <option value="4">Gerente</option>
                </select><br>                
                
                <input class="btn btn-primary" type="submit" name="accion" value="Agregar"> &nbsp
                <a href="index.jsp">Regresar</a>
            </form>
        </div>

        <!-- Optional JavaScript; choose one of the two! -->
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
