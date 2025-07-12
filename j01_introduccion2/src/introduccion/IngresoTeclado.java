package introduccion;

import java.util.Scanner;

//import java.util.Scanner (declara un alias)

public class IngresoTeclado {
	public static void main(String[] arg) {
		//java.util.Scanner tec;
		//opcion 1 utilizar el nombre canonico
		
		//opcion2 hacer un import 
		//Scanner tec;
		
		//opcion3 que nos ayude java escribimos las primeras letras
		//y te salen la opciones con control+espacio y enter y nos lo pone
		Scanner tec = new Scanner(System.in);
		
		String nombre;
		
		System.out.print("Ingresa tu nombre: ");
		nombre = tec.nextLine();
		
		System.out.println("Hola " + nombre + " Que tal estas? ");
		
		if (nombre.equals("Pablo"))
			System.out.println("Son iguales");
		else
			System.out.println("SON DIFERENTES");
	}
}
