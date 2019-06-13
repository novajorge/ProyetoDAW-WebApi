package servlets;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbdd.ConexionMariaDB;
import daos.DatabaseDAO;
import daos.TypesDatabaseDAO;
import daos.UsuarioDAO;
import domains.Database;
import domains.Usuario;

/**
 * Servlet implementation class CuentaServlets
 */
@WebServlet("/CuentaServlets")
public class CuentaServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentaServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				try {
					ConexionMariaDB conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
					
					switch (request.getParameter("methodDAO")) {
					case "insert":
						try {
							Usuario usuario = new Usuario();
							MessageDigest md = MessageDigest.getInstance("MD5"); 
							byte[] messageDigest = md.digest(request.getParameter("pass").getBytes());
							BigInteger no = new BigInteger(1, messageDigest);
					        String hashtext = no.toString(16); 
				            while (hashtext.length() < 32) { 
				                hashtext = "0" + hashtext; 
				            }
							usuario.setNombre(request.getParameter("name"));
							usuario.setContrasena(hashtext);
							usuario.setCorreo(request.getParameter("email"));
							usuario.setEmpresa(request.getParameter("empresa"));
							UsuarioDAO usuarioDAO = new UsuarioDAO(conexion.getObjConexion());
							System.out.println(usuario);
							usuarioDAO.insertarusuario(usuario);
							HttpSession sesion = request.getSession();
							sesion.setAttribute("usuario",usuario.getNombre());
							sesion.setAttribute("email", usuario.getCorreo());
							sesion.setAttribute("databaseList", new DatabaseDAO(conexion.getObjConexion()).recuperarDatabasesUser(usuario.getCorreo()));
							response.sendRedirect(request.getContextPath() + "/admin");
							
							}catch (Exception e) {
								System.out.println("error:"+e);
							}
						break;
					case "update":
						
						break;
					case "delete":
						
						break;

					}
				} catch (Exception e) {
					// TODO: handle exception
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
