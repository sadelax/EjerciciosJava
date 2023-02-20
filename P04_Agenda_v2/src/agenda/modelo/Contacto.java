package agenda.modelo;

import java.text.Collator;
import java.util.Locale;

//import java.util.Objects;

public class Contacto implements Comparable<Contacto> {
	
	private int idContacto;
	private String nombre;
	private String apellidos;
	private String apodo;
	private Domicilio dom;
	private String[] telefonos;
	private String[] correos;
	
	private int cantTelefonos;
	private int cantCorreos;
	
	public Contacto() {
		dom = new Domicilio();
		telefonos = new String[10];
		correos = new String[10];
	}
	
	// (Constructor para estudiar el Comparator) Con esto creo contactos rápidamente
	public Contacto(int idContacto, String nombre, String apodo) {
		this();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.apodo = apodo;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public Domicilio getDom() {
		return dom;
	}

	public void setDom(Domicilio dom) {
		this.dom = dom;
	}

	public String[] getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String[] telefonos) {
		this.telefonos = telefonos;
	}

	public String[] getCorreos() {
		return correos;
	}

	public void setCorreos(String[] correos) {
		this.correos = correos;
	}
	
	public void addTelefonos(String... telefonos) {
		for(int i = 0; i < telefonos.length; i++) {
			addTelefono(telefonos[i]);
		}
	}
	
	public void addCorreos(String... correos) {
		for(int i = 0; i < correos.length; i++) {
			addCorreo(correos[i]);
		}
	}
	
	public void addTelefono(String telefono) {
		if (cantTelefonos < 10) {
			telefonos[cantTelefonos] = telefono;
			cantTelefonos++;
		}
	}
	
	public void addCorreo(String telefono) {
		if (cantCorreos < 10) {
			correos[cantCorreos] = telefono;
			cantCorreos++;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (this == o) return true;
		if (this.getClass() != o.getClass()) return false;
		Contacto otro = (Contacto)o;
		return this.idContacto == otro.idContacto;
	}
	
	@Override
	public int hashCode() {
		return idContacto;
	}

	@Override
	public String toString() {
		return "[" + idContacto + ", " + nombre + ", " + apellidos + ", " + apodo + "]";
	}

//	Compara OK independientemente de las mayus o minus
//		no ordena correctamente los caracteres especiales á ñ etc
//	@Override
//	public int compareTo(Contacto o) {
////		ordenar por contacto: 
////		return this.idContacto - o.idContacto;
//		
//		if(this.equals(o)) return 0;
//		
////		ordenar por nombre, a lo beshtia:
////		return this.nombre.compareTo(o.nombre);
//		
////		ordenar por nombre pero bien:
//		return (this.nombre + this.idContacto).toLowerCase().compareTo((o.nombre + o.idContacto).toLowerCase());
//	}
	
	@Override
	public int compareTo(Contacto o) {
		if(this.equals(o)) return 0;
		Collator col = Collator.getInstance(new Locale("es"));	// new Locale es un objeto anónimo
		
		return col.compare(this.nombre + this.idContacto, o.nombre +  o.idContacto);
	}
	
}
