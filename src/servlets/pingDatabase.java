package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bbdd.ConexionGeneric;
import bbdd.ConexionMariaDB;
import daos.DatabaseDAO;
import daos.TypesDatabaseDAO;
import domains.Database;

/**
 * Servlet implementation class pingDatabase
 */
@WebServlet("/pingDatabase")
public class pingDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pingDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ConexionMariaDB conPrin = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
			DatabaseDAO dao = new DatabaseDAO(conPrin.getObjConexion());
			Database da = new Database();
			Database temp = new Database();
			temp.setHost(request.getParameter("host"));
			temp.setPuerto(Integer.valueOf(request.getParameter("port")));
			temp.setSchema(request.getParameter("schema"));
			temp.setUsuario(request.getParameter("user"));
			temp.setPassword(request.getParameter("pass"));
			temp.setType(new TypesDatabaseDAO(conPrin.getObjConexion()).recuperarType(Integer.valueOf(request.getParameter("type"))));
			System.out.println(temp);
			
			ConexionGeneric con = new ConexionGeneric(temp);

			conPrin.getObjConexion().close();
			
			
			String databaseJsonString = new Gson().toJson(temp);
			System.out.println(databaseJsonString);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(databaseJsonString);
			con.getObjConexion().close();
			
		} catch (Exception e) {
			response.setStatus(400);
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
