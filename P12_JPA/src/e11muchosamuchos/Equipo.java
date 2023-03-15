package e11muchosamuchos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "equipos_03")
@SuppressWarnings("serial")
public class Equipo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idequipo;
	
	private String equipo;
	
	@ManyToMany
	@JoinTable(name = "equipos_jugadores_03", 
				joinColumns = @JoinColumn(name = "idequipo"), 
				inverseJoinColumns = @JoinColumn(name = "idjugador"))	
	private List<Jugador> jugadores;

	public int getIdequipo() {
		return idequipo;
	}

	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugador) {
		this.jugadores = jugador;
	}

	@Override
	public String toString() {
		return "[" + idequipo + "]";
	}
	
}
