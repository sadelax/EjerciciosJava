package streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroAutoCloseable {

	public static void main(String[] args) {
		String fichero = "/Curso/Figura.txt";
		StringBuilder sb = new StringBuilder();
		
		try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
			String linea;
			while((linea = br.readLine()) != null) {
				sb.append(linea + "\n");
				
			}
			
		} catch(IOException e) {
			System.out.println("Esto ha fallado.");
		}
		
		String resu = sb.toString();
			resu.split(";");
			System.out.println();

		System.out.println(resu);
	}
}
