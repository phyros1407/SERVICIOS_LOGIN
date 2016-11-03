package daofactory;

import dao.interfaces.UsuarioDao;

public abstract class DAOFactory {
	
	public static final int MYSQL=1;
	public static final int SQLSERVER=2;
	public static final int ORACLE=3;
	
	

	public abstract UsuarioDao getUsuarioDao();
	
	
	public static DAOFactory getDaoFactory(int factory){
		
		switch (factory) {
		case MYSQL:
			return new MySqlDAOFactory();
		

		default:
			return null;
		}
		
	}

	
}
