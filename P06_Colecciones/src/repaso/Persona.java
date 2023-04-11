package repaso;

import java.util.Comparator;
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
		return this.idPersona - o.idPersona;
	}
	
	// si voy a usar el comparator todo el tiempo, pa eso lo dejo aquí en la clase.
	// por q estático? xq no depende de la instancia actual.
	public static Comparator<Persona> compNombre(){
		return new Comparator<Persona>() {

			@Override
			public int compare(Persona o1, Persona o2) {
				return o1.getNombre().compareToIgnoreCase(o2.getNombre());
			}
		};
	}
}
