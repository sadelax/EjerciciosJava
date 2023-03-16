package e11muchosamuchos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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
	private int idJugador;
	private int dorsal;
	@Column(name = "nombreyapellidos")
	private String nombreCompleto;
	private String licencia;
	
	@ManyToMany(mappedBy = "jugadores")
	private List<Equipo> equipos;

	public int getIdjugador() {
		return idJugador;
	}

	public void setIdjugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreyapellidos) {
		this.nombreCompleto = nombreyapellidos;
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
		return "[" + idJugador + ", " + dorsal + ", " + nombreCompleto + ", " + licencia + "]";
	}
	
	
}
