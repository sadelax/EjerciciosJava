package excepciones;

import java.io.IOException;
import java.sql.SQLException;

public class E05 {
	
	public static void main(String[] args) throws SQLException {
		try {
			abreRecurso(5);
			System.out.println("Se ha abierto correctamente");
			utilizaRecurso(5);
			System.out.println("Se ha utilizado correctamente");
		} catch(IOException e) {
			System.out.println("Fallo en abrir o IOException");
			System.out.println("Arreglado");
		} finally {
			// si se ha abierto:
			try {
				cierraRecurso(5);
				System.out.println("Se ha cerrado correctamente");				
			} catch (IOException e) {
				System.out.println("Fallo en cerrar");
				System.out.println("Arreglado");
				// areglar el problema del cierre
			}
			System.out.println("... Pase lo q pase, siempre leerás esto :)");
		}
		System.out.println("Abierto, utilizado y cerrado correctamente");
	}

	public static void abreRecurso(int num) throws IOException{
		if(num == 0) throw new IOException();
	}
	
	public static void utilizaRecurso(int num) throws IOException, SQLException{
		if(num == 0) throw new IOException();		
		if(num == 1) throw new SQLException();
	}
	
	public static void cierraRecurso(int num) throws IOException{
		if(num == 0) throw new IOException();		
	}
}
