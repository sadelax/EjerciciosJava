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

	public Controller(){
		System.out.println("se ejecutó el constructor del servlet");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	public void init() throws ServletException {
		ServletContext app = getServletContext();
		app.setAttribute("context", app.getContextPath());
		app.setAttribute("home", app.getContextPath() + "/home");
		app.setAttribute("js", app.getContextPath() + "/js");
		app.setAttribute("css", app.getContextPath() + "/css");
		app.setAttribute("images", app.getContextPath() + "/images");
	}
}
