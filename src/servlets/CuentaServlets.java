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
					
					
					switch (request.getParameter("methodDAO")) {
					case "insert":
						try {
							ConexionMariaDB conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
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
							conexion.getObjConexion().close();
							response.sendRedirect(request.getContextPath() + "/admin");
							
							}catch (Exception e) {
								System.out.println("error:"+e);
							}
						break;
					case "update":
						try {
							System.out.println("update");
							ConexionMariaDB conexion = new ConexionMariaDB(getServletContext().getRealPath("/WEB-INF/classes/"));
							UsuarioDAO usuarioDAO = new UsuarioDAO(conexion.getObjConexion());
							conexion.getObjConexion().close();
							Usuario oldPass = new Usuario();
							oldPass.setCorreo((String) request.getSession().getAttribute("email"));
							oldPass.setNombre((String) request.getSession().getAttribute("usuario"));
							Usuario old = usuarioDAO.recuperarUsuario(oldPass);
							 System.out.println(old);
							// 
							if(request.getParameter("oldPass") != null)  {
								MessageDigest md = MessageDigest.getInstance("MD5"); 
								byte[] messageDigest = md.digest(request.getParameter("oldPass").getBytes());
								BigInteger no = new BigInteger(1, messageDigest);
								String hashtext = no.toString(16); 
					            while (hashtext.length() < 32) { hashtext = "0" + hashtext; }
					            if(old.getContrasena().equals(hashtext)) {
					            	System.out.println("iguales antigua");
									if(request.getParameter("newpass1").equals(request.getParameter("newpass2"))) {
										System.out.println("iguales");
										if(request.getParameter("name")!= null) {
											old.setNombre(request.getParameter("name"));	
										}
										if(request.getParameter("newpass1")!= null) {
											messageDigest = md.digest(request.getParameter("newpass1").getBytes());
											no = new BigInteger(1, messageDigest);
									        String hashtext1 = no.toString(16); 
								            while (hashtext.length() < 32) { 
								                hashtext = "0" + hashtext; 
								            }
											old.setContrasena(hashtext1);
										}
										if(request.getParameter("email")!= null){ 
											old.setCorreo(request.getParameter("email"));
										}
										if(request.getParameter("empresa")!= null) {
											old.setEmpresa(request.getParameter("empresa"));
										}
										usuarioDAO.updateCuenta(old);
										request.getSession().setAttribute("CuentaUpdate", true);
										response.sendRedirect(request.getContextPath() + "/admin");
									}else {
										request.getSession().setAttribute("PasswordBothIncorrects", true);
										response.sendRedirect(request.getContextPath() + "/admin");
									}
								}else {
									System.out.println("no iguales antigua");
									request.getSession().setAttribute("PasswordIncorrect", true);
									response.sendRedirect(request.getContextPath() + "/admin");
								}
							}else {
								if(request.getParameter("name")!= null) {
									old.setNombre(request.getParameter("name"));	
								}
								if(request.getParameter("email")!= null){ 
									old.setCorreo(request.getParameter("email"));
								}
								if(request.getParameter("empresa")!= null) {
									old.setEmpresa(request.getParameter("empresa"));
								}
								usuarioDAO.updateCuenta(old);
								request.getSession().setAttribute("CuentaUpdate", true);
								response.sendRedirect(request.getContextPath() + "/admin");
							}

									
						} catch (Exception e) {
							System.out.println(e);
							
							break;
						}
							
						
					case "delete":
						
						break;

					}
				} catch (Exception e) {
					// TODO: handle exception
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
