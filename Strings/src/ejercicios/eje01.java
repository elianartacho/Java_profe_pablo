package ejercicios;
import java.util.Scanner;

public class eje01 {
	public static  void main(String[]arg) {
		System.out.println(cadena());
		
		
	}
	
	public static String cadena() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe una palabra");
		String palabra = teclado.nextLine();
		String resultado;
		if(palabra.startsWith( "H")) {
			
			resultado = "Empieza por h";
		}else {
			resultado= "No empieza por h";
			
		}
		
		return resultado;
	}
}
