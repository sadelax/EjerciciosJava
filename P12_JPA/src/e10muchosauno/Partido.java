package e10muchosauno;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "partidos")
public class Partido implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpartido;
	private String partido;
	
	@ManyToOne
	@JoinColumn(name = "idcampo")
	private Campo campo;
	
	public int getIdpartido() {
		return idpartido;
	}
	public void setIdpartido(int idpartido) {
		this.idpartido = idpartido;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public Campo getCampo() {
		return campo;
	}
	public void setCampo(Campo campo) {
		this.campo = campo;
	}
	
}
