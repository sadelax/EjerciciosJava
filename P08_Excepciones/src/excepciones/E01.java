package excepciones;

public class E01 {
	
	public static void main(String[] args) {
		metodoF(2);
		metodoF(577);
		System.out.println("aquí estamos todavía");
	}
	
	public static void metodoF(int indice) {
		System.out.println("introduce sólo un número del 1 al 3");
		System.out.println("recibido " + indice);
		try {
			metodoX(indice);
			System.out.println("indice " + indice);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("yo te soluciono los problemas de " + indice);
			e.printStackTrace();
		}
		System.out.println("no ibas a solucionarme el problema de " + indice + "?");
	}
	
	public static void metodoX(int indice) throws ArrayIndexOutOfBoundsException{
		int[] a = {1, 2, 3};
		System.out.println(a[indice]);
	}

}
