package recursividad;

public class Ej05 {

	public static void main (String [] arg) {
		System.out.println(fibonachi(11));
		
	}
	
	public static int fibonachi(int num) {
		
		if(num == 0) {
			return 0;
		}else if(num == 1) {
			return 1;
		}
		return fibonachi(num -1) + fibonachi(num-2);
		
	}
	
}
