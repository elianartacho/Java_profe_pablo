package com.cursogetafe.ejemplo12muchosamuchos;

import com.cursogetafe.j13_jpa.config.Config;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import jakarta.persistence.EntityManager;

public class Test01 {

	public static void main(String[] args) {
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		Jugador j = em.find(Jugador.class, 5);
		System.out.println(j);
		
		System.out.println(j.getEquipos());//carga los equipos
	}
}
