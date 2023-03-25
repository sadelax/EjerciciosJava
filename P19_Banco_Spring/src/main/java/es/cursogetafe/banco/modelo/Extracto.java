package
es.cursogetafe.banco.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "extractos")
public class Extracto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExtracto;
	
	@ManyToOne
	@JoinColumn(name = "fk_cuenta")
	private Cuenta cuenta;
	
	private int anyo;
	private int mes;
	
	
	public int getIdExtracto() {
		return idExtracto;
	}
	public void setIdExtracto(int idExtracto) {
		this.idExtracto = idExtracto;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	
}
