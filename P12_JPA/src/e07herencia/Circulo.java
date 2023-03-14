package e07herencia;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CIRCULO")
@SuppressWarnings("serial")
public class Circulo extends Figura{
	
	private double r;
	
	public Circulo() {}
	
	public Circulo(double x, double y, double r) {
		super(x, y);
		this.r = r;
	}
	
	public String toString() {
		return "Circulo[" + getX() + ", " + getY() + "; " + r + "]";
	}
	
	public double area() {
		return Math.PI * Math.pow(r, 2);
	}
	
	public double perimetro() {
		return 2 * Math.PI * r;
	}
	
	public boolean equals(Object o) {
		if (!super.equals(o)) return false;
		Circulo otro = (Circulo)o;
		return this.r == otro.r;
	}
	
	public double getR() {
		return r;
	}
	
	public void setR(double r) {
		this.r = r;
	}
}
