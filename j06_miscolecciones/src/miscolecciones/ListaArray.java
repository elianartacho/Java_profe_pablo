package miscolecciones;

public class ListaArray implements Lista {
	
	private String []almacen;
	private int cant;
	
	//los constructores se tienen que llamar como la clase 
	public ListaArray() {
		this(10);
		
	}

	public ListaArray(int tamayo) {
		almacen = new String[tamayo];
		
	}
	
	@Override
	public void agregar(String dato) {
		if(almacen.length == cant) 
			redimensionar();
		
		almacen [cant++]= dato;
		
	}

	@Override
	public String eliminar(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buscar(int pos) {
		if(pos < 0 || pos>= cant )
		return null;
		return almacen[pos];
	}

	@Override
	public boolean vacia() {
			return cant == 0;
	}

	@Override
	public int largo() {
		
		return cant;
	}
	
	// se redimensiona el array cuando se llena y se duplica
	private void redimensionar() {
		String []nuevo = new String[almacen.length * 2];
		for(int i = 0; i < almacen.length;i++) {
			nuevo[i] = almacen[i];
		}
		almacen = nuevo;
	}

}
