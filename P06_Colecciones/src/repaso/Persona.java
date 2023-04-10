package repaso;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

	private int idPersona;
	private String nombre;
	
	public Persona(int idPersona, String nombre) {
		this.idPersona = idPersona;
		this.nombre = nombre;
	}
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return idPersona == other.idPersona;
	}
	@Override
	public String toString() {
		return "[" + idPersona + ", " + nombre + "]";
	}

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return this.idPersona - o.idPersona;
	}
	
	
}
