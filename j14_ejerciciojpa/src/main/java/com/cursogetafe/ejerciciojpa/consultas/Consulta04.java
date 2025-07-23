package com.cursogetafe.ejerciciojpa.consultas;



import java.awt.Window.Type;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta04 {

	public static void main(String[] args) {
		//buscar clientes de una categoria determinada
		String categoria = "VIP";
		String producto ="disco";
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		//c.productos hace referencia al atributo productos que tenemos en cliente y asi hacemos la relacion
		//por medio del objeto cliente 
		//solo puedo aceder a los atributos de mi objeto
		String jpql = "select c from Cliente c join c.productos p where c.categoria= :cat and p.producto like :prod";
		
		//creamos el objeto query
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		
		//parametros a los que pertenece
		q.setParameter("cat", categoria);
		
		//igual que en sql %producto% que contenga disco
		q.setParameter("prod", "%" + producto + "%" );
		
		//recorremos el resultado y mostramos los clientes con sus productos
		q.getResultList().forEach(c ->{
								System.out.println(c);
								System.out.println(c.getProductos());
							} );
		
	
		
	}
}
