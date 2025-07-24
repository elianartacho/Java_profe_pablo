package com.cursogetafe.agenda.inicio;

import com.cursogetafe.agenda.config.Config;
import com.cursogetafe.agenda.vista.MenuPrincipal;
import com.cursogetafe.agenda.vista.swing.VInicial;

public class Main {

	public static void main(String[] args) {
		String tipoVista = Config.getProp().getProperty("tipovista");
		System.out.println(tipoVista);
		
		
		if(tipoVista.equals("grafico")) 
			new VInicial();
		else
		new MenuPrincipal();
		
	}
}
