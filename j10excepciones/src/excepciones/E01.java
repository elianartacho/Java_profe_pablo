package excepciones;

import java.io.FileReader;

public class E01 {
	// una excepcion es un mecanismo para comunicar que un metodo no a podido hacer su trabajo
	//hay 2 tipos las  RunTimeExceptionds(capturables)(and chached) y el 
	//resto IOException (no capturables)(cached)estoy  obligado a hacer algo con ellas o lo
	//arreglo o la lanzo hacia arrina

	public static void main(String[] args) {
		
		//es un metodo para leer archivos
	//	FileReader R = new FileReader("c:/datos/misdatos.dat");
		
		
		String[] palabras = new String[4];
		try {
			System.out.println(palabras[789]);
		} catch (Exception e) {
			System.err.println("se te fue la mano");
		}
		
		String algo = null;
		System.out.println(algo.toLowerCase());
	}
	
	
}
