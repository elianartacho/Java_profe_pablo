package tests;

import modelo.Circulo;
import modelo.Dibujable;
import modelo.Punto;
import modelo.otro.Cliente;

public class test05Interface {
public static void main (String[]arg) {
	Circulo c = new Circulo(1,2,3);
	Cliente cli = new Cliente();
	Punto p = new Punto(4,5.5);
	
	procesaDibs(c,cli,p);
	
}
	public static void  procesaDibs(Dibujable...dibujables) {
		for(int i = 0;i<dibujables.length;i++) {
			dibujables[i].dibujar();
		}
		
	}
	
}
