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

	//para almacenar contactos y aceder a ellos creamos el almacen con Map
	private Map<Integer,Contacto>almacen;
	private int proximoId;
	
	private final String FICH_ALM = "almacen.dat";
	private final String FICH_ID ="id.dat";
	
	
	//creamos un metodo contructor de la clase para inicializar los atributos  
	public ContactoDaoMemSerial() {
	//	almacen= new HashMap<Integer, Contacto>();
	//	proximoId = 1;
	//	cargaInicial();
		leerFicheros();
	}
	
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
			ObjectInputStream oisAlm = new ObjectInputStream(fisAlm);
			ObjectInputStream oisId = new ObjectInputStream(fisId);
			
			//deserializa en un Map y leemos el ultimo id introducido y el ultimo cliente
		almacen=(Map<Integer, Contacto >) oisAlm.readObject();
		proximoId = (Integer)oisId.readObject();
			
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
	
	//guarda el HasMap y el ID actual en archivos
	private void grabar() {
		try(FileOutputStream fosAlm = new FileOutputStream(FICH_ALM);
				FileOutputStream fosId = new FileOutputStream(FICH_ID)
						){
			ObjectOutputStream cosAlm= new ObjectOutputStream(fosAlm);
			ObjectOutputStream cosId = new ObjectOutputStream(fosId);
			
			cosAlm.writeObject(almacen);
			cosId.writeObject(proximoId);
			
						}catch(IOException e) {
							e.printStackTrace();
							throw new RuntimeException();						}
		
	}
	
	
	
	@Override
	public void insertar(Contacto c) {
		c.setIdContacto(proximoId++);
		almacen.put(c.getIdContacto(), c);
		grabar();
	}

	@Override
	public void actualizar(Contacto c) {
		almacen.replace(c.getIdContacto(), c);
		grabar();
	}

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

	@Override
	public Contacto buscar(int idContacto) {
		
		return almacen.get(idContacto);
	}

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

	@Override
	public Set<Contacto> buscarTodos() {
		
		return new HashSet<Contacto> (almacen.values());
	}

	
	
}
