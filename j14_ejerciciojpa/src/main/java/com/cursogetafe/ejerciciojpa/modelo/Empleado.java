package com.cursogetafe.ejerciciojpa.modelo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado extends Rol {

	
	private int nroEmpleado;
	
	//relacion
	@ManyToOne
	//foreing key
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;

	public Empleado(){
		setRol("EMPLEADO");
	}
	
	public int getNroEmpleado() {
		return nroEmpleado;
	}

	public void setNroEmpleado(int nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nroEmpleado);
		return result;
	}


	
}
