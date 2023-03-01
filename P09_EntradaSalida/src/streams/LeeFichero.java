package streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeeFichero {
	
	public static void main(String[] args) {
		
		String fichero = "/Curso/Figura.txt";
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(fichero));
			String linea = br.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
		} catch(FileNotFoundException e) {
			System.out.println("fichero no encontrado");
		} catch(IOException e) {
			System.out.println("no se puede leer");
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch(IOException e) {
					System.out.println("problemas al cerrar");
				}
			}
		}
	}
}
