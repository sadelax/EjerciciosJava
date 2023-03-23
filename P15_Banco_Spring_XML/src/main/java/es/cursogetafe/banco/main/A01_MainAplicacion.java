package es.cursogetafe.banco.main;

import es.cursogetafe.banco.presentacion.BancoVista;
import es.cursogetafe.banco.presentacion.BancoVistaInterface;

public class A01_MainAplicacion {
	public static void main(String[] args) {
		BancoVistaInterface bancoVista = new BancoVista();
		bancoVista.iniciarAplicacion();
	}
}
