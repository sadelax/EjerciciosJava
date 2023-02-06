package ejercicio03;

import util.Util;

//Dados un número indefinido de notas obtenidas por alumnos en sus exámenes, mostrar por pantalla 
//   la mayor y la menor nota obtenida del grupo. (Cuando el usuario ingrese -1 finaliza la carga)

public class Ejercicio01 {
	public static void main(String[] arg) {
		Util.mostrar("Carga de notas");
		double nota, menor, mayor;
		nota = Util.leerDouble("Ingrese nota (-1 finaliza)");
		mayor = menor = nota;
		
		while(nota >= 0) {
			if (nota > mayor) mayor = nota;
			else if (nota < menor) menor = nota;
			
			nota = Util.leerDouble("Ingrese nota (-1 finaliza)");
		}

		if (mayor != -1) {
			Util.mostrar("La nota mayor es " + mayor);
			Util.mostrar("La nota menor es " + menor);
		}
	}
}
