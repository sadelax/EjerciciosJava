package main.java.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@Column(name = "Id_usuario")
	private int idUsuario;
	@Column(name = "usuario")
	private String user;
	private String password;
	private String nombre;
	
	public Usuario() {}
	
	public Usuario(String user, String password, String nombre) {
		this.user = user;
		this.password = password;
		this.nombre = nombre;
	}
	
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "[" + idUsuario + ", " + user + "]";
	}
	
	
}
