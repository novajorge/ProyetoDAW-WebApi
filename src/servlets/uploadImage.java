package servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbdd.ConexionMariaDB;
import daos.imagenProfileDAO;

/**
 * Servlet implementation class uploadImage
 */
@WebServlet("/uploadImage")
public class uploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadImage() {
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
			imagenProfileDAO img = new imagenProfileDAO(conexion.getObjConexion());
			File fileImg = new File(request.getParameter("img"));
			switch (request.getParameter("methodDAO")) {
			case "insert":
				img.insertImage(fileImg, "profile", (String) request.getSession().getAttribute("email"));
				break;
			case "update":
				img.updateImage(fileImg, "profile", (String) request.getSession().getAttribute("email"));
				break;
			case "delete":
				
				break;
			case "get":
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
