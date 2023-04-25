package vista;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import negocio.GeneraExtracto;
import negocio.GeneraExtractoImpl;

@WebServlet("/prueba01")
@SuppressWarnings("serial")
public class Prueba01 extends HttpServlet {

	private GeneraExtracto genExt;
	
	@Override
	public void init() throws ServletException {
		genExt = new GeneraExtractoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Cliente> clientes = genExt.getClientes("");
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
}
