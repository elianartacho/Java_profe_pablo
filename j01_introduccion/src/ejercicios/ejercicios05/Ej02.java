package ejercicios.ejercicios05;

//Crea un programa que intercambie los valores de dos variables sin usar una variable temporal.

public class Ej02 {
	
	public static void main (String []arg) {
		int a = 99;
		int b= 10;
		
		int resultado = a + b ;
		b = resultado - 10 ;
		a = resultado - b;
		
		
		System.out.println("a = "+a +""+ "+ b= "+b);
	}
	
	
	
	
}
