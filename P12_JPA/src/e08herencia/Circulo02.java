package e08herencia;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "circulo_02")
@SuppressWarnings("serial")
public class Circulo02 extends Figura02 {
	
	private double r;
	
	public Circulo02() {}
	
	public Circulo02(double x, double y, double r) {
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
		Circulo02 otro = (Circulo02)o;
		return this.r == otro.r;
	}
	
	public double getR() {
		return r;
	}
	
	public void setR(double r) {
		this.r = r;
	}
}
