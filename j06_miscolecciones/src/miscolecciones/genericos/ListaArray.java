package miscolecciones.genericos;

public class ListaArray <T> implements Lista <T>{
	
	private Object[]almacen;
	private int cant;
	
	//los constructores se tienen que llamar como la clase 
	public ListaArray() {
		this(10);
		
	}

	public ListaArray(int tamayo) {
	
		almacen =  new Object[tamayo];
		
	}
	
	@Override
	public void agregar(T dato) {
		if(almacen.length == cant) 
			redimensionar();
		
		almacen [cant++]= dato;
		
	}

	@Override
	public T eliminar(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T buscar(int pos) {
		if(pos < 0 || pos>= cant )
		return null;
		return (T)almacen[pos];
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
		Object []nuevo = new String[almacen.length * 2];
		for(int i = 0; i < almacen.length;i++) {
			nuevo[i] = almacen[i];
		}
		almacen = nuevo;
	}

	
	

}
