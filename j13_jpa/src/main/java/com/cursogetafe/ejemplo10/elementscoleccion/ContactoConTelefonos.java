package com.cursogetafe.ejemplo10.elementscoleccion;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="contacto")
public class ContactoConTelefonos implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContacto;
	private String nombre;
	private String apellidos;
	private String apodo;
	
	//en este caso seria la solucion pero normalmente no porque hace el produsto cartesiano
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name ="telefonos", joinColumns = {@JoinColumn(name ="idcontacto")})
	@Column(name = "telefono")
	
	private Set<String> telefonos;
	
	
	
	public Set<String> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Set<String> telefonos) {
		this.telefonos = telefonos;
	}
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
		ContactoConTelefonos other = (ContactoConTelefonos) obj;
		return idContacto == other.idContacto;
	}
	@Override
	public String toString() {
		return "ContactoConTelefonos [idContacto=" + idContacto + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", apodo=" + apodo + ", telefonos=" + telefonos + "]";
	}
	
	
}
