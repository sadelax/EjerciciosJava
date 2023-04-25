package modelo;

import java.text.Collator;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tarjetas")
public class Tarjeta implements Comparable<Tarjeta> {

	@Override
	public String toString() {
		return "[" + idTarjeta + ", " + pan + ", " + marca + ", " + tipo + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarjeta")
	private int idTarjeta;
	
	private String pan;
	private String marca;
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "fk_cuenta")
	private Cuenta cuenta;
	
	@Column(name = "anyo_vencimiento")
	private int anyoVenc;
	
	@Column(name = "mes_vencimiento")
	private int mesVenc;

	
	public int getIdTarjeta() {
		return idTarjeta;
	}
	
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public int getAnyoVenc() {
		return anyoVenc;
	}

	public void setAnyoVenc(int anyoVenc) {
		this.anyoVenc = anyoVenc;
	}

	public int getMesVenc() {
		return mesVenc;
	}

	public void setMesVenc(int mesVenc) {
		this.mesVenc = mesVenc;
	}

	@Override
	public int compareTo(Tarjeta o) {
		if(this.equals(o)) return 0;
		Collator col = Collator.getInstance(new Locale("es"));
		
		return col.compare(this.pan + this.idTarjeta, o.pan + o.idTarjeta);
	}
}
