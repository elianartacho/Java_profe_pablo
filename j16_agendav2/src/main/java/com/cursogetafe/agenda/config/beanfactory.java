package com.cursogetafe.agenda.config;

import com.cursogetafe.agenda.negocio.Agenda;
import com.cursogetafe.agenda.negocio.AgendaImpl;
import com.cursogetafe.agenda.persistencia.ContactoDAOJpa;
import com.cursogetafe.agenda.persistencia.ContactoDao;
import com.cursogetafe.agenda.persistencia.ContactoDaoJDBC;
import com.cursogetafe.agenda.persistencia.ContactoDaoMem;
import com.cursogetafe.agenda.persistencia.ContactoDaoMemSerial;

public class beanfactory {

	public static ContactoDao getContactoDao() {
		String tipDao = Config.getProp().getProperty("dao");
		return switch (tipDao) {
		case "mem" -> new ContactoDaoMem(); 
		case "serial" -> new ContactoDaoMemSerial();
		case "jdbc" -> new ContactoDaoJDBC();
		default -> new ContactoDAOJpa();
		};
			
	}
	
	public static Agenda getAgenda() {
		String negocio = Config.getProp().getProperty("negocio");
		return switch (negocio) {
		default -> new AgendaImpl();
			
		};
	}
}
