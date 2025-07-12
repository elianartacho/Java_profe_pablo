package ejercicios.ejercicios05;

//Escribe un método que retorne la suma de los dígitos de un número entero (ejemplo: 1234 -
//> 1+2+3+4 = 10).

public class Ej03 {
	public static void main (String[]arg) {
		
		int num=1234;
		int suma = 0;
		
   while(num !=0) {
	
	int numero= num % 10 ;
	suma +=numero;
	num = num/10;
	
	}
	System.out.println("la suma de los numeros es " + suma);
		
    }

}
