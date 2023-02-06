package ejercicios02;

public class Ej11 {
	public static void main(String[] arg) {
		System.out.println("Imprimir las tablas de multiplicar.");
		
		int num = 1, cont = 0, res = 0;
		
		while(num <= 9) {
			while(cont <= 9) {
				System.out.println(num + " por " + cont + " = " + res);
				cont++;
				res = num * cont;
			}
			cont = 0;
			res = 0;
			num++;
			System.out.println("------------");
		}
		
	}
}
