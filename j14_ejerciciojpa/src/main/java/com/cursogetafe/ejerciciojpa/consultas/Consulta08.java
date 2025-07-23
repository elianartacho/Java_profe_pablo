package com.cursogetafe.ejerciciojpa.consultas;


import java.util.List;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.ClienteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class Consulta08 {

	public static void main(String[] args) {
		comprasDiscos().forEach(System.out::println);
		
	}
	
	public static List<ClienteDTO> comprasDiscos(){
		String producto = "disco";
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		String jpql = "select new com.cursogetafe.ejerciciojpa.modelo.ClienteDTO (c.idRol,c.persona.apellidos, c.categoria,c.nroCliente) from Cliente c join fetch c.productos like :prod";
		
		TypedQuery<ClienteDTO> q =em.createQuery(jpql,ClienteDTO.class);
		q.setParameter("prod", "%" + producto + "%" );
		return q.getResultList();
	}
	
}
