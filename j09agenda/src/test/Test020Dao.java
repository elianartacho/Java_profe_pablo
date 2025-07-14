package test;

import agenda.modelo.Contacto;
import agenda.persistencia.ContactoDao;
import agenda.persistencia.ContactoDaoMem;

public class Test020Dao {

	public static void main(String[] args) {
		ContactoDao dao = new ContactoDaoMem();
		
		
		//sentencias lamda
		dao.buscarTodos().forEach(System.out::println);
		
		//buscar porel apodo
		dao.buscar("al").forEach(System.out::println);
		System.out.println();
		
		System.out.println(dao.buscar(44));
		System.out.println();
		
		Contacto buscado = dao.buscar(88);
		buscado.setApellidos("nuevo apellido");
		buscado.setApodo("Cabezon");
		dao.actualizar(buscado);
		
		buscado = dao.buscar(88);
		System.out.println(buscado);
		
		//llamada a metodo para eliminar
		dao.eliminar(88);
		System.out.println(dao.buscar(88));
	}
}
