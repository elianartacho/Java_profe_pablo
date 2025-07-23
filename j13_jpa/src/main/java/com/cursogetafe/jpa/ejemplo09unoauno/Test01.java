package com.cursogetafe.jpa.ejemplo09unoauno;



import com.cursogetafe.j13_jpa.config.Config;

import jakarta.persistence.EntityManager;

public class Test01 {

	public static void main(String[] args) {
		EntityManager em = Config.getEmf().createEntityManager();
		
		Contacto c = em.find(Contacto.class,9);
		
		Domicilio d =em.find(Domicilio.class,3);
		
		System.out.println(c);
		System.out.println(d.getContacto());
	}
}
