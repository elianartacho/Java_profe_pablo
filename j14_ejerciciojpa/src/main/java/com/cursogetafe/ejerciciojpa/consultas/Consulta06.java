package com.cursogetafe.ejerciciojpa.consultas;



import java.util.LinkedList;
import java.util.List;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;
import com.cursogetafe.ejerciciojpa.modelo.ClienteCategoria;
import com.mysql.cj.x.protobuf.MysqlxResultset.FetchSuspendedOrBuilder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta06 {

	public static void main(String[] args) {
		
			cantClientesPorCategoria().forEach(System.out::println);
		}
		
		public static List<ClienteCategoria> cantClientesPorCategoria(){
			
			//conexion a la base de datos consultar ,eliminar,insertar el Entity manager
			EntityManager em = Config.getEmf().createEntityManager();
			
			//quiero obtener una lista de el Objeto cliente categoria y para eso llamo al constuctor dento de la select
			String jpql ="select new com.cursogetafe.ejerciciojpa.modelo.ClienteCategoria (c.categoria, count(c.idRol)) from Cliente c group by c.categoria " ;	
			TypedQuery<ClienteCategoria> q =em.createQuery(jpql,ClienteCategoria.class);
			
			return q.getResultList();
			
			
		}
		
		public static List<ClienteCategoria> cantClientesPorCategoriaManual(){
			EntityManager em = Config.getEmf().createEntityManager();
			
			String jpql ="select count(c.idRol),c.categoria from Cliente c group by c.categoria " ;	
			TypedQuery<Object[]> q =em.createQuery(jpql,Object[].class);
			
			List<Object[]> objetos = q.getResultList();
			
			List<ClienteCategoria> resu = new LinkedList<>();
			
			for(Object[] array :objetos) {
				resu.add(new ClienteCategoria((String)array[1] , (Long)array[0]));
					
			}
			return resu;
		}
}
