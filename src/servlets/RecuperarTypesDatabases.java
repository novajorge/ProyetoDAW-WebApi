package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bbdd.ConexionMariaDB;
import daos.DatabaseDAO;
import daos.TypesDatabaseDAO;
import domains.Database;
import exceptions.DAOException;

/**
 * Servlet implementation class RecuperarTypesDatabases
 */
@WebServlet("/RecuperarTypesDatabases")
public class RecuperarTypesDatabases extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarTypesDatabases() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			ConexionMariaDB conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
			TypesDatabaseDAO typesDatabaseDAO = new TypesDatabaseDAO(conexion.getObjConexion());
			String typesJsonString = new Gson().toJson(typesDatabaseDAO.recuperarTodosTypes());
			System.out.println(typesJsonString);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			try {
				conexion.getObjConexion().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write(typesJsonString);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
