package com.cursogetafe.jpa.ejemplo03insertables;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Entity
@Table(name ="persona_04")
public class Persona03 implements Serializable {

	@Id //le estoy diciendo que es el valor por el que va a buscar
	//le estoy indicando que la tabla la id es autoincremental y que es la pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	private String apellidos;
	private String apodo;
	private String nombre;
	private String dni;
	
	@Embedded
	//esto vale para que los datos en la tabla insertadas sean siempre los mismos
	@AttributeOverride(name = "tipoVia", column = @Column(name ="tipovia"))
	@AttributeOverride(name = "codigoPostal", column = @Column(name ="codigopostal"))
	private Domicilio domicilio;
	
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
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
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
		Persona03 other = (Persona03) obj;
		return idPersona == other.idPersona;
	}
	@Override
	public String toString() {
		return "Persona03 [idPersona=" + idPersona + ", apellidos=" + apellidos + ", apodo=" + apodo + ", nombre="
				+ nombre + ", dni=" + dni + ", domicilio=" + domicilio + "]";
	}
	
	
}
