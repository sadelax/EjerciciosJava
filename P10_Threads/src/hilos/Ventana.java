package hilos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	
	public Ventana() {
		// no quiero nada en el layout
		setLayout(null);
		setBounds(0, 0, 400, 600);
		setVisible(true);
		// addWindowListener espera un objeto de una clase determinada q se comporte como "oyente"
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Adiósssssssssssssssssssssssssssssssssss!");
				// lo último q sucede es esto:
				System.exit(0);
			}	
		});
	}
	
	public static void main(String[] args) {
		new Ventana();
		int num = 0;
		while(true) {
			//demora
			for(int i = 0; i < 100_000_000; i++);
			System.out.println(num++);
		}
		
	}

}
	