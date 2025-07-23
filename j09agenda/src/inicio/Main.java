package inicio;

import agenda.vista.MenuPrincipal;
import agenda.vista.swing.VInicial;

public class Main {

	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.err.println("debe ejecutar manin consola o main grafico");
			return;
		}
		if(args[0].equals("grafico")) 
			new VInicial();
		else
		new MenuPrincipal();
//		
	}
}
