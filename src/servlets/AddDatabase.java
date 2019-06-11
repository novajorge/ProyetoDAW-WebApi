package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbdd.ConexionMariaDB;
import daos.DatabaseDAO;
import daos.TypesDatabaseDAO;
import daos.UsuarioDAO;
import domains.Database;
import domains.Usuario;
import util.Validator;

/**
 * Servlet implementation class AddDatabase
 */
@WebServlet("/AddDatabase")
public class AddDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Database database = new Database();
		ConexionMariaDB conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
		
		database.setCorreo(request.getParameter("email"));
		database.setName(request.getParameter("name"));
		database.setDescription(request.getParameter("desc"));
		database.setHost(request.getParameter("host"));
		database.setPuerto(Integer.valueOf(request.getParameter("port")));
		database.setActiva(Boolean.parseBoolean(request.getParameter("active")));
		database.setUsuario(request.getParameter("user"));
		database.setPassword(request.getParameter("pass"));
		database.setType(new TypesDatabaseDAO(conexion.getObjConexion()).recuperarType(Integer.valueOf(request.getParameter("type"))));
		
		System.out.println(database.toString());
		
		
		DatabaseDAO databaseDAO = new DatabaseDAO(conexion.getObjConexion());
		databaseDAO.insertarDatabase(database);
		HttpSession sesion = request.getSession();
		sesion.setAttribute("DatabaseAdded", true);
		sesion.setAttribute("databaseList", new DatabaseDAO(conexion.getObjConexion()).recuperarDatabasesUser((String) sesion.getAttribute("email")));
		response.sendRedirect(request.getContextPath() + "/admin");
		
		}catch (Exception e) {
			System.out.println("error:"+e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
