package excepciones;

import java.sql.SQLDataException;
import java.sql.SQLException;

public class E03 {
	public static void main(String[] args) throws SQLException {
		metodo(-5);
	}

	public static void otroMetodo(int num) {
		try {
			problematico(num);
		} catch (SQLException e) {
			// esto es el arreglo del problema con lo que pongo en el catch
			System.out.println("Esto areregla el problema");
			e.printStackTrace();
		}
		
		
		otroMetodo(66);
		
		
	}
	
	//cuando un metodo no sabe como arreglar la exception lo lanza hacia arriba
	public static void metodo(int num) throws SQLException {
		problematico(num);
		System.out.println("todo fenomenal");
		
	}
	
	//una excepcion es un objeto
	//la diferencia entre la ioexception y la sql solo el nombre descriptivo
	//si creamos una excepcion hereda de quien queramos exception
	
	public static void problematico(int valor) throws SQLException {
		if(valor == 0)
			throw new IllegalArgumentException();
		if(valor < 0) {
			throw new SQLException();
		}
	}
	
}
