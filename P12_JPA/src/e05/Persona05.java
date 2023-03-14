package e05;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")

@Entity
@Table(name = "persona")
public class Persona05 implements Serializable {
	

	private int idPersona;
	private String apellidos;
	private String apodo;
	private String nombre;
	private String dni;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos.toUpperCase();
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo.toUpperCase();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Transient
	public String getNombreCompleto() {
		return nombre + " " + apellidos;
	}
}
