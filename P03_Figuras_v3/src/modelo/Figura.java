package modelo;

// he creado la clase Figura como clase abstracta, ASÍ automáticamente impido q se creen objetos de esta clase.
public abstract class Figura {
	
	// private porque no quiero que se acceda a estos atributos.
	// Solo se podrán acceder a través de los getters/setters.
	private double x;
	private double y;
	
	public Figura() {}		// este digamos q sería el constructor por defecto (posicionado en 0,0)
	
	// pero en realidad necesito este constructor:
	public Figura(double x, double y) {
//		super(); // esto llamaría al constructor de Object. Ese es el constructor por defecto.
		this.x = x;
		this.y = y;
	}
	
	// he creado el método perímetro() abstracto. area() también sería abstracto ! (lo dejo normal por educational purposes)
	public abstract double perimetro();
	
	public double area() {
		return 0;
	}
	
	public boolean equals(Object o) {
		if (o == null) return false;
		if (this == o) return true;
		if (this.getClass() != o.getClass()) return false;
		Figura otra = (Figura)o;
		return this.x == otra.x && this.y == otra.y;
	}
	
	// get es para consultar una variable privada.
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	// set es para cambiar.
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
}
