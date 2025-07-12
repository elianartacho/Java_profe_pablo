package sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import modelo.Cliente;

public class Test01TreeSet {

	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
		
		
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
		
		Set<Integer> setNums = new TreeSet<Integer>();
		setNums.add(123);
		setNums.add(889);
		setNums.add(1);
		setNums.add(44);
		setNums.add(1235);
		setNums.add(89);
		
		for(Integer num : setNums) {
			System.out.println(num);
		}
		
		Cliente c1 = new Cliente(15,"Adriana","Jimenez", "Perez");
		Cliente c2 = new Cliente(2,"Juan", "Perez", "Jimenez");
		Cliente c3 = new Cliente(5,"Elisabeth","Martinez","Zamorano");
		
		
		Set<Cliente>setClis = new TreeSet<Cliente>();
		
		setClis.add(c1);
		setClis.add(c2);
		setClis.add(c3);
		
		for(Cliente cli : setClis) {
			System.out.println(cli);
		}
		
		
	}
	
	
	
	
	
	
}
