package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domains.Usuario;
import util.Validator;

/**
 * Servlet implementation class RecuperarContraseña
 */
@WebServlet("/RecuperarContrasena")
public class RecuperarContrasena extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarContrasena() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = new Usuario();
		boolean valid = true;
		String errorString = null;
		
		//comprobamos si es correo o nombre
		if(Validator.esEmail(request.getParameter("user"))) {
			user.setCorreo(request.getParameter("user"));
		}else {
			user.setNombre(request.getParameter("user"));
		}
		
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        
        System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);

        // Verify CAPTCHA.
        valid = Validator.verify(gRecaptchaResponse);
        if (!valid) {
            errorString = "Captcha invalid!";
        }
        if (!valid) {
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("index.jsp");
           
            dispatcher.forward(request, response);
            return;
        } else {
            // Redirect to /userInfo
            response.sendRedirect(request.getContextPath()+"/userInfo");
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
