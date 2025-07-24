package com.cursogetafe.agenda.modelo;


import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "contactos")
public class Contacto implements Comparable<Contacto>, Cloneable, Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcontactos")
	private int idContacto;
	private String nombre;
	private String apellidos;
	private String apodo;
	
	//aqui indico que es un agregado un insertado
	@Embedded
	//esto indica como se llaman estos atributos en mi tabla de bbdd porque asi domicilio me vale para otra bbdd
	//si pongo directamente el @column en domicilio no me valdria luego la clase domicilio
	//y no podria utilizarla
	@AttributeOverride(name = "tipoVia",column = @Column(name = "tipo_via"))
	@AttributeOverride(name = "codigoPostal",column = @Column(name = "codigo_postal"))
	private Domicilio dom;
	
	@ElementCollection
	@CollectionTable(name = "telefonos", joinColumns = {@JoinColumn(name = "fk_contacto")})
	@Column(name = "telefono")
	private Set<String> telefonos;
	
	//esto indica que es una coleccion ,como se llama la tabla y la columna de telefono
	@ElementCollection
	@CollectionTable(name = "correos", joinColumns = {@JoinColumn(name = "fk_contacto")})
	@Column(name = "correo")
	private Set<String> correos;
	
	
	public Contacto() {
		telefonos = new LinkedHashSet<String>();
		correos= new LinkedHashSet<String>();
		dom = new Domicilio();
	}
	
	
	public Contacto(int idContacto, String nombre, String apellidos, String apodo, Domicilio dom) {
		
		//hace una lllamada al constructor por defecto que el anterior
		this();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.dom = dom;
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
	public Domicilio getDom() {
		return dom;
	}
	public void setDom(Domicilio dom) {
		this.dom = dom;
	}
	public Set<String> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Set<String> telefonos) {
		this.telefonos = telefonos;
	}
	//metodo para recibir un array de datos como lista de valores y lo guardo en el set 
	public void addTelefonos (String... telefonos) {
		for(String telefono: telefonos) {
			this.telefonos.add(telefono);
		};
	}
	
	public Set<String> getCorreos() {
		return correos;
	}
	public void setCorreos(Set<String> correos) {
		this.correos = correos;
	}
	
	public void addCorreos (String... correos) {
		for(String correo :correos) {
			this.correos.add(correo);
		}
	}
	
	
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellidos=" + apellidos + ", apodo=" + apodo + ", dom=" + dom
				+ ", telefonos=" + telefonos + ", correos=" + correos + ", idContacto=" + idContacto + "]";
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

    //para definir( el orden natural) en exte caso elegimos por por id 
	@Override
	public int compareTo(Contacto c) {
		
		return this.idContacto -c.idContacto;
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Contacto (idContacto, nombre,apellidos,apodo,dom);
	}
}
