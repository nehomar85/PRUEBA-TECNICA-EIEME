/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import config.Conexion;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author NEHO-KSB
 */
public class UsuarioDAO implements CRUD{
    Conexion cnx = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usr = new Usuario();

    @Override
    public List list() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("Id_usuario"));
                user.setDocumento(rs.getInt("Documento"));
                user.setNombres(rs.getString("Nombres"));
                user.setApellidos(rs.getString("Apellidos"));
                user.setUsuario(rs.getString("Usuario"));
                user.setTelefono(rs.getString("Telefono"));
                user.setCorreo(rs.getString("Correo"));
                user.setEstado(rs.getString("Estado"));
                list.add(user);    
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Usuario list(int id_usuario) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = " + id_usuario;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){                
                usr.setId_usuario(rs.getInt("Id_usuario"));
                usr.setDocumento(rs.getInt("Documento"));
                usr.setNombres(rs.getString("Nombres"));
                usr.setApellidos(rs.getString("Apellidos"));
                usr.setTelefono(rs.getString("Telefono"));
                usr.setCorreo(rs.getString("Correo"));
                usr.setEstado(rs.getString("Estado"));
                usr.setUsuario(rs.getString("Usuario"));
                usr.setPassword(rs.getString("Password"));
            }
        } catch (Exception e) {
        }
        return usr;
    }

    @Override
    public boolean add(Usuario user) {
        String sql = "INSERT INTO usuario (documento, nombres, apellidos, usuario, password, telefono, correo, estado, id_rol, id_cargo) VALUES "
                + "("+user.getDocumento()+",'"+user.getNombres()+"','"+user.getApellidos()+"','"+user.getUsuario()+"','"+user.getPassword()+"','"+user.getTelefono()+"','"+user.getCorreo()+"','"+user.getEstado()+"',"+user.getId_rol()+",'"+user.getId_cargo()+"')";
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Usuario user) {
        String sql = "UPDATE usuario SET documento="+usr.getDocumento()+", nombres='"+usr.getNombres()+"', apellidos='"+usr.getApellidos()+"', usuario='"+usr.getUsuario()+"', password='"+usr.getPassword()+"',"
                + "telefono='"+usr.getTelefono()+"', correo='"+usr.getCorreo()+"', estado='"+usr.getEstado()+"', id_rol='"+usr.getId_rol()+"', id_cargo='"+usr.getId_cargo()+"' WHERE id_usuario="+usr.getId_usuario();
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;        
    }

    @Override
    public boolean delete(int id_usuario) {
        String sql = "DELETE FROM usuario WHERE id_usuario = " + id_usuario;
        try {
            con = cnx.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
