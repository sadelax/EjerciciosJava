package vista.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registro_usuario")
@SuppressWarnings("serial")
public class Registro extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password-bis");
		
		PrintWriter out = resp.getWriter();
		
		if(isNotEmpty(nombre) && isNotEmpty(usuario) && isNotEmpty(password) && isNotEmpty(password2)) {
			if(password.equals(password2)) {
				out.println(nombre + " te has registrado con éxito");
				out.println("tu usuario es " + usuario);
			} else {
				out.println("las passwords no son iguales");
			}
		} else {
			out.println("todos los campos son obligatorios");
		}
	}
	
	private boolean isNotEmpty(String param) {
		return param != null && param.trim().length() > 0;
	}
}
