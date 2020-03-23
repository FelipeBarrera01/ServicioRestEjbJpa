/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import domain.Usuario;
import java.util.List;

public interface UsuarioDao {
     public List<Usuario> findAllUsuario();
    public Usuario findUsuarioById(Usuario usuario);
    public Usuario findUsuarioByUsuario(Usuario usuario);
    public void insertUsuario(Usuario usuario);
    public void updateUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
}
