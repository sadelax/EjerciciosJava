package modelo;

public class Rectangulo extends Figura{
	public double l1;
	public double l2;
	
	public Rectangulo(double x, double y, double l1, double l2) {
		super(x, y);
		this.l1 = l1;
		this.l2 = l2;
	}
	
	public String toString() {
		return "Rectángulo[" + x + ", " + y + "; " + l1 + ", " + l2 + "]";
	}
	
	public double area() {
		return l1 * l2;
	}
	
	public double perimetro() {
		return 2 * l1 + 2 * l2;
	}
	
	public boolean equals(Object o) {
		if(super.equals(o)) return false;
		Rectangulo otro = (Rectangulo)o;
		return (this.l1 == otro.l1 && this.l2 == otro.l2) || (this.l1 == otro.l2 && this.l2 == otro.l1);
	}
}
