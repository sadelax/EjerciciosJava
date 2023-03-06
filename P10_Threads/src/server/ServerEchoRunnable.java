package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEchoRunnable {

	private int puerto = 23;
	
	public ServerEchoRunnable() {
		iniciar();
	}
	
	public ServerEchoRunnable(int puerto) {
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
		new ServerEchoRunnable();
	}
	
	private class AtiendeCliente implements Runnable {
		
		private Socket socket;
		
		AtiendeCliente(Socket socket){
			this.socket = socket;
			new Thread(this).start();
		}
		
		public void run() {
			System.out.println("Nuevo cliente conectado");
			
			try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
					out.println("Hola! Bienvenido al server tontaco!");
					
					String leido;
					boolean sesion = true;
					while((leido = in.readLine()) != null && sesion) {
						switch(leido) {
						case "quit":
						case "salir":
						case "adios":
							sesion = false;
							out.println("Hasta la vista baby!!");
							break;
						default:
							System.out.println("SRV: " + leido);
							out.println("SRV: " + leido);
						}
					}
					
			} catch (IOException e) {
				System.out.println("error!");
			}
		}
	}
}
