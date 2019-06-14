package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bbdd.ConexionGeneric;
import bbdd.ConexionMariaDB;
import daos.DatabaseDAO;
import daos.TablesDAO;
import domains.Database;

/**
 * Servlet implementation class GetTablesOfSchema
 */
@WebServlet("/GetTablesOfSchema")
public class GetTablesOfSchema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTablesOfSchema() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Gson gson = new Gson();
			Database database = gson.fromJson(request.getParameter("database"), Database.class);
			
			ConexionGeneric con = new ConexionGeneric(database);
			
			TablesDAO tables = new TablesDAO(con.getObjConexion());
			
			String tablestoString = new Gson().toJson(tables.recuperarTableNames());
			System.out.println(tablestoString);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(tablestoString);

			con.getObjConexion().close();
			
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
