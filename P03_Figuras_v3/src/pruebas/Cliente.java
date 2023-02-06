package pruebas;

import java.time.LocalDate;
import java.util.Objects;

import modelo.interfaces.Pintable;

public class Cliente implements Pintable {
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String domicilio;
	private double saldo;
	private LocalDate fechaUltimaCompra;
	
	public Cliente() {}
	
	// usando el generador de eclipse
	public Cliente(int id, String nombre, String apellido1, String apellido2) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Cliente other = (Cliente) obj;
		return id == other.id;
	}

	@Override
	public void pintar() {
		System.out.println("pintandole una a un cliente.");
	}
}
