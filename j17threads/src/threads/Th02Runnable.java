package threads;


public class Th02Runnable implements Runnable{

	private String mensaje;
	
	public Th02Runnable(String mensaje) {
		this.mensaje = mensaje;
	}
	
	//run es el unico metodo abtracto de Runnable(en una interfaz funcional) / no tiene que ver con Threads
		public void run() {
		while(true) {
			System.out.println(mensaje);
		}
		
	}

	public static void main(String[] args) {
	
		Th02Runnable h1 = new Th02Runnable("Soy el primero") ;
		//tengo que crear un Thread para usar start
		new Thread(h1).start();
		
		Th02Runnable h2= new Th02Runnable("Soy el segundo") ;
		new Thread(h2).start();
		
		Th02Runnable h3 = new Th02Runnable("Soy el tercero") ;
		new Thread(h3).start();
	}
}
