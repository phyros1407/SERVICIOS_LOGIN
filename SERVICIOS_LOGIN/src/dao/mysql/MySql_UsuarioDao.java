package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.PersonaBean;
import dao.interfaces.UsuarioDao;
import daofactory.MySqlDAOFactory;

public class MySql_UsuarioDao extends MySqlDAOFactory implements UsuarioDao {

	@Override
	public PersonaBean validarIngreso(String usuario, String contraseña) {
		// TODO Auto-generated method stub
		
		PersonaBean persona = new PersonaBean();
		
		try{
			
			Connection con=MySqlDAOFactory.obtenerConexion();
			
			Statement stmt=con.createStatement();
			
			String query = " SELECT * "
					+ " FROM t_persona p"
					+ " INNER JOIN t_usuario u ON p.ID = u.USU_ID "
					+ " WHERE u.USER = '"+usuario+"' AND u.PASS = '"+contraseña+"' ";
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){
				persona.setNom(rs.getString("NOM"));
				persona.setApe_pat(rs.getString("APE_PAT"));
				persona.setApe_mat(rs.getString("APE_MAT"));
				persona.setEmail(rs.getString("EMAIL"));
				persona.setPais(rs.getString("PAIS"));
				persona.setTelefono(rs.getString("TEL"));
			}
			
		}catch(Exception e){
			System.out.println("ERROR ---> "+e.getMessage());
		}
		
		return persona;
	}


}