package modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta implements Comparable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private int idCuenta;
	
	@Column(name = "numero")
	private String numeroCuenta;
	
	@ManyToOne()
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "cuenta")
	private Set<Tarjeta> tarjetas;

	
	public int getIdCuenta() {
		return idCuenta;
	}
	
	public Cuenta() {}
	
	public Cuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(Set<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	@Override
	public String toString() {
		return numeroCuenta;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
