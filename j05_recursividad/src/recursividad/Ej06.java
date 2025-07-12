package recursividad;

public class Ej06 {
	
	public static void main (String[] arg) {
		System.out.println(potencia(5,3));
		
	}
	
	public static int potencia(int num,int potencia) {
		
		if(potencia == 0) {
			return 1;
		}
		return num * potencia (num,potencia -1);
		
	}
	
}
