package modelo;

public class Circulo extends Figura{
	public double r;
	
	public Circulo(double x, double y, double r) {
		super(x, y);
		this.r = r;
	}
	
	public String toString() {
		return "Circ[" + x + ", " + y + "; " + r + "]";
	}
	
	public double area() {
		return Math.PI * Math.pow(r, 2);
	}
}
