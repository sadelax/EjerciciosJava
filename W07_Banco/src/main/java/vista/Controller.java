package vista;

import static vista.Util.isNotEmpty;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.Extracto;
import modelo.Movimiento;
import modelo.Tarjeta;
import modelo.Usuario;
import negocio.GeneraExtracto;
import negocio.GestionClientes;
import negocio.GestionClientesImpl;
import negocio.GestionUsuarios;
import negocio.GestionUsuariosImpl;

@WebServlet("/home/*")
@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	private String context;
	private GestionUsuarios negUser;
	private GestionClientes negCli;
	private GeneraExtracto negExt;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getPathInfo();

		// user_reg contiene un obj Usuario existente
		if (req.getSession().getAttribute("user_reg") != null) {
			switch (path) {
			case "/menu_principal":
				req.getRequestDispatcher("/WEB-INF/vistas/menu_principal.jsp").forward(req, resp);
				break;
			case "/cerrar_sesion":
				req.getSession().invalidate();
				req.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(req, resp);
				break;
			case "/listado_usuarios":
				Set<Usuario> usuarios = negUser.findAllUsuarios();
				req.setAttribute("usuarios", usuarios);
				req.getRequestDispatcher("/WEB-INF/vistas/listado_usuarios.jsp").forward(req, resp);
				break;

			// case listado clientes
			case "/listado_clientes":
			{
				String valor = req.getParameter("valor");

				Set<Cliente> clientes = null;

				if (valor != null && valor.trim().length() > 0) {
					clientes = new TreeSet<>(negCli.buscar(valor));
				} else {
					clientes = negCli.findAllClientes();
				}

				req.setAttribute("clientes", clientes);
				req.getRequestDispatcher("/WEB-INF/vistas/listado_clientes.jsp").forward(req, resp);
			}
				break;
				
//			case "/eliminar":
//			{
//				Integer id = Integer.parseInt(req.getParameter("id"));
//				Cliente cli = negCli.cuentasCliente(id);
//				negCli.eliminar(cli);
//				
//				if(negCli.eliminar(cli)) {
//					req.setAttribute("eliminado", "si");
//					req.setAttribute("clientes", cli);
//					req.getSession().setAttribute("clientes", null);
//				} else {
//					req.setAttribute("eliminado", "no");
//				}
//				
//				Set<Cliente> clientes = negCli.findAllClientes();
//				req.setAttribute("clientes", clientes);
//				req.getRequestDispatcher("/WEB-INF/vistas/listado_clientes.jsp").forward(req, resp);
//			}
//				break;


			// case cuentas de clientes
			case "/cuentas":
			{
				Integer id = Integer.parseInt(req.getParameter("id"));
				Cliente cli = negCli.cuentasCliente(id);
				
				req.setAttribute("cli", cli);
				
				// mostrar el extracto
//				int mes = Integer.parseInt(req.getParameter("mes"));
//				int anyo = Integer.parseInt(req.getParameter("anyo"));
//				Cuenta cue = negExt.getCuenta(id);
//				Extracto ext = negExt.generaExtracto(cue, anyo, mes);
				
				// TODO
				
				req.getRequestDispatcher("/WEB-INF/vistas/cuentas.jsp").forward(req, resp);
			}
				break;				
			case "/registro_cliente":
				req.getRequestDispatcher("/WEB-INF/vistas/registro_cliente.jsp").forward(req, resp);
				break;

			case "/registro_cli_ok":
				req.getRequestDispatcher("/WEB-INF/vistas/registro_cli_ok.jsp").forward(req, resp);
				break;
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
		// corcheteo este case porque así no chocan variables q se llaman igual en el
		// próximo case
		case "/login": {
			String user = req.getParameter("usuario");
			String pwd = req.getParameter("password");
			if (isNotEmpty(user) && isNotEmpty(pwd)) {
				Usuario logged = negUser.existe(user, pwd);
				if (logged != null) {
					sesion.setAttribute("user_reg", logged); // user_reg contiene ahora un objeto Usuario
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
		case "/registro_cliente":
			String nombre = req.getParameter("nombre");
			String apellido1 = req.getParameter("apellido1");
			String nif = req.getParameter("nif");
			String municipio = req.getParameter("municipio");
			String provincia = req.getParameter("provincia");

			if (isNotEmpty(nombre) && isNotEmpty(apellido1) && isNotEmpty(nif) && isNotEmpty(municipio)
					&& isNotEmpty(provincia)) {

				Cliente nuevo = new Cliente(nombre, apellido1, nif, municipio, provincia);

				System.out.println("1" + nuevo);

				if (negCli.registro(nuevo)) {
					sesion.setAttribute("clienteNuevo", nuevo);
					resp.sendRedirect(context + "/home/registro_cli_ok");

					System.out.println("2" + nuevo);
				}
			} else {
				sesion.setAttribute("error", "campos_vacios_cli");
				resp.sendRedirect(context + "/home/registro_cliente");
			}

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

		negUser = new GestionUsuariosImpl();
		negCli = new GestionClientesImpl();

	}
}
