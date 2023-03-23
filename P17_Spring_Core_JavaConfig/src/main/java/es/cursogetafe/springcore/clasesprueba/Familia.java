package es.cursogetafe.springcore.clasesprueba;

import java.util.List;

public class Familia 
{
	private PersonaInterface padre;
	private PersonaInterface madre;
	private List<PersonaInterface> hijos;
	private List<String> dias;
	
	public Familia() 
	{
		System.out.println("Constructor de Familia");
	}
	public String toString() 
	{
		String s = "Padre: " + padre + "\n";
		s += "Madre: " + madre + "\n";
		s += "Hijos: \n";
		if(hijos==null) return s;
		
		for (PersonaInterface hijo : hijos) {
			s += "\t " + hijo + "\n";
		}
		return s;
	}
	public PersonaInterface getPadre() {
		return padre;
	}
	public void setPadre(PersonaInterface padre) {
		this.padre = padre;
	}
	public PersonaInterface getMadre() {
		return madre;
	}
	public void setMadre(PersonaInterface madre) {
		this.madre = madre;
	}
	public List<PersonaInterface> getHijos() {
		return hijos;
	}
	public void setHijos(List<PersonaInterface> hijos) {
		this.hijos = hijos;
	}
	public void setDias(List<String> dias) {
		this.dias = dias;
	}
	public List<String> getDias() {
		return dias;
	}
	
}
