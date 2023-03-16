package e04pkcompuestaidclass;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "persona_03")
@IdClass(Persona04Id.class)
public class Persona04 implements Serializable {

	@Id
	@Column(name = "nrodoc")
	private int dni;
	@Id
	@Column(name = "letradoc")
	private char letra;
	
	private String nombre;
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
