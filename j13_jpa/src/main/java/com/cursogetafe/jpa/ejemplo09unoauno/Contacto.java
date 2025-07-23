package com.cursogetafe.jpa.ejemplo09unoauno;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="contacto")
public class Contacto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContacto;
	private String nombre;
	private String apellidos;
	private String apodo;
	
	//esto indica que la relacion es uno a uno
	@OneToOne
	@JoinColumn(name="iddomicilio")
	private Domicilio dom;
	public int getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Domicilio getDom() {
		return dom;
	}
	public void setDom(Domicilio dom) {
		this.dom = dom;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idContacto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return idContacto == other.idContacto;
	}
	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", nombre=" + nombre + ", apellidos=" + apellidos + ", apodo="
				+ apodo + ", dom=" + dom + "]";
	}
	
	
}
