package es.getafe.examen.vista;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.getafe.examen.negocio.Tienda;
import es.getafe.examen.negocio.TiendaImpl;
import es.getafe.examen.vista.actions.ActionsFactory;

//@WebServlet("/home/*")
@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	String context;
	private Tienda neg;
	private ActionsFactory af;

	@Override
	public void init() throws ServletException {
		neg = new TiendaImpl();
		af = new ActionsFactory();

		ServletContext app = getServletContext();
		context = app.getContextPath();

		app.setAttribute("context", context);
		app.setAttribute("home", context + "/home");
		app.setAttribute("css", context + "/css");
		

	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
