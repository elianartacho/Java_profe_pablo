package com.cursogetafe.jpa.ejemplo04pkcompuesta;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Table;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
//indica el nombre de la tabla
@Table(name= "persona_03")

public class Persona4B implements Serializable {

	
	@EmbeddedId
	private DniB dni;;
	
	
	private String nombre;
	
	
	public Persona4B() {}
	
	




	public Persona4B(DniB dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}






	public DniB getDni() {
		return dni;
	}


	public void setDni(DniB dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona4B other = (Persona4B) obj;
		return Objects.equals(dni, other.dni);
	}


	@Override
	public String toString() {
		return "Persona4B [dni=" + dni + ", nombre=" + nombre + "]";
	}
	
	


	
}
