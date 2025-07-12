package recursividad;

public class Ej03 {

	public static void main (String[]arg) {
		System.out.println (catidadDigitos(23));
		
	}
	
	public static int catidadDigitos(int num) {
	if(num /10 < 1) {
		return 1;	
	}
	 return 1 + catidadDigitos(num/10);
	}
}