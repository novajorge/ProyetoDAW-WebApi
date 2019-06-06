package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbdd.ConexionMariaDB;
import daos.DatabaseDAO;
import domains.Database;

/**
 * Servlet implementation class UpdateDatabase
 */
@WebServlet("/UpdateDatabase")
public class UpdateDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Database database = new Database();
		Database olDatabase = new Database();
		
		database.setCorreo(request.getParameter("email"));
		database.setName(request.getParameter("name"));
		database.setDescription(request.getParameter("desc"));
		database.setHost(request.getParameter("host"));
		database.setPuerto(Integer.valueOf(request.getParameter("port")));
		database.setActiva(Boolean.parseBoolean(request.getParameter("active")));
		database.setUsuario(request.getParameter("user"));
		database.setPassword(request.getParameter("pass"));
		database.setType(Integer.valueOf(request.getParameter("type")));
		
		olDatabase.setCorreo(request.getParameter("oldCorreo"));
		olDatabase.setHost(request.getParameter("oldHost"));
		olDatabase.setName(request.getParameter("oldName"));
		
		
		ConexionMariaDB conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
		DatabaseDAO databaseDAO = new DatabaseDAO(conexion.getObjConexion());
		databaseDAO.updateDatabase(database, olDatabase);
		HttpSession sesion = request.getSession();
		sesion.setAttribute("DatabaseUpdate", true);
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
