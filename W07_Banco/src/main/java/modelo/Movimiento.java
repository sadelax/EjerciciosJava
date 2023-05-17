package modelo;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movimientos")
public class Movimiento implements Comparable<Movimiento> {

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
	
	@Temporal(TemporalType.DATE)
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
	public TipoMovimiento getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimiento tipo) {
		this.tipo = tipo;
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
	
	public String getFechaFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha);
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
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idMovimiento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimiento other = (Movimiento) obj;
		return idMovimiento == other.idMovimiento;
	}
	@Override
	public int compareTo(Movimiento o) {		
		return this.fecha.compareTo(o.fecha);
	}
	
}
