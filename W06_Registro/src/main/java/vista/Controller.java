package vista;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home/*")
@SuppressWarnings("serial")
public class Controller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(getServletContext().getAttribute("config") == null) {
			setApp();
		}
	}
	
	private void setApp() {
		ServletContext app = getServletContext();
		app.setAttribute("context", app.getContextPath());
		app.setAttribute("home", app.getContextPath() + "/home");
		app.setAttribute("js", app.getContextPath() + "/js");
		app.setAttribute("css", app.getContextPath() + "/css");
		app.setAttribute("images", app.getContextPath() + "/images");
		app.setAttribute("config", "ok");
	}
}
