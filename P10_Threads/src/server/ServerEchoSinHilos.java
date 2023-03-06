package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEchoSinHilos {

	private int puerto = 23;
	
	public ServerEchoSinHilos() {
		iniciar();
	}
	
	public ServerEchoSinHilos(int puerto) {
		this.puerto = puerto;
		iniciar();
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
	
	private void iniciar() {
		
		try(ServerSocket server = new ServerSocket(puerto)){
			
			System.out.println("Socket abierto en el puerto " + puerto);
			System.out.println("Esperando conexiones...");
			while(true) {
				Socket cli = server.accept();
				new AtiendeCliente(cli);
			}
			
		} catch (IOException e) {
			System.err.println("No se pudo abrir el puerto " + puerto);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerEchoSinHilos();
	}
	
	private class AtiendeCliente {
		
		private Socket socket;
		
		AtiendeCliente(Socket socket){
			this.socket = socket;
			inicia();
		}
		
		public void inicia() {
			System.out.println("Nuevo cliente conectado");
			
			try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
					out.println("Hola! Bienvenido al server tontaco!");
					
					String leido;
					while((leido = in.readLine()) != null) {
						out.println("SRV: " + leido);
					}
					
			} catch (IOException e) {
				System.out.println("error!");
			}
		}
	}
}
