package daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.UsuarioDao;
import dao.mysql.MySql_UsuarioDao;

public class MySqlDAOFactory extends DAOFactory {
	
	public static Connection obtenerConexion(){
		
		Connection conexion=null;
		/*
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://mysql19777-productogym.j.facilcloud.com/bd_gym_4.6.7_data";
			conexion = DriverManager.getConnection(url,"root","LZQrgn46917");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		*/
		
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bd_xcomic";
			conexion = DriverManager.getConnection(url,"root","root");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
		return conexion;
	}

	
	public UsuarioDao getUsuarioDao() {
		// TODO Auto-generated method stub
		return new MySql_UsuarioDao();
	}

	
}
