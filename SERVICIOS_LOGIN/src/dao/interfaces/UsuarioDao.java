package dao.interfaces;

import beans.UsuarioBean;


public interface UsuarioDao {
	public UsuarioBean validarIngreso(String usuario,String contraseña);
}
