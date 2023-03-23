package es.cursogetafe.banco.presentacion;

import java.util.Scanner;

import es.cursogetafe.banco.negocio.BancoNegocioInterface;

public class BancoVista implements BancoVistaInterface{
	
	private BancoNegocioInterface bancoNegocio;
	
	public BancoVista(){
	}

	public void iniciarAplicacion() 
	{
		Scanner teclado = new Scanner(System.in);

		System.out.println("TRANSFERENCIA");

		System.out.print("Dni destino:");
		long dni1 = Long.parseLong(teclado.nextLine());

		System.out.print("Dni origen:");
		long dni2 = Long.parseLong(teclado.nextLine());

		System.out.print("Cantidad a transferir:");
		double cantidad = Double.parseDouble(teclado.nextLine());

		System.out.println("----------- INICIO TRANSFERECIA ------");
		bancoNegocio.transferencia(dni1, dni2, cantidad);
		System.out.println("----------- FIN TRANSFERECIA ------");
		teclado.close();
	}
	// ----------- Getters y setters ------------------
	public BancoNegocioInterface getBancoNegocio() {
		return bancoNegocio;
	}
	public void setBancoNegocio(BancoNegocioInterface bancoNegocio) {
		this.bancoNegocio = bancoNegocio;
	}
}
