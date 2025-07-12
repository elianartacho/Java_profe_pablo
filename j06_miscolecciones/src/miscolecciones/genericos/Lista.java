package miscolecciones.genericos;

//la T significa generico vale para todo

public interface Lista <T>{
	
	void agregar(T dato);
	
	T eliminar(int pos);
	T buscar (int pos);
	
	boolean vacia();
	
	int largo();
	
	
}
