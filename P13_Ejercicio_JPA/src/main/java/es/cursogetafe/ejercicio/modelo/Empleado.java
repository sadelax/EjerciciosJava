package es.cursogetafe.ejercicio.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
@SuppressWarnings("serial")
public class Empleado extends Rol {

	private int nroEmpleado;
	@ManyToOne()
	@JoinColumn(name = "idcategoria")
	private Categoria categoria;

	public Empleado(){
		setRol("EMPLEADO");
	}
	
	public int getNroEmpleado() {
		return nroEmpleado;
	}

	public void setNroEmpleado(int nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
