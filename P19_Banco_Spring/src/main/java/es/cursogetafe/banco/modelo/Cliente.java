package es.cursogetafe.banco.modelo;

import java.text.Collator;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Comparable<Cliente> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private int idCliente;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nif;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo")
	private Genero genero;
	
	private String municipio;
	private String provincia;
	
	@OneToMany(mappedBy = "cliente")
	private Set<Cuenta> cuentas;
	
	public Cliente() {}
	
	public Cliente(String nombre, String apellido1, String nif, Genero sexo, String municipio, String provincia) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.nif = nif;
		this.genero = sexo;
		this.municipio = municipio;
		this.provincia = provincia;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getApellidos() {
		return apellido1 + " " + apellido2;
	}
	
	public String getNombreCompleto() {
		return nombre + " " + getApellidos();
	}
	
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
		
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Set<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	@Override
	public String toString() {
		return "[" + idCliente + ", " + nombre + ", " + apellido1 + ", " + apellido2 + ", " + nif + ", " + genero + ", "
				+ municipio + ", " + provincia + "]";
	}

	@Override
	public int compareTo(Cliente o) {
		if(this.equals(o)) return 0;
		Collator col = Collator.getInstance(new Locale("es"));
		
		return col.compare(this.nombre + this.idCliente, o.nombre + o.idCliente);
	}
	
}
