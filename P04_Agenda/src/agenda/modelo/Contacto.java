package agenda.modelo;

public class Contacto {
	
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
	public String toString() {
		return "[" + idContacto + ", " + nombre + ", " + apellidos + ", " + apodo + "]";
	}
	
	
}
