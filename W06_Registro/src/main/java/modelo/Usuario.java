package modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable, Comparable<Usuario> {

	@Id
	@Column(name = "Id_usuario")
	private int idUsuario;
	@Column(name = "usuario")
	private String user;
	private String password;
	private String nombre;
	
	public Usuario() {}
	
	public Usuario(String nombre, String user, String password) {
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
	
	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if(idUsuario == 0 || other.idUsuario == 0)
			return user.equals(other.user);
		else
			return idUsuario == other.idUsuario;
	}

	@Override
	public int compareTo(Usuario o) {
		return this.idUsuario - o.idUsuario;
	}
	
	
}
