package es.getafe.examen.vista.actions;

import static es.getafe.examen.vista.Util.isNotEmpty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.getafe.examen.modelo.Usuario;
import es.getafe.examen.negocio.GestionUsuarios;
import es.getafe.examen.negocio.Tienda;

public class LoginAction implements Action {

	String context;
	private Tienda neg;
	private GestionUsuarios negUser;

	@Override
	public String get(String path, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String post(String path, HttpServletRequest req, HttpServletResponse resp) {

		String user = req.getParameter("usuario");
		String pwd = req.getParameter("password");

		HttpSession sesion = req.getSession(true);

		if (isNotEmpty(user) && isNotEmpty(pwd)) {

			Usuario logged = negUser.existe(user, pwd);

			if (logged != null) {
				sesion.setAttribute("user_reg", logged);
			} else {
				sesion.setAttribute("error", "no_user_reg");
				return "redirect: " + path;
			}
		}
		return null;
	}
}