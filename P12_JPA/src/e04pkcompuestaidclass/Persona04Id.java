package e04pkcompuestaidclass;

import java.io.Serializable;

public class Persona04Id implements Serializable {

	private int dni;
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
