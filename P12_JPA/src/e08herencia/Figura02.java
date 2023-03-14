package e08herencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "figuras02")
@Inheritance(strategy = InheritanceType.JOINED)
@SuppressWarnings("serial")
public abstract class Figura02 implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfigura;
	private double x;
	private double y;
	
	public Figura02() {}
	
	public Figura02(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract double perimetro();
	
	public double area() {
		return 0;
	}
	
	public boolean equals(Object o) {
		if (o == null) return false;
		if (this == o) return true;
		if (this.getClass() != o.getClass()) return false;
		Figura02 otra = (Figura02)o;
		return this.x == otra.x && this.y == otra.y;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getIdFigura() {
		return idfigura;
	}

	public void setIdFigura(int id) {
		this.idfigura = id;
	}
}
