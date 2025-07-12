package interfaces;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test02OtroOrden {
	
public static void main(String[] args) {
	
	//Un TreeSet siempre espera un coparator
//	Set<String> set = new TreeSet<String>(new Comparator<String>() {
		
//		@Override
//		public int compare (String o1,String o2) {
//			return o2.length() - o1.length();
//		}
//	});
	
	
	//esto sustituye al anterior
	
	//Set<String>set = new TreeSet<String>((String o1, String o2) -> {
	//		return o2.length() - o1.length();
//});
	
	
	//Esto sustituye al anterior
	//asi es reducido si el cuerpo de mi motodo  solo tiene una linea sino como el anterior
	Set<String>set = new TreeSet<String>(( o1, o2) ->  o2.length() - o1.length());
	
	set.add("una");
	set.add("dos");
	set.add("tres");
	set.add("cuatro");
	set.add("cinco");
	set.add("AS");
	set.add("ZAPATO");
	set.add("Avila");
	set.add("ágil");
	
	//tiene el mismo funcionamiento que el siguiente
		set.forEach((s) -> System.out.println(s));
	
		//for(String s :set) {
	//	System.out.println(s);
	//	}
		
	} 
}
