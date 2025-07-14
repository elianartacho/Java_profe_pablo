package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E02LecturaTeclado {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int edad = 0;
		
		System.out.println("Ingresa tu edad");
		 try {
			 // si me posiciono sobre el metodo veo la excepciones en este caco me posiciono sobre tec.nexInt
			 int edad1= tec.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("torpe");
		}
		
		 System.out.println(edad);
		
		
	}
}
