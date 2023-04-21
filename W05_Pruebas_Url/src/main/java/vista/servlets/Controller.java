package vista.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prueba/*")
@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String context = req.getContextPath();
		String path = req.getPathInfo();
		
		System.out.println("req.getContextPath(): " + context);
		System.out.println("req.getPathInfo(): " + path);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");
				
		if(isNotEmpty(usuario) && isNotEmpty(password)) {
				req.getSession().setAttribute("usuario", usuario);
				resp.sendRedirect("index");
				req.getSession().setAttribute("error", "inexistente");
				req.getRequestDispatcher("WEB-INF/vistas/login_error.jsp").forward(req, resp);
		} else {
			req.getSession().setAttribute("error", "oblig");
			req.getRequestDispatcher("WEB-INF/vistas/login_error.jsp").forward(req, resp);
		}
	}
	
	private boolean isNotEmpty(String param) {
		return param != null && param.trim().length() > 0;
	}
}