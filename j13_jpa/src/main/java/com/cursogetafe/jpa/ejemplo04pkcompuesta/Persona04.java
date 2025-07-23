package com.cursogetafe.jpa.ejemplo04pkcompuesta;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
//indica el nombre de la tabla
@Table(name= "persona_03")
@IdClass(Dni.class)
public class Persona04 implements Serializable {

	//esto mapea indicando que es la id
	@Id
	private int nroDoc;
	
	@Id
	private char letraDoc;
	private String nombre;
	
	
	public Persona04() {}


	public Persona04(int nroDoc, char letraDoc, String nombre) {
		super();
		this.nroDoc = nroDoc;
		this.letraDoc = letraDoc;
		this.nombre = nombre;
	}


	public int getNroDoc() {
		return nroDoc;
	}


	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}


	public char getLetraDoc() {
		return letraDoc;
	}


	public void setLetraDoc(char letraDoc) {
		this.letraDoc = letraDoc;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public int hashCode() {
		return Objects.hash(letraDoc, nroDoc);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona04 other = (Persona04) obj;
		return letraDoc == other.letraDoc && nroDoc == other.nroDoc;
	}


	@Override
	public String toString() {
		return "Persona04 [nroDoc=" + nroDoc + ", letraDoc=" + letraDoc + ", nombre=" + nombre + "]";
	}
	
	
}
