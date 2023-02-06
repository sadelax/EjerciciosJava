package modelo;

import modelo.interfaces.Pintable;

public class Rombo extends Figura implements Pintable {
	private double d1;
	private double d2;
	
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
		return "Rombo[" + getX() + ", " + getY() + "; " + d1 + "; " + d2 +  "]";
	}
	
	public double getD1() {
		return d1;
	}

	public double getD2() {
		return d2;
	}
	
	public void setD1(double d1) {
		this.d1 = d1;
	}
	
	public void setD2(double d2) {
		this.d2 = d2;
	}

	@Override
	public void pintar() {
		System.out.println("este rombo es de color verde xd");
	}
}

