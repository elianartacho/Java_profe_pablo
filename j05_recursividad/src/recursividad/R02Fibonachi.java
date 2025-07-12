package recursividad;

public class R02Fibonachi {

		public static void main (String[]arg) {
			System.out.println(fibonachi(10));
			
			
		}
		//se llama a si misma es recursiva 
		
		public static int fibonachi(int num) {
			
			if(num <= 1) {
				return num;
			
			}
			return fibonachi(num - 1)+fibonachi(num -2);
			
		}
		
}
