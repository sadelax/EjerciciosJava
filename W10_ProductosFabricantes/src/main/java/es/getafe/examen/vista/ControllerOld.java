package es.getafe.examen.vista;

import static es.getafe.examen.vista.Util.isNotEmpty;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.getafe.examen.modelo.Fabricante;
import es.getafe.examen.modelo.Producto;
import es.getafe.examen.modelo.Usuario;
import es.getafe.examen.negocio.GestionUsuarios;
import es.getafe.examen.negocio.GestionUsuariosImpl;
import es.getafe.examen.negocio.Tienda;
import es.getafe.examen.negocio.TiendaImpl;

//@WebServlet("/home/*")
@SuppressWarnings("serial")
public class ControllerOld extends HttpServlet {

	String context;
	private Tienda neg;
	private GestionUsuarios negUser;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getPathInfo();

		if (req.getSession().getAttribute("user_reg") != null) {
			switch (path) {
			case "/listado_productos":
				req.getRequestDispatcher("/WEB-INF/vistas/listado-productos.jsp").forward(req, resp);
				break;
			case "/productos_fabricante":
				Set<Fabricante> fabricante = neg.getFabricantesActivos();
				System.out.println(fabricante.size());
				req.setAttribute("fabs", fabricante);
				req.getRequestDispatcher("/WEB-INF/vistas/productos-fabricante.jsp").forward(req, resp);
				break;
			case "/productos_fabricante_html":
				fabricante = neg.getFabricantesActivos();
				System.out.println(fabricante.size());
				req.setAttribute("fabs", fabricante);
				req.getRequestDispatcher("/WEB-INF/vistas/productos-fabricante-html.jsp").forward(req, resp);
				break;
			case "/productos_fabricante_json":
				fabricante = neg.getFabricantesActivos();
				System.out.println(fabricante.size());
				req.setAttribute("fabs", fabricante);
				req.getRequestDispatcher("/WEB-INF/vistas/productos-fabricante-json.jsp").forward(req, resp);
				break;
			case "/ofertas":
				Set<Producto> productos = neg.getProductos();
				System.out.println(productos);
				req.setAttribute("productos", productos);
				req.getRequestDispatcher("/WEB-INF/vistas/ofertas.jsp").forward(req, resp);
				break;
			case "/cerrar_sesion":
				req.getSession().invalidate();
				req.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(req, resp);
				break;
			case "/menu_principal":
			default:
				req.getRequestDispatcher("/WEB-INF/vistas/menu-principal.jsp").forward(req, resp);
			}
		} else {
			switch (path) {
			case "/registro_usuario":
				req.getRequestDispatcher("/WEB-INF/vistas/registro.jsp").forward(req, resp);
				break;
			case "/registro_ok":
				req.getRequestDispatcher("/WEB-INF/vistas/registro_ok.jsp").forward(req, resp);
				break;
			case "/registro_fail":
				req.getRequestDispatcher("/WEB-INF/vistas/registro.jsp").forward(req, resp);
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
		case "/login": {
			String user = req.getParameter("usuario");
			String pwd = req.getParameter("password");
			if (isNotEmpty(user) && isNotEmpty(pwd)) {
				Usuario logged = negUser.existe(user, pwd);
				if (logged != null) {
					sesion.setAttribute("user_reg", logged);
					resp.sendRedirect(context + "/home/menu_principal");
				} else {
					sesion.setAttribute("error", "no_user_reg");
					resp.sendRedirect(context + "/home/login");
				}
			} else {
				sesion.setAttribute("error", "campos_vacios_login");
				resp.sendRedirect(context + "/home/login");
			}
			break;
		}
		case "/registro_usuario": {
			String nombre = req.getParameter("nombre");
			String user = req.getParameter("usuario");
			String email = req.getParameter("email");
			String pwd = req.getParameter("password");
			String pwd2 = req.getParameter("password-bis");

			if (isNotEmpty(nombre) && isNotEmpty(user) && isNotEmpty(email) && isNotEmpty(pwd) && isNotEmpty(pwd2)) {
				if (pwd.equals(pwd2)) {
					Usuario nuevo = new Usuario(nombre, user, email, pwd);
					if (negUser.registro(nuevo)) {
						sesion.setAttribute("usuarioNuevo", nuevo);
						resp.sendRedirect(context + "/home/registro_ok");
					} else {
						sesion.setAttribute("error", "ya_existe");
						resp.sendRedirect(context + "/home/registro_fail"); // ojo, es una url, NO es un JSP NUEVO.
					}
				} else {
					sesion.setAttribute("error", "no_match_pwd");
					resp.sendRedirect(context + "/home/registro_fail");
				}
			} else {
				sesion.setAttribute("error", "campos_vacios");
				resp.sendRedirect(context + "/home/registro_fail");
			}
			break;
		}

		case "/listado_productos":
			String desc = req.getParameter("descripcion");
			Set<Producto> productos;
			if (desc != null) {
				productos = neg.getProductos(desc.trim());
			} else {
				productos = neg.getProductos("");
			}
			sesion.setAttribute("productos", productos);
			resp.sendRedirect(context + "/home/listado_productos");
			break;
		case "/productos_fabricante":
			String idFab = req.getParameter("idFabricante");
			int id;
			if (idFab != null) {
				try {
					id = Integer.parseInt(idFab);
					Fabricante fab = neg.getFabricanteConProductos(id);
					sesion.setAttribute("fab", fab);
					resp.sendRedirect(context + "/home/productos_fabricante");
				} catch (NumberFormatException e) {
					resp.sendRedirect(context + "/home/cerrar_sesion");
				}
			}
			break;
		case "/productos_fabricante_html_respuesta":
			idFab = req.getParameter("idFabricante");
			if (idFab != null) {
				try {
					id = Integer.parseInt(idFab);
					Fabricante fab = neg.getFabricanteConProductos(id);
					sesion.setAttribute("fab", fab);
					req.getRequestDispatcher("/WEB-INF/vistas/productos-fabricante-html-respuesta.jsp").forward(req,
							resp);
				} catch (NumberFormatException e) {
					resp.sendRedirect(context + "/home/cerrar_sesion");
				}
			}
			break;
		case "/productos_fabricante_json_respuesta":
			idFab = req.getParameter("idFabricante");
			if (idFab != null) {
				try {
					id = Integer.parseInt(idFab);
					Fabricante fab = neg.getFabricanteConProductos(id);
					sesion.setAttribute("fab", fab);

					Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
					String json = gson.toJson(fab.getProductos());

//					alternativa a las siguientes líneas
//					resp.getWriter().println(json);

					req.setAttribute("json", json);
					req.getRequestDispatcher("/WEB-INF/vistas/productos-fabricante-json-respuesta.jsp").forward(req,
							resp);
				} catch (NumberFormatException e) {
					resp.sendRedirect(context + "/home/cerrar_sesion");
				}
			}
			break;
		case "/ofertas":
			String idsParam = req.getParameter("id_prods");
			String dtosParam = req.getParameter("descuentos");
			if (idsParam != null && dtosParam != null) {
				String[] ids = idsParam.split(",");
				String[] dtos = dtosParam.split(",");
				try {
					int[] idsProds = new int[ids.length];
					double[] dtosProds = new double[dtos.length];
					for (int i = 0; i < ids.length; i++) {
						idsProds[i] = Integer.parseInt(ids[i]);
						dtosProds[i] = Double.parseDouble(dtos[i]);
					}

				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
			}
			break;
		}
	}

	@Override
	public void init() throws ServletException {
		ServletContext app = getServletContext();

		context = app.getContextPath();

		app.setAttribute("context", context);
		app.setAttribute("home", context + "/home");
		app.setAttribute("css", context + "/css");

		neg = new TiendaImpl();
		negUser = new GestionUsuariosImpl();
	}
}
