package es.cursogetafe.springcore.clasesprueba;

public class Calendario implements CalendarioInterface
{
	private String entrada;
	private Dia primero;
	private Dia ultimo;
	public Calendario() {
		
	}
	public String toString() {
		return entrada + ": " + primero.getDia() + " - " + ultimo.getDia() + " de " + primero.getMes();  
	}
	public Dia getPrimero() {
		return primero;
	}
	public void setPrimero(Dia primero) {
		this.primero = primero;
	}
	public Dia getUltimo() {
		return ultimo;
	}
	public void setUltimo(Dia ultimo) {
		this.ultimo = ultimo;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	
}
