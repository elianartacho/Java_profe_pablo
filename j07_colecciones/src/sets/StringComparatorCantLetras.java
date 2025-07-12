package sets;

import java.util.Comparator;

//es una herramoenta para definir un orden
public class StringComparatorCantLetras implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		return o1.length() - o2.length();
	}

	
}
