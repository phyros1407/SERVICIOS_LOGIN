package daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.UsuarioDao;
import dao.mysql.MySql_UsuarioDao;

public class MySqlDAOFactory extends DAOFactory {
	
	public static Connection obtenerConexion(){
		Connection conexion=null;
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://node52782-dis-nanosport.whelastic.net/bd_gym_3.6_data";
			conexion = DriverManager.getConnection(url,"root","GADchg15583");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		*/
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bd_gym_4.6.6_data";
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
