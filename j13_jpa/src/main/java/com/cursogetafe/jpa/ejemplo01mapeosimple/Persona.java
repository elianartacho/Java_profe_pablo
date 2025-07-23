package com.cursogetafe.jpa.ejemplo01mapeosimple;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//le indicamos el nombre de tabla sino es igual sino no hace falta
@Table(name = "persona")

public class Persona implements Serializable {
	
	@Id //le estoy diciendo que es el valor por el que va a buscar
	//le estoy indicando que la tabla la id es autoincremental y que es la pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	private String apellidos;
	private String apodo;
	private String nombre;
	private String dni;
	
	public Persona() {};

	public Persona(String apellidos, String nombre, int idPersona) {
		super();
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.idPersona = idPersona;
	}
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return idPersona == other.idPersona;
	}
	@Override
	public String toString() {
		return "Persona [apellidos=" + apellidos + ", apodo=" + apodo + ", nombre=" + nombre + ", dni=" + dni
				+ ", idPersona=" + idPersona + "]";
	}

	
	
		
	
	
	
}
