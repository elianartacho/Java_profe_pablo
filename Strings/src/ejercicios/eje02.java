package ejercicios;

import java.util.Scanner;
// Ejercicio 2: Pedir al usuario una palabra y decir si empieza por "h" o no.
public class eje02 {
	
	public static  void main(String[]arg) {
		System.out.println(cadena());
		

	}

	
	public static String cadena() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe una palabra");
		String palabra = teclado.nextLine();
	
		String resultado;
		if(palabra.startsWith( "H") || palabra.startsWith("h") ) {
			
			resultado = "Empieza por h";
		}else {
			resultado= "No empieza por h";
			
		}
		
		return resultado;
	}
	
}
