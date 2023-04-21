package main.java.vista.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.modelo.Usuario;
import main.java.persistencia.UsuarioDao;
import main.java.persistencia.UsuarioDaoJpa;


@WebServlet("/login_usuario")
@SuppressWarnings("serial")
public class LoginJsp extends HttpServlet {

	private UsuarioDao userDao;

	public LoginJsp(){
		userDao = new UsuarioDaoJpa();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");
		
		Usuario existente = userDao.valida(usuario, password);
		
		if(isNotEmpty(usuario) && isNotEmpty(password)) {
			if(existente != null) {
				resp.sendRedirect("index");
//				req.getRequestDispatcher("WEB-INF/vistas/index.jsp").forward(req, resp);
			} else {
				req.getSession().setAttribute("error", "inexistente");
				req.getRequestDispatcher("WEB-INF/vistas/login_error.jsp").forward(req, resp);
			}
		} else {
			req.getSession().setAttribute("error", "oblig");
			req.getRequestDispatcher("WEB-INF/vistas/login_error.jsp").forward(req, resp);
		}
	}
	
	private boolean isNotEmpty(String param) {
		return param != null && param.trim().length() > 0;
	}
}