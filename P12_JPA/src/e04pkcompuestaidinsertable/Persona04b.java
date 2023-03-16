package e04pkcompuestaidinsertable;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "persona_03")
public class Persona04b implements Serializable {

	@EmbeddedId
	private Persona04bId dni;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Persona04bId getDni() {
		return dni;
	}
	public void setDni(Persona04bId dni) {
		this.dni = dni;
	}
	
	
}
