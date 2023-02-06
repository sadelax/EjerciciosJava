package ejercicios02;

public class Ej13 {
	public static void main(String[] arg) {
		System.out.println("Fichas de domino.");
		
		int contGr = 0, contPeq = 0;
		
		while(contGr <= 6) {
			while(contPeq <= 6) {
				if(contGr <= contPeq)
					System.out.println(contGr + " - " + contPeq);
				contPeq++;
			}
			contPeq = 0;
			contGr++;
			System.out.println("------");
		}
	}
}
