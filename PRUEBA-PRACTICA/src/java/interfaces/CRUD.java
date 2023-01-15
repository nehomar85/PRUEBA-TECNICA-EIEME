/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Usuario;

/**
 *
 * @author NEHO-KSB
 */
public interface CRUD {
    public List list();
    public Usuario list(int id_usuario);
    public boolean add(Usuario user);
    public boolean edit(Usuario user);
    public boolean delete(int id_usuario);
}
