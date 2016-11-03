package servlets;

import dao.interfaces.UsuarioDao;
import daofactory.DAOFactory;
import util.ResponseObject;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.UsuarioBean;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/servicios")
	// 50MB
public class servicios extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servicios() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("pass");
		
		ResponseObject responseobj=null;
		
		DAOFactory dao = DAOFactory.getDaoFactory(DAOFactory.MYSQL);
		
		UsuarioDao usudao = dao.getUsuarioDao();
		
		UsuarioBean usuarioLog = usudao.validarIngreso(usuario, password);
		
		if(usuarioLog!=null){

			responseobj=new ResponseObject();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			responseobj.setSuccess(true);
			responseobj.setObject(usuarioLog);
			
		}else{
			responseobj=new ResponseObject();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			responseobj.setSuccess(true);
			responseobj.setObject(null);
		}
		response.getWriter().write(new Gson().toJson(responseobj));
		System.out.println("json" + new Gson().toJson(responseobj));
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
