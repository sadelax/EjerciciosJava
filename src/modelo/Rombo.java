package modelo;

public class Rombo extends Figura{
	public double d1;
	public double d2;
	
	public Rombo(double x, double y, double d1, double d2) {
		super(x, y);
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public double area() {
		return (d1 * d2) / 2;
	}
	
	public double perimetro() {
		return 4 * Math.sqrt(Math.pow(d1/2, 2) + Math.pow(d2/2, 2));
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Rombo otro = (Rombo)o;
		return (this.d1 == otro.d1 && this.d2 == otro.d2) || (this.d1 == otro.d2 && this.d2 == otro.d1);
	}
	
	public String toString() {
		return "Rombo[" + x + ", " + y + "; " + d1 + "; " + d2 +  "]";
	}
}
