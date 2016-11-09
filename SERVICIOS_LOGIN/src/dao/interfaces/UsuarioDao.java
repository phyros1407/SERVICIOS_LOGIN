package dao.interfaces;

import beans.PersonaBean;

public interface UsuarioDao {
	
	public PersonaBean validarIngreso(String usuario,String contraseña);
	
}
