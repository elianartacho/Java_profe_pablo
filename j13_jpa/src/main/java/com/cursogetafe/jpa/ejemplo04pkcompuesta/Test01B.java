package com.cursogetafe.jpa.ejemplo04pkcompuesta;

import com.cursogetafe.j13_jpa.config.Config;

import jakarta.persistence.EntityManager;

public class Test01B {

	public static void main(String[] args) {
		EntityManager em = Config.getEmf().createEntityManager();
		 Persona4B p = em.find(Persona4B.class, new DniB(12121212, 'A'));
				 
			System.out.println(p);	 
			
			Persona4B nuevo = new Persona4B (new DniB(1234,'Z'),"otromas");
			
			//iniciotransaccion
			em.getTransaction().begin();
			
			//persiste el objeto lo hace persistente
			em.persist(nuevo);
			
			//se graba la transaccion
			em.getTransaction().commit();
	}
}
