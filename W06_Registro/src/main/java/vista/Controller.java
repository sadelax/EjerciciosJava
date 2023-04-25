package vista;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import persistencia.UsuarioDao;
import persistencia.UsuarioDaoJpa;

import static vista.Util.isNotEmpty;

@WebServlet("/home/*")
@SuppressWarnings("serial")
public class Controller extends HttpServlet {
	
	private String context;
	private UsuarioDao userDao;
		
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
			case "/listado_usuarios":
				Set<Usuario> usuarios = userDao.findAll();
				req.setAttribute("usuarios", usuarios);
				req.getRequestDispatcher("/WEB-INF/vistas/listado_usuarios.jsp").forward(req, resp);
				break;
			}
		} else {
			// aquí atendemos a todo lo público
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
		case "/login":
		{
			String user = req.getParameter("usuario"); // ojo: el name del input del html/jsp
			String pwd = req.getParameter("password");
			if(isNotEmpty(user) && isNotEmpty(pwd)) {
				Usuario userActual = userDao.valida(user, pwd);
				if(userActual != null) {
					sesion.setAttribute("usr_reg", userActual);
					resp.sendRedirect(context + "/home/menu_principal");
				} else {
					sesion.setAttribute("error", "no_login");
					resp.sendRedirect(context + "/home/login");
				}
			} else {
				sesion.setAttribute("error", "login_vacios");
				resp.sendRedirect(context + "/home/login");
			}
			break;
		}
		case "/registro_usuario":
			String nombre = req.getParameter("nombre");
			String user = req.getParameter("usuario");
			String pwd = req.getParameter("password");
			String pwd2 = req.getParameter("password-bis");
			if(isNotEmpty(nombre) && isNotEmpty(user) && isNotEmpty(pwd) && isNotEmpty(pwd2)) {
				if(pwd.equals(pwd2)) {
					Usuario nuevo = new Usuario(nombre, user, pwd);
					if(userDao.save(nuevo)) {
						sesion.setAttribute("usuarioNuevo", nuevo);
						resp.sendRedirect(context + "/home/registro_ok");
					} else {
						// insultar xq ya existe
						sesion.setAttribute("error", "existe");
						resp.sendRedirect(context + "/home/registro_fail");
					}
					
				} else {
					// insultar por los passwords
					sesion.setAttribute("error", "passwords");
					resp.sendRedirect(context + "/home/registro_fail");
				}
			} else {
				// insultar xq están en blanco
				sesion.setAttribute("error", "vacios");
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
		
		userDao = new UsuarioDaoJpa();
	}
}
