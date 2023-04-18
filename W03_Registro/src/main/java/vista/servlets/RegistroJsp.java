package vista.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registro_usuario_jsp")
@SuppressWarnings("serial")
public class RegistroJsp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password-bis");
		
		PrintWriter out = resp.getWriter();
		
		if(isNotEmpty(nombre) && isNotEmpty(usuario) && isNotEmpty(password) && isNotEmpty(password2)) {
			if(password.equals(password2)) {
				// registro correcto

				// queremos reenviar la petición al jsp
				// quiero pasarle el nombre y el usuario
				req.setAttribute("nombre", nombre);
				req.setAttribute("usuario", usuario);
				
				req.getRequestDispatcher("WEB-INF/vistas/registro_ok.jsp").forward(req, resp);
			} else {
				// out.println("las passwords no son iguales");
				req.setAttribute("error", "pass");
				req.getRequestDispatcher("WEB-INF/vistas/registro_error.jsp").forward(req, resp);
			}
		} else {
			// out.println("todos los campos son obligatorios");
			req.setAttribute("error", "oblig");
			req.getRequestDispatcher("WEB-INF/vistas/registro_error.jsp").forward(req, resp);
		}
	}
	
	private boolean isNotEmpty(String param) {
		return param != null && param.trim().length() > 0;
	}
}
