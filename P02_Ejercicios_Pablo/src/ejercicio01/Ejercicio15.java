package ejercicio01;

import util.Util;

//Hacer un algoritmo que, dados los catetos de un triángulo rectángulo, calcule su 
//  hipotenusa. ℎ =√𝑎2+𝑏2, con h (hipotenusa), a y b (catetos)

public class Ejercicio15 {
	public static void main(String[] args) {
		double cateto1, cateto2, hipotenusa;
		
		Util.mostrar("Triángulo Rectángulo");
		cateto1 = Util.leerDouble("Cateto");
		cateto2 = Util.leerDouble("Cateto");
		hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
		
		Util.mostrar("Hipotenusa: " + hipotenusa);
	}
}
