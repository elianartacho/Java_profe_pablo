package recursividad;

public class Ej02 {

	public static void main(String[]arg) {
		System.out.println(sumaNatural(3));
		
	}
	
	public static int sumaNatural (int num) {
		//S = n(n+1)/2. 
		
		return num *(num+1)/2;
		
	}
}
