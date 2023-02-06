package ejercicios07;

public class Ej01 {
	public static void matrix(double[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
//	public static void main(String[] args) {
//		int[][] m = {{1,2,3},{4,5,6},{7,8,9},{9,9,9}};
//		int[][] matriz = new int[4][3];
//		matriz[0][0] = 1;
//		matriz[0][1] = 2;
//		matriz[0][2] = 3;
//		matriz[1][0] = 4;
//		matriz[1][1] = 5;
//		matriz[1][2] = 6;
//		matriz[2][0] = 7;
//		matriz[2][1] = 8;
//		matriz[2][2] = 9;
//		matriz[3][0] = 9;
//		matriz[3][1] = 9;
//		matriz[3][2] = 9;
//		matriz[0] = new int[] {1,2,3};
//		matriz[1] = new int[] {1,2,3};
//		matrix(m);
//		System.out.println();
//		matrix(matriz);
//	}
}
