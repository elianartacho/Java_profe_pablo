package Arrays;

public class PruebaPrarametroArray {

	public static int suma(int n1,int n2) {
		return n1 +n2;
	}
	public static int suma(int n1,int n2, int n3) {
		return n1 +n2 + n3;
	}
	
	public static int suma (int... nums) {
		int suma = 0;
		for(int i= 0;i< nums.length; i++) {
			suma += nums[i];
		}
		return suma;
	}
	
	
	
	public static void main (String[]arg) {
		System.out.println(suma(3,4));
		System.out.println(suma(5,6));
		
		int[] numeritos= {1,5,4,7,8};
		
		System.out.println(suma(numeritos));
	}
}
