package es.cursogetafe.banco.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movimiento")
	private int idMovimiento;
	
	@ManyToOne
	@JoinColumn(name = "fk_extracto")
	private Extracto extracto;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo")
	private TipoMovimiento tipo;
	
	@ManyToOne
	@JoinColumn(name = "fk_tarjeta")
	private Tarjeta tarjeta;
	
	private Date fecha;
	private double importe;
	private String proveedor;
	
	
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public Extracto getExtracto() {
		return extracto;
	}
	public void setExtracto(Extracto extracto) {
		this.extracto = extracto;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	@Override
	public String toString() {
		return "[" + idMovimiento + "]";
	}
	
	
}
