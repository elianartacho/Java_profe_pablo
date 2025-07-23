package com.cursogetafe.ejerciciojpa.consultas;



import java.awt.Window.Type;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta05 {

	public static void main(String[] args) {
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		//el fetch hace que lo carge en la misma consulta y tenga un comportamiento iguer que es que me cargue todos los atributos
		//incluidos los relacionados con otras tablas , si no tendria el comportamiento por defecto y cargaria primero todos los clientes 
		//y luego las persona una a una.
		
		
		//Busca todos los clientes con todos sus datos que por defecto estan en modo eager
		//No carga los productos(lazy)
		//Para cargar los datos de la persona, realiza una consulta por cada idRol
		String jpql1 = "select c from Cliente c ";
		
		
		//Realiza una consulta con join a personas con todos los datos
		//no carga los productos (lazy)
		String jpql2 = "select c from Cliente c join fetch c.persona ";
		
		
		//Realiza una sola consulta de clientes join roles join personas join clientes_productos join productos
		//devuelve los productos en modo eager
		String jpql3 = "select c from Cliente c join fetch c.persona left join fetch c.productos ";
		
		
		//creamos el objeto query
		TypedQuery<Cliente> q = em.createQuery(jpql3, Cliente.class);
		
		for(Cliente cli : q.getResultList()) {
			System.out.println(cli);
			System.out.println("\t" + cli.getProductos());
		}
		
	
		
	}
}
