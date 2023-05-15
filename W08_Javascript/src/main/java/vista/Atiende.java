package vista;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/atiende")
public class Atiende extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String p1 = req.getParameter("att1");
		String p2 = req.getParameter("selectNormal");
		String[] p3 = req.getParameterValues("selectMultiple");
		
		System.out.println(p1);
		System.out.println(p2);
		for (String param : p3) {
			System.out.println(param);
		}
	}
	
}
