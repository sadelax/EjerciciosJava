package vista.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import persistencia.UsuarioDao;
import persistencia.UsuarioDaoJpa;

@WebServlet("/registro_usuario")
@SuppressWarnings("serial")
public class RegistroJsp extends HttpServlet {

	private UsuarioDao userDao;

	public RegistroJsp(){
		userDao = new UsuarioDaoJpa();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");
		String nombre = req.getParameter("nombre");
		String password2 = req.getParameter("password-bis");
				
		if(isNotEmpty(usuario) && isNotEmpty(password) && isNotEmpty(password2)) {
			if(password.equals(password2)) {
				Usuario nuevo = new Usuario(usuario, password, nombre);

				// GUARDARLO en la bbdd
				 userDao.save(nuevo);

				// registro correcto
				// queremos reenviar la petición al jsp
				// quiero pasarle el nombre y el usuario
				req.setAttribute("usuario", usuario);
				
				req.getRequestDispatcher("registro_ok.html").include(req, resp);
			} else {
				// out.println("las passwords no son iguales");
				req.setAttribute("error", "pass");
				req.getRequestDispatcher("/WEB-INF/vistas/registro_error.jsp").forward(req, resp);
			}
		} else {
			// out.println("todos los campos son obligatorios");
			req.setAttribute("error", "oblig");
			req.getRequestDispatcher("/WEB-INF/vistas/registro_error.jsp").forward(req, resp);
		}
	}
	
	private boolean isNotEmpty(String param) {
		return param != null && param.trim().length() > 0;
	}
}
