package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbdd.ConexionMariaDB;
import daos.UsuarioDAO;
import domains.Usuario;

/**
 * Servlet implementation class LoginSesion
 */
@WebServlet("/LoginSesion")
public class LoginSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		Usuario loged = new Usuario();
		loged.setNombre(request.getParameter("user"));//si fuera correo deberiamos diferenciarlo aqui
		loged.setContraseña(request.getParameter("passwd")); //md5 y esas cosas aqui

		ConexionMariaDB conexion = new ConexionMariaDB();
		UsuarioDAO userBD = new UsuarioDAO(conexion.getObjConexion());
		Usuario user = userBD.recuperarUsuario(loged);
		System.out.println(user.toString());
		
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
