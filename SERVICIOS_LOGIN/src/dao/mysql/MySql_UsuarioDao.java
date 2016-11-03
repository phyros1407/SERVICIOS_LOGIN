package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;


import beans.UsuarioBean;
import dao.interfaces.UsuarioDao;
import daofactory.MySqlDAOFactory;

public class MySql_UsuarioDao extends MySqlDAOFactory implements UsuarioDao {

	public UsuarioBean validarIngreso(String usuario, String contraseña) {
		// TODO Auto-generated method stub
		UsuarioBean usu=null;
		try {
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt= con.createStatement();
			String  consulta ="select usu.id as idUsu,usu.CAR_ID as ROL_ID ,usu.*,pe.NOM,pe.APE_PAT,co.COR  from usuario usu, persona pe, contacto co "
					+ " where usu='"+usuario+"'  and pe.id=usu.PER_ID and usu.PER_ID=co.PER_ID";
			ResultSet rs = stmt.executeQuery(consulta);
			int idUsu;
			int intento;
			String insertIntento="";
			String validacion="";
			if(rs.next()){
				System.out.println("exite usuario en bd");
				idUsu=rs.getInt("idUsu");
				intento=rs.getInt("INTENTO");
				
				usu= new UsuarioBean();
				usu.setNombreUsu(rs.getString("usu"));
				usu.setEstado("");
				usu.setCorreo(rs.getString("COR"));
				if(rs.getString("PAS").equalsIgnoreCase(contraseña)){
						insertIntento="UPDATE usuario SET INTENTO='0' , EST_ACT='A' WHERE ID='"+idUsu+"'";
						
						
						usu.setPersonaId(rs.getInt("PER_ID"));
						usu.setUsuId(rs.getInt("idUsu"));
						usu.setRolId(rs.getInt("ROL_ID"));
						usu.setEstado(rs.getString("EST_ACT"));
						usu.setNombreUsu(rs.getString("usu"));
						usu.setIntento("validado");
						usu.setNombre(rs.getString("NOM"));
						usu.setApellidoPaterno(rs.getString("APE_PAT"));
						
				}else{
					System.out.println("no es contrasena");
					
					if(intento==1){
						 insertIntento="UPDATE usuario SET INTENTO='2' WHERE ID='"+idUsu+"'";
						 validacion="2";
						 usu.setIntento(validacion);
					}else if(intento==2){
						 insertIntento="UPDATE usuario SET INTENTO='3' WHERE ID='"+idUsu+"'";
						 validacion="3";
						 usu.setIntento(validacion);
					}else if(intento==3){
						 insertIntento="UPDATE usuario SET INTENTO='0' WHERE ID='"+idUsu+"'";
						validacion="resetearPass";
						usu.setIntento(validacion);
					}else{
						 insertIntento="UPDATE usuario SET INTENTO='1' WHERE ID='"+idUsu+"'";
						 validacion="1";
						 usu.setIntento(validacion);
					}
					
				}
				stmt.executeUpdate(insertIntento);
				
			}else{
				System.out.println("no se encontro usuario en la bd");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return usu;
	}
}