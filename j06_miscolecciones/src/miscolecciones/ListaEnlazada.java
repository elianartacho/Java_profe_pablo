package miscolecciones;

//es una estructura dinamica

public class ListaEnlazada implements Lista{
	
	private Nodo primero;
	private Nodo ultimo;
	private int cant;
	

	@Override
	public void agregar(String dato) {
	Nodo nuevo = new Nodo(dato);
	if(primero == null) {
		primero = nuevo;
	}else {
		ultimo.siguente = nuevo;
	}
	
	ultimo = nuevo ;
	cant++;
		
	}

	@Override
	public String eliminar(int pos) {
		
		return null;
	}

	@Override
	public String buscar(int pos) {
		if(pos < 0 || pos >= cant)
		return null;
		
		if(pos == 0)
			return primero.dato;
		
		if(pos == cant -1)
			return ultimo.dato;
		
		return anterior(pos).siguente.dato;
	}
	
	private Nodo anterior(int pos) {
		Nodo aux = primero;
		for(int i = 0; i< pos -1; i++) {
			aux = aux.siguente;
			
		}
		return aux;
	}

	@Override
	public boolean vacia() {
		
		return cant == 0;
	}

	@Override
	public int largo() {
		
		return cant;
	}
	
	// los modificadores de una accesso pueden ser publicas o privadas una clase interna
	//puede ser public,protected, friendly,private tiene los mismos modificadores que los metodos
	
	private class Nodo {
		String dato;
		Nodo siguente;
		
		Nodo (String dato){
			this.dato = dato;
		}
	}

	
}
