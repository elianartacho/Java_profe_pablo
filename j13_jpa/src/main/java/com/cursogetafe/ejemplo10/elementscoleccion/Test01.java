package com.cursogetafe.ejemplo10.elementscoleccion;



import com.cursogetafe.j13_jpa.config.Config;

import jakarta.persistence.EntityManager;

public class Test01 {

	public static void main(String[] args) {
		EntityManager em = Config.getEmf().createEntityManager();
		
		ContactoConTelefonos c = em.find(ContactoConTelefonos.class,10);
		System.out.println(c.getApellidos()+" " + c.getNombre());
		
		
		
		System.out.println(c.getIdContacto());
		System.out.println(c.getApellidos());
		
		System.out.println("y ahora accedo a los telefonos"); 
		System.out.println(c.getTelefonos());
		
		
		em.close();
	}
}
