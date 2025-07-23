package com.cursogetafe.ejemplo11muchosauno;

import com.cursogetafe.j13_jpa.config.Config;

import jakarta.persistence.EntityManager;

public class Test01 {

	public static void main(String[] args) {
		EntityManager em = Config.getEmf().createEntityManager();
		
		Partido p = em.find(Partido.class, 4);
		System.out.println(p);
		
		
	}
}
