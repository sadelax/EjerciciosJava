package metodos;

public class PotenciaFactorial {
	public static void main(String[] arg) {
		System.out.println(potencia(5,5));
	}
	
	public static int potencia(int n, int exp) {
		if(n == 0)
			return 1;
		else
			return(n * potencia(n, exp - 1));			
	}
}
