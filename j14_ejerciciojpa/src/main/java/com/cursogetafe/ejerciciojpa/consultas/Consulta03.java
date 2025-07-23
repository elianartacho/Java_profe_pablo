package com.cursogetafe.ejerciciojpa.consultas;



import java.awt.Window.Type;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta03 {

	public static void main(String[] args) {
		//buscar clientes de una categoria determinada
		String categoria = "ESPORADICO";
		String apellidos ="Ramirez";
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		//:ape es el nombre del parametro que sigunifica apellidos y :cat significa categoria
		String jpql = "select c from Cliente c where c.categoria = :cat and c.persona.apellidos = :ape ";
		
		//creamos el objeto query
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		
		//parametros a los que pertenece
		q.setParameter("cat", categoria);
		q.setParameter("ape", apellidos);
		
		//recorremos el resultado y lo mostramos
		q.getResultList().forEach(System.out::println);
		
		System.out.println("----------");
		
		jpql = "select c from Cliente c where c.categoria = ?1 and c.persona.apellidos = ?2";
		q =em.createQuery(jpql,Cliente.class);
		q.setParameter(1, categoria);
		q.setParameter(2, apellidos);
		
		q.getResultList().forEach(System.out::println);
		
	}
}
