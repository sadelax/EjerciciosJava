package ejercicio01;

import util.Util;

public class Ejercicio05 {
	public static void main(String[] arg) {
		double radio, volumen;
		Util.mostrar("Esfera");
		radio = Util.leerDouble("Ingrese radio");
		volumen = (4.0 / 3) * Math.PI * Math.pow(radio, 3);
		Util.mostrar("Volumen: " + volumen);
	}
}
