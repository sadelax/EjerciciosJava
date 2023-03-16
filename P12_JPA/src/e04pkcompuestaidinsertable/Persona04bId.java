package e04pkcompuestaidinsertable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Persona04bId implements Serializable {

	@Column(name = "nrodoc")
	private int dni;
	@Column(name = "letradoc")
	private char letra;
	
	public int getId() {
		return dni;
	}
	public void setDni(int id) {
		this.dni = id;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	
}
