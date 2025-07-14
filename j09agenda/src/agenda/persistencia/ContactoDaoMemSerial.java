package agenda.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import agenda.modelo.Contacto;
import agenda.util.Contactos;

public class ContactoDaoMemSerial implements ContactoDao{
	//almacen: Es un HashMap que guarda los contactos, usando el ID como clave y el Contacto como valor.
	private Map<Integer,Contacto>almacen;

	//proximoId: Es el número que se usará como ID del próximo contacto que se inserte.
	private int proximoId;
	
	//FICH_ALM: Nombre del archivo que almacenará los contactos (almacen.dat).
	private final String FICH_ALM = "almacen.dat";

	//FICH_ID: Nombre del archivo que guarda el último ID (id.dat), para seguir numerando bien al reiniciar.
	private final String FICH_ID ="id.dat";
	
	
	//creamos un metodo contructor de la clase para inicializar los atributos  
	public ContactoDaoMemSerial() {
	//	almacen= new HashMap<Integer, Contacto>();
	//	proximoId = 1;
	//	cargaInicial();
		leerFicheros();
	}
	//Este método añade unos contactos de prueba al iniciar, si no había datos guardados.
	// Usa una clase auxiliar Contactos.generaContactos() (tú la debes tener). Luego los guarda con grabar().
	private void cargaInicial() {
		for(Contacto c : Contactos.generaContactos()) {
			insertar (c);
		}
		grabar();
	}
	
	//lee de archivo binario el HasMap y el ultimo id guardado
	private void leerFicheros() {
		try(FileInputStream fisAlm = new FileInputStream(FICH_ALM);
				FileInputStream fisId= new FileInputStream(FICH_ID)){

			//crea dos objetos para deserializar (convertir de bytes a objetos java)
			ObjectInputStream oisAlm = new ObjectInputStream(fisAlm);
			ObjectInputStream oisId = new ObjectInputStream(fisId);
			
			//deserializa en un Map y leemos el ultimo id introducido y el ultimo cliente
		almacen=(Map<Integer, Contacto >) oisAlm.readObject();
		proximoId = (Integer)oisId.readObject();
		
		//Si no existen los archivos, los crea desde cero (mapa vacío + ID = 1) y ejecuta cargaInicial()
		}catch(FileNotFoundException e) {
			almacen= new HashMap<Integer, Contacto>();
			proximoId=1;
			cargaInicial();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	//
	//guarda el HasMap y el ID actual en archivos
	private void grabar() {
		try(FileOutputStream fosAlm = new FileOutputStream(FICH_ALM);
				FileOutputStream fosId = new FileOutputStream(FICH_ID)
						){
			ObjectOutputStream cosAlm= new ObjectOutputStream(fosAlm);
			ObjectOutputStream cosId = new ObjectOutputStream(fosId);

			//guarda el mapa con los contactos
			cosAlm.writeObject(almacen);

			//guarda el ultimo id usado
			cosId.writeObject(proximoId);
			
						}catch(IOException e) {
							e.printStackTrace();
							throw new RuntimeException();
							}
		
	}
	
	
	//Asigna un ID nuevo al contacto.Lo guarda en el Map.
	//Luego llama a grabar() para guardar los cambios en disco.
	@Override
	public void insertar(Contacto c) {
		c.setIdContacto(proximoId++);
		almacen.put(c.getIdContacto(), c);
		grabar();
	}

	//Reemplaza el contacto existente con el mismo ID por uno nuevo.
	//Graba los cambios en disco.
	@Override
	public void actualizar(Contacto c) {
		almacen.replace(c.getIdContacto(), c);
		grabar();
	}

	//limina el contacto por su ID.Graba los cambios.
	//Devuelve true si se eliminó, false si no existía.
	@Override
	public boolean eliminar(int idContacto) {
		Contacto eliminado =almacen.remove(idContacto);
		grabar();
		 return almacen.remove(idContacto) != null;
		//if(almacen.containsKey(almacen)) {
		//	almacen.remove(idContacto);
		//	return true;
	//	}else {
	//		return false;
	//	}	
		
	}


	@Override
	public boolean eliminar(Contacto c) {
		if(almacen.containsValue(c)) {
			almacen.remove(c);
			return true;
		}else {
			return false;
		}
	}
	//Devuelve el contacto con ese ID, o null si no existe.
	@Override
	public Contacto buscar(int idContacto) {
		
		return almacen.get(idContacto);
	}

	//Devuelve un conjunto con los contactos cuyo nombre, apellidos o apodo contienen
	// la cadena buscada (sin distinguir mayúsculas).
	@Override
	public Set<Contacto> buscar(String cadena) {
		cadena = cadena.toLowerCase();
		Set<Contacto> resu = new HashSet<Contacto>();
		for(Contacto contacto :almacen.values()) {
			if(contacto.getApellidos().toLowerCase().contains(cadena)
					|| contacto.getApodo().toLowerCase().contains(cadena)
					|| contacto.getNombre().toLowerCase().contains(cadena)) {
				resu.add(contacto);
			}
		}
		return resu;
	}

	//Devuelve todos los contactos almacenados, como un conjunto (Set).
	@Override
	public Set<Contacto> buscarTodos() {
		
		return new HashSet<Contacto> (almacen.values());
	}

	
	
}
