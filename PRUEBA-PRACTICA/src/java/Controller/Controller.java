/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author NEHO-KSB
 */
public class Controller extends HttpServlet {
    
    String listar = "views/list.jsp";
    String add = "views/add.jsp";
    String edit = "views/edit.jsp";
    String index = "index.jsp";

    Usuario usr = new Usuario();
    UsuarioDAO usrDao = new UsuarioDAO();
    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        
        if(action.equalsIgnoreCase("listar")){
            acceso = listar;
        }else if(action.equalsIgnoreCase("add")){
            acceso = add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            int documento = Integer.parseInt(request.getParameter("txtDni"));
            String nombre = request.getParameter("txtNom");
            String apellido = request.getParameter("txtApe");
            String telf = request.getParameter("txtTelf");
            String correo = request.getParameter("txtMail");
            String edo = request.getParameter("txtEdo");
            String usuario = request.getParameter("txtUsr");
            String pass = request.getParameter("txtPass");
            int rol = Integer.parseInt(request.getParameter("txtRol"));
            int cargo = Integer.parseInt(request.getParameter("txtCargo"));
            usr.setDocumento(documento);
            usr.setNombres(nombre);
            usr.setApellidos(apellido);
            usr.setTelefono(telf);
            usr.setCorreo(correo);
            usr.setEstado(edo);
            usr.setUsuario(usuario);
            usr.setPassword(pass);
            usr.setId_rol(rol);
            usr.setId_cargo(cargo);
            usrDao.add(usr);
            acceso = index;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("id_usr",request.getParameter("id"));
            acceso = edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id = Integer.parseInt(request.getParameter("txtid"));
            int documento = Integer.parseInt(request.getParameter("txtDoc"));
            String nombre = request.getParameter("txtNom");
            String apellido = request.getParameter("txtApe");
            String telf = request.getParameter("txtTelf");
            String correo = request.getParameter("txtMail");
            String edo = request.getParameter("txtEdo");
            String usuario = request.getParameter("txtUsr");
            String pass = request.getParameter("txtPass");
            int rol = Integer.parseInt(request.getParameter("txtRol"));
            int cargo = Integer.parseInt(request.getParameter("txtCargo"));            
            usr.setId_usuario(id);
            usr.setDocumento(documento);
            usr.setNombres(nombre);
            usr.setApellidos(apellido);
            usr.setTelefono(telf);
            usr.setCorreo(correo);
            usr.setEstado(edo);
            usr.setUsuario(usuario);
            usr.setPassword(pass);
            usr.setId_rol(rol);
            usr.setId_cargo(cargo);            
            usrDao.edit(usr);
            acceso = index;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            usr.setId_usuario(id);
            usrDao.delete(id);
            acceso = index;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
