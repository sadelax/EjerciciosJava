package ejercicios06;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

import util.Util;

// los métodos prueba son para ver cómo curran.

public class Ordenar {
	
	public static int seleccion(double[] vec) {
		int posMayor;
		int cont = 0;
		double aux;
		int posUltimo;
		for (int i = 0; i < vec.length; i++) {
			posMayor = 0;
			for (int j = 1; j < vec.length - i; j++) {
				cont++;
				if (vec[j] > vec[posMayor])
					posMayor = j;
			}
			posUltimo = vec.length - i - 1;
			aux = vec[posUltimo];
			vec[posUltimo] = vec[posMayor];
			vec[posMayor] = aux;
		}
		return cont;
	}
	
	public static int seleccionDoble(double[] vec) {
		int posMayor;
		int posMenor;
		int cont = 0;
		double aux;
		int posPrimero = 0;
		int posUltimo = vec.length - 1;
		for (int i = 0; i < vec.length && posPrimero < posUltimo; i++) {
			posMenor = i;
			posMayor = i;
			for (int j = posPrimero; j <= posUltimo; j++) {
				cont++;
				if (vec[j] > vec[posMayor])
					posMayor = j;
				else if (vec[j] < vec[posMenor])
					posMenor = j;
			}

			if (posMenor == posUltimo) // por si me cambia el menor
				posMenor = posMayor;
			aux = vec[posUltimo];
			vec[posUltimo] = vec[posMayor];
			vec[posMayor] = aux;
			
			aux = vec[posPrimero];
			vec[posPrimero] = vec[posMenor];
			vec[posMenor] = aux;

			posPrimero++;
			posUltimo--;
		}
		return cont;
	}
	

	public static void pruebaBurbuja(double[] vec) {
		Util.mostrarVector(vec);
		System.out.println("Burbuja");
		double aux;
		boolean ordenado = false;
		for (int i = 1; i < vec.length && !ordenado; i++) {
			ordenado = true;
			for (int j = 0; j < vec.length - i; j++) {
				System.out.println(j + " con " + (j+1));
				if (vec[j] > vec[j+1]) {
					aux = vec[j];
					vec[j] = vec[j+1];
					vec[j+1] = aux;
					ordenado = false;
					Util.mostrarVector(vec);
				}
			}
			System.out.println();
		}
	}
	
//	Burbuja
	public static int burbuja(double[] vec) {
		double aux;
		int cont = 0;
		boolean ordenado = false;
		for (int i = 1; i < vec.length && !ordenado; i++) {
			ordenado = true;
			for (int j = 0; j < vec.length - i; j++) {
				cont ++;
				if (vec[j] > vec[j+1]) {
					aux = vec[j];
					vec[j] = vec[j+1];
					vec[j+1] = aux;
					ordenado = false;
				}
			}
		}
		return cont;
	}
	
	public static void pruebaInsercion(double[] vec) {
		Util.mostrarVector(vec);
		System.out.println("Insercion");
		double aux;
		for (int i = 1; i < vec.length; i++) {
			boolean esMenor = true;
			Util.mostrarVector(vec);
			for (int j = i; j >= 1 && esMenor; j--) {
				System.out.println(j + " con " + (j - 1));
				if (vec[j] < vec[j-1]) {
					aux = vec[j];
					vec[j] = vec[j-1];
					vec[j-1] = aux;
					Util.mostrarVector(vec);
				} else {
					esMenor = false;
				}
			}
			System.out.println();
		}
	}
	
//   Inserción
	public static int insercion(double[] vec) {
		double aux;
		int cont = 0;
		for (int i = 1; i < vec.length; i++) {
			boolean esMenor = true;
			for (int j = i; j >= 1 && esMenor; j--) {
				cont ++;
				if (vec[j] < vec[j-1]) {
					aux = vec[j];
					vec[j] = vec[j-1];
					vec[j-1] = aux;
				} else {
					esMenor = false;
				}
			}
		}
		return cont;
	}
	
//	QuickSort
	public static void quickSort(double[] v) {
		quickSort(v, 0, v.length-1);
	}
	
	private static void quickSort(double[] v, int izq, int der) {
		double valPivote = elijePivote(v, izq, der);
		int i = izq;
		int d = der;
		double aux;
		while(i < d) {
			while(v[i] < valPivote) i++;
			while(v[d] > valPivote) d--;
			if(i < d) {
				aux = v[i];
				v[i] = v[d];
				v[d] = aux;
				i++;
				d--;
			}
		}
		if (izq < d) quickSort(v, izq, d);
		if (der > i) quickSort(v, i, der);
	}
	
