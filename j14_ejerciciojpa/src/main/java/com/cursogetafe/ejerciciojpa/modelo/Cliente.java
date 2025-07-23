package com.cursogetafe.ejerciciojpa.modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente extends Rol implements Serializable{

	
	private int nroCliente;
	private String categoria;
	
	@ManyToMany
	@JoinTable(name= "clientes_productos",
	//el nombre de la fk que apunta a la tabla clientes
	joinColumns= @JoinColumn(name = "idrol"),
	// el nombre de la relacion inversa
	inverseJoinColumns = @JoinColumn(name = "idProducto"))
	private List<Producto> productos;
	
	public Cliente(){
		setRol("CLIENTE");
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Cliente [nroCliente=" + nroCliente + ", categoria=" + categoria + ", getIdRol()=" + getIdRol()
				+ ", getPersona()=" + getPersona() + ", getIdPersona()=" + getIdPersona() + ", getApellidos()="
				+ getApellidos() + "]";
	}
	
	
}
