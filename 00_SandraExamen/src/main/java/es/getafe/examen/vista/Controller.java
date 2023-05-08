package es.getafe.examen.vista;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.getafe.examen.modelo.Producto;
import es.getafe.examen.persistencia.FabricanteDao;
import es.getafe.examen.persistencia.FabricanteDaoImpl;
import es.getafe.examen.persistencia.ProductoDao;
import es.getafe.examen.persistencia.ProductoDaoImpl;

@WebServlet("/home/*")
@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	private String context;
	private FabricanteDao fdao;
	private ProductoDao pdao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getPathInfo();
		
		switch (path) {
		case "/menu_principal":
			req.getRequestDispatcher("/WEB-INF/vistas/menu-principal.jsp").forward(req, resp);
			break;
		case "/listado_productos":
			Set<Producto> productos = new TreeSet<>(pdao.findAll());
			req.setAttribute("productos", productos);
			req.getRequestDispatcher("/WEB-INF/vistas/listado-productos.jsp").forward(req, resp);
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
		app.setAttribute("css", app.getContextPath() + "/css");
		
		fdao = new FabricanteDaoImpl();
		pdao = new ProductoDaoImpl();
	}
	
}
