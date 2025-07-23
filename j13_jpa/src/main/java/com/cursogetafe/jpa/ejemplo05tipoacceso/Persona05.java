package com.cursogetafe.jpa.ejemplo05tipoacceso;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
//le indicamos el nombre de tabla sino es igual sino no hace falta
@Table(name = "persona")

public class Persona05 implements Serializable {
	
	
	private int idPersona;
	private String apellidos;
	private String apodo;
	private String nombre;
	private String dni;
	
	public Persona05() {
		System.out.println("muestrame el constructor por defecto");
	};

	public Persona05(String apellidos, String nombre, int idPersona) {
		super();
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.idPersona = idPersona;
	}
	
	//el conjunto de guetters y setters son properties
	//el metedo correcto es hacerlo aqui el mapeo
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		System.out.println("setId()");
		this.idPersona = idPersona;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		System.out.println("setApellidos()");
		this.apellidos = apellidos;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		System.out.println("setApodo()");
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
	
	@Transient
	public String getNombreCompleto() {
		return nombre + " " + apellidos; 
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
		Persona05 other = (Persona05) obj;
		return idPersona == other.idPersona;
	}
	@Override
	public String toString() {
		return "Persona [apellidos=" + apellidos + ", apodo=" + apodo + ", nombre=" + nombre + ", dni=" + dni
				+ ", idPersona=" + idPersona + "]";
	}

	
	
		
	
	
	
}
