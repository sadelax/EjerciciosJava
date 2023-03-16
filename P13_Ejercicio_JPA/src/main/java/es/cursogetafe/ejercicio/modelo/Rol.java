package es.cursogetafe.ejercicio.modelo;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Inheritance(strategy = InheritanceType.JOINED)
@SuppressWarnings("serial")
public class Rol implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	private String rol;
	@ManyToOne
	@JoinColumn(name = "idPersona")
	private Persona persona;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	protected void setRol(String rol) {
		this.rol = rol;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getIdPersona() {
		return persona.getIdPersona();
	}

	public String getApellidos() {
		return persona.getApellidos();
	}

	public List<Rol> getRoles() {
		return persona.getRoles();
	}
}
