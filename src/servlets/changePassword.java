package servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbdd.ConexionMariaDB;
import daos.DatabaseDAO;
import daos.UsuarioDAO;
import domains.Usuario;
import exceptions.DAOException;
import recursos.DbQuery;

/**
 * Servlet implementation class changePassword
 */
@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("codigo"));
		ConexionMariaDB conexion = null;
		try {

			conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			byte[] messageDigest = md.digest(request.getParameter("password").getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
	        String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            }
			Usuario user = new Usuario() ;
			user.setResetPass(request.getParameter("codigo"));
			user.setCorreo(request.getParameter("email"));
			user.setContrasena(hashtext);
			
			System.out.println(user.toString());
			
			UsuarioDAO usurDAO = new UsuarioDAO(conexion.getObjConexion());
			
			
			String codigo = usurDAO.recuperarCodigoResetPassword(user).getResetPass();
			if(codigo != null) {
				System.out.println(user.getResetPass());
				System.out.println(codigo);
				if(user.getResetPass() .equals(codigo.trim())) {
						
						usurDAO.updatePassword(user);
					 	HttpSession session = request.getSession();
					 	session.setAttribute("PasswordChange", true);
						response.sendRedirect(request.getContextPath() + "/index.jsp");
				}else {
					response.sendRedirect(request.getContextPath() + "/index.jsp");
				}
			}else {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
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
