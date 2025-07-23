package com.cursogetafe.ejemplo11muchosauno;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "campos")
public class Campo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcampo;
	private String campo;
	private String direccion;
	
	
	public int getIdcampo() {
		return idcampo;
	}
	public void setIdcampo(int idcampo) {
		this.idcampo = idcampo;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idcampo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campo other = (Campo) obj;
		return idcampo == other.idcampo;
	}
	@Override
	public String toString() {
		return "Campo [idcampo=" + idcampo + ", campo=" + campo + ", direccion=" + direccion + "]";
	}
	
	
	
}
