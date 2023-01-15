<%-- 
    Document   : edit
    Created on : 14/01/2023, 03:00:06 PM
    Author     : NEHO-KSB
--%>

<%@page import="model.Usuario"%>
<%@page import="DAO.UsuarioDAO"%>
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
            <%
              UsuarioDAO usrDao = new UsuarioDAO();
              int id = Integer.parseInt((String)request.getAttribute("id_usr"));
              Usuario usr = (Usuario)usrDao.list(id);
            %>
            <h3>Editar Usuario</h3>
            <form action="Controller">
                Documento:<br>
                <input class="form-control" type="text" name="txtDoc" value="<%= usr.getDocumento()%>"><br>
                Nombres: <br>
                <input class="form-control" type="text" name="txtNom" value="<%= usr.getNombres()%>"><br>
                Apellidos: <br>
                <input class="form-control" type="text" name="txtApe" value="<%= usr.getApellidos()%>"><br>
                Telefono: <br>
                <input class="form-control" type="text" name="txtTelf" value="<%= usr.getTelefono()%>"><br>
                Correo: <br>
                <input class="form-control" type="text" name="txtMail" value="<%= usr.getCorreo()%>"><br>
                Estado: <br>
                <input class="form-control" type="text" name="txtEdo" value="<%= usr.getEstado()%>"><br>
                Usuario: <br>
                <input class="form-control" type="text" name="txtUsr" value="<%= usr.getUsuario()%>"><br>
                Contraseña: <br>
                <input class="form-control" type="password" name="txtPass" value="<%= usr.getPassword()%>"><br>
                Rol:
                <select class="form-select" name="txtRol" required>
                    <option value="1">Administrador</option>
                    <option value="2">Soporte</option>
                    <option value="3">Asistente</option>
                </select><br>
                Cargo:
                <select class="form-select" name="txtCargo" required>
                    <option value="1">Auditor</option>
                    <option value="2">Administrador</option>
                    <option value="3">Desarrollador</option>
                    <option value="4">Gerente</option>
                </select><br>                
                
                <input type="hidden" name="txtid" value="<%= usr.getId_usuario()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> &nbsp
                <a href="index.jsp">Regresar</a>
            </form>
        </div>

        <!-- Optional JavaScript; choose one of the two! -->
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
