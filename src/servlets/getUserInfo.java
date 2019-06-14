package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bbdd.ConexionMariaDB;
import daos.UsuarioDAO;
import domains.Usuario;

/**
 * Servlet implementation class getUserInfo
 */
@WebServlet("/getUserInfo")
public class getUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			System.out.println("asddasasdasddas");
			ConexionMariaDB conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
			UsuarioDAO userBD = new UsuarioDAO(conexion.getObjConexion());
			Usuario loged = new Usuario();
			loged.setCorreo( (String) request.getSession().getAttribute("email"));
			loged.setNombre( (String) request.getSession().getAttribute("usuario"));
			Usuario user = userBD.recuperarUsuario(loged);
			String usuarioJsonString = new Gson().toJson(user);
			System.out.println(usuarioJsonString);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(usuarioJsonString);
			conexion.getObjConexion().close();
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
