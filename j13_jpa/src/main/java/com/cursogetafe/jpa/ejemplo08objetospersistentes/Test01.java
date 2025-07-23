package com.cursogetafe.jpa.ejemplo08objetospersistentes;



import com.cursogetafe.j13_jpa.config.Config;
import com.cursogetafe.jpa.ejemplo01mapeosimple.Persona;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Test01 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Config.getEmf();
		
		EntityManager em = emf.createEntityManager();
		
	
		Persona p = em.find(Persona.class, 12);
		if(p != null) 
			System.out.println(p);
		else
			System.out.println("este tio no existe");
		
			p.setApodo("TioMolesto");
			
		Persona nueva = new Persona("Ape nuevo", "nombre nuevo",0);
		
		em.getTransaction().begin();
		//persist cambia de estado a los objetos y lo hace persistir
		em.persist(nueva);
		em.getTransaction().commit();
		
			em.close();
	}
}
