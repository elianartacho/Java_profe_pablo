package String;

public class StringVsBuilder {

	public static void main (String[]arg) {
		String s ="";
		StringBuilder sb = new StringBuilder(); 
		
		long t0,tf;
		
		t0 = System.currentTimeMillis();
		for(int i = 1;i <= 400_000;i++) {
			s += "a";
		}
		tf= System.currentTimeMillis();
		System.out.println("String: "+ (tf - t0));
		
		
	
		t0 = System.currentTimeMillis();
		for(int i = 1;i <= 400_000;i++) {
			sb.append("a") ;
		}
		tf= System.currentTimeMillis();
		System.out.println("StringBuilder: "+ (tf - t0));
	}
}
