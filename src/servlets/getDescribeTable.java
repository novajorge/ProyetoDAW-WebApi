package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import bbdd.ConexionGeneric;
import daos.TablesDAO;
import domains.Database;
import domains.Describe;

/**
 * Servlet implementation class getDescribeTable
 */
@WebServlet("/getDescribeTable")
public class getDescribeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDescribeTable() {
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
			
			/*System.out.println("Parametros recibidos");
			System.out.println(request.getParameter("table1"));
			System.out.println(database);
			System.out.println("--------------------");*/
			
			ConexionGeneric con = new ConexionGeneric(database);
			
			TablesDAO tables = new TablesDAO(con.getObjConexion());
			
			List<Describe> listDescribes = tables.recuperarDescribe("database."+(String) request.getParameter("table1"));

			Map<String, List<Describe>> mapita = new HashMap<String, List<Describe>>();
			mapita.put(request.getParameter("tableId"), listDescribes);
			
			String tablestoString = new Gson().toJson(mapita);
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
