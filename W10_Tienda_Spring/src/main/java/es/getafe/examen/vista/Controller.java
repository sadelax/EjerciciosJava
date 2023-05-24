package es.getafe.examen.vista;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.getafe.examen.negocio.Tienda;
import es.getafe.examen.negocio.TiendaImpl;
import es.getafe.examen.vista.actions.Action;
import es.getafe.examen.vista.actions.ActionsFactory;

@WebServlet("/home/*")
public class Controller extends HttpServlet {

	private Tienda neg;
	private String context;
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
		
		Action actual;
		
		actual = af.getAction(req);
		
		String vista = actual.execute(req, resp);
		
		System.out.println(vista);
		
		if (vista.startsWith("redirect")) {
			resp.sendRedirect(context + "/home/" + vista.substring(9));
		} else {
			req.getRequestDispatcher(af.VISTA_PRE + vista + af.VISTA_POST).forward(req, resp);
		}
	}
}
