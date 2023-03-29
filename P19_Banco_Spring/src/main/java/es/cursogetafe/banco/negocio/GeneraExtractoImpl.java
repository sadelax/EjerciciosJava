package es.cursogetafe.banco.negocio;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cursogetafe.banco.modelo.Cliente;
import es.cursogetafe.banco.modelo.Cuenta;
import es.cursogetafe.banco.modelo.Extracto;
import es.cursogetafe.banco.modelo.Movimiento;
import es.cursogetafe.banco.modelo.Tarjeta;
import es.cursogetafe.banco.persistencia.ClienteDao;
import es.cursogetafe.banco.persistencia.ExtractoDao;

@Service("generaExtracto")
@SuppressWarnings("serial")
public class GeneraExtractoImpl implements GeneraExtracto {

	@Autowired
	private ClienteDao cd;
	@Autowired
	private ExtractoDao ed;
	
	@Override
	public List<Cliente> getClientes(String nombre) {
		List<Cliente> clientes;
		if(nombre == null || nombre.length() == 0)
			clientes = new LinkedList<>(cd.findAll());
		else
			clientes = cd.findByValue(nombre);
		return clientes;
	}

	@Override
	public Extracto generaExtracto(Cuenta cuenta, int anyo, int mes) {
		Extracto generado = ed.extractoFechaEager(cuenta, anyo, mes);
		return generado;
	}

	@Override
	public Cliente getClienteConCuentas(int idCliente) {
		Cliente cliente = cd.findByIdEager(idCliente);
		return cliente;
	}

	@Override
	public Cliente getClienteConCuentas(Cliente c) {
		c = getClienteConCuentas(c.getIdCliente());
		return c;
	}

	@Override
	public List<Movimiento> getMovimientos(Extracto ext, Tarjeta tjta) {
		List<Movimiento> movimientos = new LinkedList<>();
		for (Movimiento movimiento : ext.getMovimientos()) {
			if (movimiento.getTarjeta() == tjta) {
				movimientos.add(movimiento);
			}
		}
		return movimientos;
	}

}
