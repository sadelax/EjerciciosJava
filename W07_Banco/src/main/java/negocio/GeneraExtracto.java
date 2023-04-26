package negocio;

import java.io.Serializable;
import java.util.List;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.Extracto;
import modelo.Movimiento;
import modelo.Tarjeta;

public interface GeneraExtracto extends Serializable{

	// Debera retornar los clientes donde "nombre" este contenido en su nombre, 
	//	apellido1 o apellido2
	// No debera cargar su coleccion de cuentas
	public List<Cliente> getClientes(String nombre);
	
	// Debera retornar el extracto correspondiente a esa cuenta de ese año y ese mes
	// El extracto debera contener los movimientos con la/las tarjetas de la cuenta
	public Extracto generaExtracto(Cuenta cuenta, int anyo, int mes);
	
	// Debera retornar el cliente con sus cuentas cargadas. 
	//	No es necesario que las cuentas tengan sus tarjetas
	public Cliente getClienteConCuentas(int idCliente);
	
	// Igual que el anterior
	// AYUDA: utilizar el anterior
	public Cliente getClienteConCuentas(Cliente c);
	
	// Debera retornar una lista con los movimientos del extracto pero solo de la tarjeta indicada
	// AYUDA: puede extraerse del extracto recibido, no hace falta volver a los daos
	public List<Movimiento> getMovimientos(Extracto ext, Tarjeta tjta);
}