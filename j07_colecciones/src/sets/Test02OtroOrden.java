package sets;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test02OtroOrden {
	
public static void main(String[] args) {
	
	Set<String> set = new TreeSet<String>(new StringComparatorCantLetras());
	
	
	set.add("una");
	set.add("dos");
	set.add("tres");
	set.add("cuatro");
	set.add("cinco");
	set.add("AS");
	set.add("ZAPATO");
	set.add("Avila");
	set.add("ágil");
	
		for(String s :set) {
		System.out.println(s);
		}
	
	//ordena por largo de la palabra de mayor a menor
		Set<String> set02 = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare (String o1,String o2) {
				return o2.length() - o1.length();
			}
		});
		//cargar el set o2 con los valores que tiene cargado set
		set02.addAll(set);
		for(String s : set02) {
			System.out.println(s);
		}
		
	} 
}
