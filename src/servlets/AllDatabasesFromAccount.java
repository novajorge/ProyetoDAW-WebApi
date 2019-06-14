package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bbdd.ConexionMariaDB;
import daos.DatabaseDAO;

/**
 * Servlet implementation class AllDatabasesFromAccount
 */
@WebServlet("/AllDatabasesFromAccount")
public class AllDatabasesFromAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllDatabasesFromAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ConexionMariaDB conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));	
			DatabaseDAO databaseDAO = new DatabaseDAO(conexion.getObjConexion());
			HttpSession session = request.getSession();

			String tablestoString = new Gson().toJson(databaseDAO.recuperarDatabasesUser((String) session.getAttribute("email")));
			System.out.println(tablestoString);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(tablestoString);
			
			conexion.getObjConexion().close();
		
		} catch (Exception e) {
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
