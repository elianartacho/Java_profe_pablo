package threads;

public class Th01Thread extends Thread {

	private String mensaje;
	
	public Th01Thread(String mensaje) {
		this.mensaje = mensaje;
	}
	
	//es un metodo definido en la clase thread para ejecutar un nuevo hilo 
	public void run() {
		while(true) {
			System.out.println(mensaje);
		}
		
	}
	//hay 4 hilos al finalizar la operacion
	public static void main(String[] args) {
		//ejecuta el constructor
		Th01Thread h1 = new Th01Thread("Soy el primero") ;
		
		//se lanza el contenido del run en nuevo  hilo 
		h1.start();
		
		Th01Thread h2= new Th01Thread("Soy el segundo") ;
		h2.start();
		
		Th01Thread h3 = new Th01Thread("Soy el tercero") ;
		h3.start();
	}
}
