package threads.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class ServidorChat {
private int puerto;

	public ServidorChat(int puerto) {
		this.puerto = puerto;
	}
	
	//aqui esta escuchando el servidor
	public void start() {
		
		System.out.println("servidor esperando conexiones");
		try (ServerSocket server = new ServerSocket(puerto)){
			while(true) {
				//el objeto socket me devuelve la conexion
				Socket cliente = server.accept();
				new AtiendeCliente(cliente);
			}
		} catch (IOException e) {
			System.err.println("no se puede abrir el puerto" + puerto);
		}
	}
	//se ejecuta el constructor
	public class AtiendeCliente implements Runnable{
		
		private Socket socket;
		private String user;
		private PrintWriter out;
		
		//hay uno para todos
		private static int cant;
		private static Map<String, AtiendeCliente>sala = new HashMap<>();
		
		public AtiendeCliente(Socket socket) {
			this.socket = socket;
			
			//esta linea lanza un nuevo hilo
			new Thread(this).start();
		}

		@Override
		public void run() {
		
			log("nuevo cliente conectado");
			//conexion cliente - servidor
			try(PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
				//forma de leer
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
				
				this.out = out;
				out.println("Bienvenido al nuevo wasap");
				
				
				out.println("por favor indentificate");
				//para recibir por teclado el usuario
				user = in.readLine();
				user = user.replaceAll(" ", " _ ");
				
				while(sala.containsKey(user)|| user.length() == 0) {
					out.println("este usuario no existe");
					out.println("ingresa tu usuario");
					user = in.readLine();
					user = user.replaceAll(" ", " _ ");
				}
				
				out.println(user + "ya estas en la sala");
				sala.put(user, this);
				cant++;
				log(user + " se a conectado");
				log("hay " + cant + " Usuarion en la sala");
				help();
				difusion( "SRV: "+ user + "se ha conectado");
				
				String linea;
				boolean sesion = true;
				while (sesion &&(linea = in.readLine()) != null) {
					if(linea.length() > 0 && linea.charAt(0) == '@') {
						if(linea.contains(" ")) {
							String usrDestino = linea.substring(1,linea.indexOf(" "));
							String mensaje = linea.substring(1,linea.indexOf(" ") + 1);
							if(sala.containsKey(usrDestino)) {
								sala.get(usrDestino).out.println("privade de "+ user + " :" + mensaje);
							}else {
								out.println(usrDestino + "no esta conectado");
							}
								
						}else {
							out.println("formato incorrecto, no se ha enviado mensaje");
						}
						
					}else {
						//no es un mensaje privado
						switch(linea.toLowerCase()) {
						case "-w", "who":
							for(String usr : sala.keySet()) {
								out.println("SRV: " + usr);
							}
						break;
						case "-h", "help":
							help();
						break;
						case "-q", "-quiet":
							out.println("SRV "+ "hasta la vista baby!!");
							sala.remove(user);
							cant--;
							difusion("SRV " +user + "se a desconectado");
							log(user + "se ha desconectado");
							sesion = false;
							socket.close();
							break;
						default:
							difusion(user + " : " +linea);
						}
					}
					
				}		
				
				}catch (IOException e) {
						e.printStackTrace();
					}
		}
		private void log (String mje) {
			System.out.println(now()+ "-"+ mje);
		}
		
		//representa la fecha
		private String now () {
			//me da la fecha y hora actual
			LocalDateTime ahora = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
			return dtf.format(ahora);
		}
		
		private void difusion(String mje) {
			for(AtiendeCliente cli : sala.values()) {
				cli.out.println(mje);
			}
		}
		private void help() {
			out.println("ayuda de wsap");
			out.println("----------------------");
			out.println("-q terminar sesion");
			out.println("-h mostrar esta ayuda");
			out.println("-w consultar usuarios");
			out.println("@Usuario mensaje: para mensajes privados");
			out.println("----------------------");
			
			
		}
	}
	public static void main(String[] args) {
		new ServidorChat(1234).start();
	}
	
}
