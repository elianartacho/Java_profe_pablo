package ejercicios.ejercicios05;


//Dos números son "amigables" si la suma de los divisores propios de uno es igual al otro. Por
//ejemplo, los divisores propios de 8 son: 1, 2 y 4 y la suma de éstos 1 + 2 + 4 = 7; luego 8 es un
//número amigo de 7. Escribe un método que determine si dos números dados son amigables.


public class Ej05 {

	public static boolean amigables(int num,int num2) {
		int suma = 0;
		for(int i = 1; i < num;i++) {
	
			if(num % i == 0) {
				suma+=i;
			}
		}	
			
		if(suma == num2) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void main (String[]arg) {
		
		System.out.println(amigables(8,7));
		
	}
}
