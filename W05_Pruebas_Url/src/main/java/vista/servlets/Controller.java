package vista.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
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
		
		ServletContext app = this.getServletContext();
		
		app.setAttribute("context", context);
		app.setAttribute("css", context + "/css");
		app.setAttribute("js", context + "/js");
		app.setAttribute("images", context + "/images");
		
		String path = req.getPathInfo();
		
		// cómo se llama mi aplicación?
		System.out.println("req.getContextPath(): " + context);
		
		// dónde me has llamado? el asterisco del webservlet
		System.out.println("req.getPathInfo(): " + path);
		
		switch(path) {
		case "/forward/absoluto":
			// mostrará la url: localhost:8080/W05_Pruebas_Url/prueba/forward/absoluto
			// el relativo del css y todas las URL se van a la shit, así que
			// el css del href PONERLO EN ABSOLUTO!!
			req.getRequestDispatcher("/MI-WEB-INF/vistas/index.jsp").forward(req, resp);
			break;
		case "/forward/relativo":
			// url: localhost:8080/W05_Pruebas_Url/prueba/forward/relativo
			// está feo usarlo así, y se comportará mal en caso de q añadas más subcarpetas a partir de root (webapp)
			req.getRequestDispatcher("../../MI-WEB-INF/vistas/index.jsp").forward(req, resp);
			break;
		case "/redirect/absoluto":
			// url: localhost:8080/W05_Pruebas_Url/MI-WEB-INF/vistas/index.jsp
			resp.sendRedirect(context + "/MI-WEB-INF/vistas/index.jsp");
			break;
		case "/redirect/real":
			// url: localhost:8080/W05_Pruebas_Url/prueba/respuesta
			resp.sendRedirect(context + "/prueba/respuesta");
			break;
		case "/respuesta":
			// localhost:8080/W05_Pruebas_Url/prueba/respuesta
			req.getRequestDispatcher("/MI-WEB-INF/vistas/index.jsp").forward(req, resp);
			break;
		default:
			break;
		}
		
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