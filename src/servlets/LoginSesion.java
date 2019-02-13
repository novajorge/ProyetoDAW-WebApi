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
import util.Validator;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		Usuario loged = new Usuario();
		
		//comprobamos si es correo o nombre
		if(Validator.esEmail(request.getParameter("user"))) {
			loged.setCorreo(request.getParameter("user"));
		}else {
			loged.setNombre(request.getParameter("user"));
		}
		loged.setContraseña(request.getParameter("passwd"));
		
		ConexionMariaDB conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
		UsuarioDAO userBD = new UsuarioDAO(conexion.getObjConexion());
		Usuario user = userBD.recuperarUsuario(loged);
		
		if(user != null) {
			if(Validator.contraseñaMD5Correcta(loged.getContraseña(), user.getContraseña())){
				System.out.println("Login correcto");
				response.sendRedirect(request.getContextPath() + "/admin");
			}else {
				System.out.println("contraseña incorrecta");
			}
		}
		 
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
