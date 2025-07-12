package ejercicios.ejercicios05;

public class Ej04 {
//	Crea un método que determine si un número es "perfecto", es decir, si la suma de sus
//	divisores propios es igual al número mismo. Los divisores propios de un número son los
//	divisores positivos menores que él (sin incluir al número), por ejemplo, los divisores propios
//	de 6 son: 1, 2 y 3. Además la suma de los divisores propios de 6 es igual a 6, entonces 6 es un
//	número perfecto. (1 + 2 + 3 = 6). Números perfectos para probar: 6, 28, 496, 8_128,
//	33_550_336.
	
	public static boolean numeroPerfecto(int num ) {
		int suma = 0;
		
		for(int i = 1; i < num;i++) {
	
			if(num % i == 0) {
				suma+=i;
			}
			
		}
	
		if(num == suma) {
			return true;
		}else {
			return false;
		}
	
	} 
		
	
	
		public static void main(String[]arg) {
	
			System.out.println(numeroPerfecto(496));
	
	} 
	
}
