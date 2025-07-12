package recursividad;

//Suma de los dígitos de un número natural.
public class Ej04 {

	public static void main (String[]arg) {
		
		System.out.println(suma(2502445));
	}
	
	public static int suma(int num) {
		if(num/10 < 1) {
			return num;
		}
		return num%10 + suma(num/10);
		
	}
}
