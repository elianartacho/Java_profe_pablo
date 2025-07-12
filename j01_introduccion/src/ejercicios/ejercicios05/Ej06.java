package ejercicios.ejercicios05;

//Simula el lanzamiento de un dado de 6 caras utilizando números aleatorios.

public class Ej06 {

	public static void main (String[]arg) {
	
		
			double numAleatorio = Math.random();
			double num=  numAleatorio * 6 ;
			
			System.out.println((int) Math.ceil(num));
		}
		
	}
	
	
	
	
	

