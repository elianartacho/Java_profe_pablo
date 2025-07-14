package excepciones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

public class E04 {

	public static void main(String[] args) throws Exception  {
		
	
		try {
			otroProblematico(3);
			
		} finally {
			//finally hace que se ejecute haya o no error
			System.out.println("esto si o si se tiene que ejecutar");
		}
		}
		
		
	
	public static void metodo2() {
		try {
			otroProblematico(0);
			//el parametro que se le pasa elchach es el nombre de la exception y un nombre si no da error en este caso e
		} catch (FileSystemNotFoundException e) {
			// arregla filenot
			
		} catch(IOException e) {
			//arregla IO
			
		}catch(NegativeArraySizeException e) {
			//arregla array index
			
		}catch(RuntimeException e) {
			//arregla runtime
		}
	}
	
	public static void metodo1() throws IOException{
		try {
			otroProblematico(0);
		} catch (FileNotFoundException e ) {
			
		}
	}
		
		public static void metodo3() {
			try {
				otroProblematico(0);
			} catch (Exception e) {
				// arreglo cualquier excepcion CUIDADO!!
			}
		}
		
		
		//si tengo 2 excepciones le pongo una e al final solo una
		public static void metodo4() {
			try {
				otroProblematico(0);
			} catch (ArrayIndexOutOfBoundsException  | FileNotFoundException e) {
				//arregla array o file
			}catch(RuntimeException  | IOException e) {
				//arregla run  o io
			}
		}
	
	
	public static void otroProblematico(int num) throws FileNotFoundException,IOException  {
		switch(num) {
		case 1:
			throw new ArrayIndexOutOfBoundsException();
		case 2:
			throw new RuntimeException();
		case 3:
			throw new FileNotFoundException();
		case 4 :
			throw new IOException();
		}
	}
}
