package ejercicio03;

import util.Util;

//5. Escribir un programa que pida al usuario un número, que representará una cantidad de dinero 
//  expresada en euros. 
//  A continuación, el programa le ofrecerá un menú al usuario en el que le preguntará a qué divisa 
//  quiere convertir del dinero e imprimirá la conversión. 
//  Las posibles divisas son las siguientes (se indica el tipo de cambio):
//	 - Dólares (1 dólar = 0,88 euros)
//	 - Libra Esterlina (1 Libra = 1,20 euros)
//	 - Yen (1 yen = 0,0077 euros).
//	 - Dólares Canadienses (1 dólar C. = 0,71 euros)
public class Ejercicio05 {
	public static void main(String[] arg) {
		
		int opcion;
		Util.mostrar("Conversor de Euros");
		double euros = 0, otraMoneda, indice = 1;
		char moneda = ' ';
		
		do {
			Util.mostrar("1 - Dolares");
			Util.mostrar("2 - Libras Esterlinas");
			Util.mostrar("3 - Yen");
			Util.mostrar("4 - Dolares Canadienses");
			Util.mostrar("0 - Salir");
			opcion = Util.leerInt(">");
			
			switch(opcion) {
				case 1:
					indice = 0.88;
					moneda = '$';
					break;
				case 2:
					indice = 1.2;
					moneda = 'L';
					break;
				case 3:
					indice = 0.0077;
					moneda = 'Y';
					break;
				case 4:
					indice = 0.71;
					moneda = 'D';
					break;
			}
			if(opcion >= 1 && opcion <= 4) {
				euros = Util.leerDouble("Importe");
				otraMoneda = euros / indice;
				Util.mostrar(euros + "€ = " + Math.round(otraMoneda*100)/100. + " " + moneda);
			}
		}while(opcion != 0);
	}
}
