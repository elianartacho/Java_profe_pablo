package com.cursogetafe.agenda.persistencia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cursogetafe.agenda.modelo.Contacto;
import com.cursogetafe.agenda.util.Contactos;

public class ContactoDaoMem implements ContactoDao{

	//para almacenar contactos y aceder a ellos creamos el almacen con Map
	private Map<Integer,Contacto>almacen;
	private int proximoId;
	
	//creamos un metodo contructor de la clase para inicializar los atributos  
	public ContactoDaoMem() {
		almacen= new HashMap<Integer, Contacto>();
		proximoId = 1;
		cargaInicial();
	}
	
	private void cargaInicial() {
		for(Contacto c : Contactos.generaContactos()) {
			insertar (c);
		}
	}
	
	@Override
	public void insertar(Contacto c) {
		c.setIdContacto(proximoId++);
		almacen.put(c.getIdContacto(), c);
	}

	@Override
	public void actualizar(Contacto c) {
		almacen.replace(c.getIdContacto(), c);
		
	}

	@Override
	public boolean eliminar(int idContacto) {
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
