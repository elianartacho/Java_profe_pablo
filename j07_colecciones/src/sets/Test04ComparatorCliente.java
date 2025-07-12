package sets;

import java.util.Set;
import java.util.TreeSet;

import modelo.Cliente;

public class Test04ComparatorCliente {
	
	
	public static void main(String[] args) {
		Cliente c1 = new Cliente(15,"Adriana","Jimenez", "Perez");
		Cliente c2 = new Cliente(2,"Juan", "Perez", "Jimenez");
		Cliente c3 = new Cliente(5,"Elisabeth","Martinez","Zamorano");
		Cliente c4 = new Cliente(8,"Maria","Fernandez","Zamora");
		Cliente c5 = new Cliente(13,"Maria","Fernandez","Zamora");
		
		Set<Cliente>set = new TreeSet<Cliente>();
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(c4);
		set.add(c5);
		
		for(Cliente cliente: set) {
			System.out.println(cliente);
		}
		System.out.println();
		
		//Objeto de una clase que implemente comparator
		Set<Cliente>seto2 = new TreeSet<Cliente>(Cliente.getComparatorApellidos());
		seto2.addAll(set);
		
		for(Cliente cliente : seto2) {
			System.out.println(cliente);
			
		}
		System.out.println();
		
	}
	
	
}
