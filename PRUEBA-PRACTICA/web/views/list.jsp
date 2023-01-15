<%-- 
    Document   : list
    Created on : 14/01/2023, 02:59:50 PM
    Author     : NEHO-KSB
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
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
    <body>
        <div>
            <h1>Usuarios</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Documento</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Usuario</th>
                        <th>Telefono</th>
                        <th>Correo</th>
                        <th>Estado</th>
                        <!--th>Administrar</th-->
                    </tr>
                </thead>
                <%
                    UsuarioDAO dao = new UsuarioDAO();
                    List<Usuario> list = dao.list();
                    Iterator<Usuario> iter = list.iterator();
                    Usuario user = null;
                    while(iter.hasNext()){
                        user = iter.next();
                %>
                <tbody>
                    <tr>
                        <td><%= user.getDocumento()%></td>
                        <td><%= user.getNombres()%></td>
                        <td><%= user.getApellidos()%></td>
                        <td><%= user.getUsuario()%></td>
                        <td><%= user.getTelefono()%></td>
                        <td><%= user.getCorreo()%></td>
                        <td><%= user.getEstado()%></td>
                        <!--td></td-->
                    </tr>
                    <%}%>
                </tbody>
            </table>

            
        </div>



        <!-- Optional JavaScript; choose one of the two! -->
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
