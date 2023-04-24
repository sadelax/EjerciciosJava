package vista;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static vista.Util.IsNotEmpty;

@WebServlet("/home/*")
@SuppressWarnings("serial")
public class Controller extends HttpServlet {
	
	private String context;
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getPathInfo();
		
		if(req.getSession().getAttribute("usr_reg") != null) {
			// aquí atendemos a todo lo privado
			switch (path) {
			case "/menu_principal":
				req.getRequestDispatcher("/WEB-INF/vistas/menu_principal.jsp").forward(req, resp);
				break;
			case "/cerrar_sesion":
				req.getSession().invalidate();
				req.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(req, resp);
				break;
			default:
				break;
			}
		} else {
			// aquí atendemos a todo lo público
			switch (path) {
			case "/registro_usuario":
				break;	
			default:
				req.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(req, resp);
				break;
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		
		HttpSession sesion = req.getSession(true);
		
		switch (path) {
		case "/login":
			String user = req.getParameter("usuario"); // ojo: el name del input del html
			String pwd = req.getParameter("password");
			if(IsNotEmpty(user) && IsNotEmpty(pwd)) {
				// suponiendo q el login es correcto:
				sesion.setAttribute("usr_reg", "Pepe");
				resp.sendRedirect(context + "/home/menu_principal");
			}
			break;
			
		default:
			break;
		}
	}
	
	@Override
	public void init() throws ServletException {
		ServletContext app = getServletContext();
		context = app.getContextPath();
		
		app.setAttribute("context", app.getContextPath());
		app.setAttribute("home", app.getContextPath() + "/home");
		app.setAttribute("js", app.getContextPath() + "/js");
		app.setAttribute("css", app.getContextPath() + "/css");
		app.setAttribute("images", app.getContextPath() + "/images");
	}
}
