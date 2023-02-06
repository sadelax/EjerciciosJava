package modelo;

public class Circulo extends Figura{
	public double r;
	
	public Circulo(double x, double y, double r) {
		super(x, y);
		this.r = r;
	}
	
	public String toString() {
		return "Circulo[" + x + ", " + y + "; " + r + "]";
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
}
