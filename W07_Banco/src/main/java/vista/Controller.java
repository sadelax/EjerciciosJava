package vista;

import static vista.Util.isNotEmpty;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Cliente;
import modelo.Usuario;
import persistencia.ClienteDao;
import persistencia.ClienteDaoJPA;
import persistencia.UsuarioDao;
import persistencia.UsuarioDaoJpa;

@WebServlet("/home/*")
@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	private String context;
	private UsuarioDao ud;
	private ClienteDao cd;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getPathInfo();

		// acordate q usr_reg lo creo en un setAttribute en el doPost, y dentro hay un
		// obj Usuario existente
		if (req.getSession().getAttribute("usr_reg") != null) {
			switch (path) {
			case "/menu_principal":
				req.getRequestDispatcher("/WEB-INF/vistas/menu_principal.jsp").forward(req, resp);
				break;
			case "/cerrar_sesion":
				req.getSession().invalidate();
				req.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(req, resp);
				break;
			case "/listado_usuarios":
				Set<Usuario> usuarios = ud.findAll();
				req.setAttribute("usuarios", usuarios);
				req.getRequestDispatcher("/WEB-INF/vistas/listado_usuarios.jsp").forward(req, resp);
				break;
			case "/listado_clientes":
				Set<Cliente> clientes = cd.findAll();
				req.setAttribute("clientes", clientes);
				req.getRequestDispatcher("/WEB-INF/vistas/listado_clientes.jsp").forward(req, resp);
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
		case "/login": {
			String user = req.getParameter("usuario");
			String pwd = req.getParameter("password");
			if (isNotEmpty(user) && isNotEmpty(pwd)) {
				Usuario userActual = ud.valida(user, pwd);
				if (userActual != null) {
					sesion.setAttribute("usr_reg", userActual); // guardo en "usr_reg" el Usuario
					resp.sendRedirect(context + "/home/menu_principal");
				} else {
					sesion.setAttribute("error", "no_usr_reg");
					resp.sendRedirect(context + "/home/login");
				}
			} else {
				sesion.setAttribute("error", "campos_login_vacios");
				resp.sendRedirect(context + "/home/login");
			}
			break;
		}
		case "/registro_usuario":
			String nombre = req.getParameter("nombre");
			String user = req.getParameter("usuario");
			String email = req.getParameter("email");
			String pwd = req.getParameter("password");
			String pwd2 = req.getParameter("password-bis");
			if (isNotEmpty(nombre) && isNotEmpty(user) && isNotEmpty(pwd) && isNotEmpty(pwd2)) {
				if (pwd.equals(pwd2)) {
					Usuario nuevo = new Usuario(nombre, user, email, pwd);
					if (ud.save(nuevo)) {
						sesion.setAttribute("usuarioNuevo", nuevo);
						resp.sendRedirect(context + "/home/registro_ok");
					} else {
						sesion.setAttribute("error", "ya_existe");
						resp.sendRedirect(context + "/home/registro_fail");
					}
				} else {
					sesion.setAttribute("error", "no_match_pwd");
					resp.sendRedirect(context + "/home/registro_fail");
				}
			} else {
				sesion.setAttribute("error", "campos_vacios");
				resp.sendRedirect(context + "/home/registro_fail");
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

		ud = new UsuarioDaoJpa();
		cd = new ClienteDaoJPA();
	}
}
