package com.cursogetafe.jpa.ejemplo02columnyenum;



import com.cursogetafe.j13_jpa.config.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Tess01 {

	public static void main(String[] args) {
		
		EntityManager em = Config.getEmf().createEntityManager();
		Persona02 p = em.find(Persona02.class,7);
		System.out.println(p);
		
		Persona02 nuevo = new Persona02 ("Garcia Lorca","Federico",0);
		nuevo.setGenero(Genero.MASC);
		
		//iniciamos la transacion y la graba
		em.getTransaction().begin();
		em.persist(nuevo);
		em.getTransaction().commit();
		
		em.close();
	}
}
