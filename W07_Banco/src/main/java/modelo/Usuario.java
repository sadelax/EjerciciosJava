package modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class Usuario implements Serializable, Comparable<Usuario> {

	@Id
	@Column(name = "id_user")
	private int idUsuario;
	private String username;
	private String password;
	private String name;
	private String email;
	private boolean enabled;

	
	public Usuario() {}
	
	public Usuario(String nombre, String username, String password) {
		this.username = username;
		this.password = password;
		this.name = nombre;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "[" + idUsuario + ", " + username + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, username);
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
			return username.equals(other.username);
		else
			return idUsuario == other.idUsuario;
	}

	@Override
	public int compareTo(Usuario o) {
		return this.idUsuario - o.idUsuario;
	}
	
	
}
