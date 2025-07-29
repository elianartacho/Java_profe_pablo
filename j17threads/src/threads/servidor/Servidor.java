package threads.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
private int puerto;

	public Servidor(int puerto) {
		this.puerto = puerto;
	}
	
	public void start() {
		
		System.out.println("servidor esperando conexiones");
		try (ServerSocket server = new ServerSocket(puerto)){
			while(true) {
				Socket cliente = server.accept();
				new AtiendeCliente(cliente);
			}
		} catch (IOException e) {
			System.err.println("no se puede abrir el puerto" + puerto);
		}
	}
	
	public class AtiendeCliente implements Runnable{
		//representa la conexion con el cliente me la devuelve como un objeto socket
		private Socket socket;
		
		public AtiendeCliente(Socket socket) {
			this.socket = socket;
			new Thread(this).start();
		}

		@Override
		public void run() {
			//para mostrar por teclado
			try(PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
					//para introducir por teclado
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
				
				out.println("Bienvenido al servidor tonto eli");
				
				String linea;
				while ((linea = in.readLine()) != null) {
					out.println("SRV: " + linea);
				}
				
				}catch (IOException e) {
						e.printStackTrace();
					}
		}
		
	}
	public static void main(String[] args) {
		new Servidor(1234).start();
	}
	
}
