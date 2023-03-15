package e11muchosamuchos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jugadores_03")
@SuppressWarnings("serial")
public class Jugador implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idjugador;
	
	private int dorsal;
	private String nombreyapellidos;
	private String licencia;
	
	@ManyToMany(mappedBy = "jugadores")
	private List<Equipo> equipos;

	public int getIdjugador() {
		return idjugador;
	}

	public void setIdjugador(int idjugador) {
		this.idjugador = idjugador;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombreyapellidos() {
		return nombreyapellidos;
	}

	public void setNombreyapellidos(String nombreyapellidos) {
		this.nombreyapellidos = nombreyapellidos;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "[" + idjugador + ", " + dorsal + ", " + nombreyapellidos + ", " + licencia + "]";
	}
	
	
}
