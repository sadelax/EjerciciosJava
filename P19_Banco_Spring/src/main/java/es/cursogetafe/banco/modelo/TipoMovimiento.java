package es.cursogetafe.banco.modelo;

import java.text.Collator;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_movimientos")
public class TipoMovimiento implements Comparable<TipoMovimiento> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_movimiento")
	private int idTipo;
	
	@Column(name = "tipo_movimiento")
	private String tipo;

	
	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "[" + idTipo + ", " + tipo + "]";
	}

	@Override
	public int compareTo(TipoMovimiento o) {
		if(this.equals(o)) return 0;
		Collator col = Collator.getInstance(new Locale("es"));
		
		return col.compare(this.idTipo + this.tipo, o.idTipo + o.tipo);
	}
	
}