	private static double elijePivote(double[] v, int izq, int der) {
		double valPivote;
		switch(der-izq) {
		case 0:
			valPivote = v[izq];
			break;
		case 1:
			valPivote = (v[izq] + v[der]) / 2;
			break;
		default:
			valPivote = (v[izq] + v[(der + izq) / 2] + v[der]) / 3;
		}
		return valPivote;
	}

	
	public static void main(String[] args) {
		double[] numeros = {8, 5, 6, 7, 1, 8, 5};
//		pruebaInsercion(numeros);
		System.out.println();
		numeros = new double[] {8, 5, 6, 7, 1, 8, 5};
		pruebaBurbuja(numeros);
		
		
		
		
//		numeros = new double[] {8, 5, 6, 7, 1, 8, 5};
//		compara(numeros);
//		
//		System.out.println("------------------------");
//		numeros = new double[] {8, 8, 7, 6, 6, 5, 1};
//		compara(numeros);
//		
//		System.out.println("------------------------");
//		numeros = new double[] {1, 5, 6, 6, 7, 8, 8, };
//		compara(numeros);
		
//		System.out.println("------------------------");
//		final int CANT = 50_000;
//		double[] otro = creaVector(CANT);
//		Arrays.sort(otro);
//		System.out.println(new DecimalFormat("###,###,###,###").format(otro.length)  + " elementos aleatorios");
//		compara(otro);
		
//		long[][] resultados = new long[5][3];
//		for (int i = 0; i < resultados.length; i++) {
//			resultados[i] = comparaQuickSorts(creaVector(10_000 * (int)Math.pow(10, i)));
//		}
//		
//		System.out.printf("\n%12s\t%10s\t%10s\n", "nro elem.", "qS recur", "qs lib");
//		for (int i = 0; i < resultados.length; i++) {
//			System.out.printf("%12s\t%10d\t%10d\n", new DecimalFormat("###,###,###,###").format(resultados[i][0]), resultados[i][1], resultados[i][2]);
//		}
	}
	
	
	public static void compara(double[] vec) {
		System.out.println();
		double[] numeros = vec.clone();
		double[] numerosOrdenado = vec.clone();
		int iter;
		long t0, tf;
		
		Arrays.sort(numerosOrdenado);
		
		if(vec.length < 100) Util.mostrarVector(numeros);
		t0 = System.currentTimeMillis();
		iter = seleccion(numeros);
		tf = System.currentTimeMillis();
		System.out.println("Seleccion: " + new DecimalFormat("###,###,###,###").format(iter) + " it. En " + (tf - t0) + " ms.");
		if(vec.length < 100) Util.mostrarVector(numeros);
		System.out.println(Arrays.equals(numerosOrdenado, numeros));
		
		numeros = vec.clone();
		if(vec.length < 100) Util.mostrarVector(numeros);
		t0 = System.currentTimeMillis();
		iter = seleccionDoble(numeros);
		tf = System.currentTimeMillis();
		System.out.println("Seleccion doble: " + new DecimalFormat("###,###,###,###").format(iter) + " it. En " + (tf - t0) + " ms.");
		if(vec.length < 100) Util.mostrarVector(numeros);
		System.out.println(Arrays.equals(numerosOrdenado, numeros));

		numeros = vec.clone();
		if(vec.length < 100) Util.mostrarVector(numeros);
		t0 = System.currentTimeMillis();
		iter = insercion(numeros);
		tf = System.currentTimeMillis();
		System.out.println("Insercion: " + new DecimalFormat("###,###,###,###").format(iter) + " it. En " + (tf - t0) + " ms.");
		if(vec.length < 100) Util.mostrarVector(numeros);
		System.out.println(Arrays.equals(numerosOrdenado, numeros));
		
		numeros = vec.clone();
		if(vec.length < 100) Util.mostrarVector(numeros);
		t0 = System.currentTimeMillis();
		iter = burbuja(numeros);
		tf = System.currentTimeMillis();
		System.out.println("Burbuja: " + new DecimalFormat("###,###,###,###").format(iter) + " it. En " + (tf - t0) + " ms.");
		if(vec.length < 100) Util.mostrarVector(numeros);
		System.out.println(Arrays.equals(numerosOrdenado, numeros));
		
		numeros = vec.clone();
		if(vec.length < 100) Util.mostrarVector(numeros);
		t0 = System.currentTimeMillis();
		quickSort(numeros);
		tf = System.currentTimeMillis();
		System.out.println("QuickSort: " + (tf - t0) + " ms.");
		if(vec.length < 100) Util.mostrarVector(numeros);
		System.out.println(Arrays.equals(numerosOrdenado, numeros));
		
		numeros = vec.clone();
		if(vec.length < 100) Util.mostrarVector(numeros);
		t0 = System.currentTimeMillis();
		Arrays.sort(numeros);
		tf = System.currentTimeMillis();
		System.out.println("QuickSort Libreria: " + (tf - t0) + " ms.");
		if(vec.length < 100) Util.mostrarVector(numeros);
		System.out.println(Arrays.equals(numerosOrdenado, numeros));
	}
	
	public static long[] comparaQuickSorts(double[] vec) {
		double[] numeros = vec.clone();
		long t0, tf;
		long[] resu = new long[3];
		resu[0] = vec.length;
		
		numeros = vec.clone();
		t0 = System.currentTimeMillis();
		quickSort(numeros);
		tf = System.currentTimeMillis();
		resu[1] = (tf-t0);
		
		numeros = vec.clone();
		t0 = System.currentTimeMillis();
		Arrays.sort(numeros);
		tf = System.currentTimeMillis();
		resu[2] = (tf-t0);
		
		return resu;
	}
	
	public static double[] creaVector(int cant){
		double[] v = new double[cant];
		Random r = new Random();
		for (int i = 0; i < cant; i++) {
			v[i] = r.nextInt(cant);
		}
		return v;
	}

}
