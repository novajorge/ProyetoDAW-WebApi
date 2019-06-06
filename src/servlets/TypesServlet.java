package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bbdd.ConexionMariaDB;
import daos.DatabaseDAO;
import domains.Database;

/**
 * Servlet implementation class typesServlet
 */
@WebServlet("/TypesServlet")
public class TypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			Database database = new Database();
			String name = request.getParameter("name").trim();
			String host = request.getParameter("host").trim();
			String email = (String) request.getSession().getAttribute("email");
			database.setCorreo(email);
			database.setHost(host);
			database.setName(name);
			
			ConexionMariaDB conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
			DatabaseDAO databaseDAO = new DatabaseDAO(conexion.getObjConexion());
			String databaseJsonString = new Gson().toJson(databaseDAO.recuperarDatabase(database));
			System.out.println(databaseJsonString);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(databaseJsonString);
			
		}catch (Exception e) {
			System.out.println(e);
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
