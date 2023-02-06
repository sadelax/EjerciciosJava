package metodos;

public class FuncionesFactoriales {
	public static void main(String[] arg) {
		System.out.println(fibonacci(8));
		System.out.println(potencia(5,5));
	}
	public static long fibonacci(long n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return (fibonacci(n - 1) + fibonacci(n - 2));
	}
	
	public static int potencia(int n, int exp) {
		if(exp == 0)
			return 1;
		else
			return(n * potencia(n, exp - 1));			
	}

}
