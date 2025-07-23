package com.cursogetafe.ejerciciojpa.consultas;



import java.util.LinkedList;
import java.util.List;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;
import com.cursogetafe.ejerciciojpa.modelo.ClienteCategoria;
import com.cursogetafe.ejerciciojpa.modelo.ClienteDTO;
import com.mysql.cj.x.protobuf.MysqlxResultset.FetchSuspendedOrBuilder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta07 {

	public static void main(String[] args) {
			consultaClientes().forEach(System.out::println);
			
		}
		
		public static List<ClienteDTO> consultaClientes(){
			
			//conexion a la base de datos consultar ,eliminar,insertar el Entity manager
			EntityManager em = Config.getEmf().createEntityManager();
			
			//quiero obtener una 
			String jpql ="select new com.cursogetafe.ejerciciojpa.modelo.ClienteDTO (c.idRol,c.persona.apellidos, c.categoria,c.nroCliente) from Cliente c" ;	
			TypedQuery<ClienteDTO> q =em.createQuery(jpql,ClienteDTO.class);
			
			return q.getResultList();
			
			
		}
		
		
		
}
