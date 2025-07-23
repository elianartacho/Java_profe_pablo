package com.cursogetafe.jpa.ejemplo09unoauno;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = " domicilio")
public class Domicilio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDomicilio;
	private String tipoVia;
	private String via;
	private int numero;
	private int piso;
	private String puerta;
	private String ciudad;
	
	//mucho ojo con generar el toString de este atributo porque si los dos atributos porque se puede crear una recursividad
	//y dar erros lo se genera en uno en el otro no
	//se coloca el nombre del atributo de la parte contacto en la que hace la relacion
	@OneToOne(mappedBy = "dom")
	private Contacto contacto;
	
	
	public Contacto getContacto() {
		return contacto;
	}
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	public int getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	public String getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getPuerta() {
		return puerta;
	}
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idDomicilio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Domicilio other = (Domicilio) obj;
		return idDomicilio == other.idDomicilio;
	}
	@Override
	public String toString() {
		return "Domicilio [idDomicilio=" + idDomicilio + ", tipoVia=" + tipoVia + ", via=" + via + ", numero=" + numero
				+ ", piso=" + piso + ", puerta=" + puerta + ", ciudad=" + ciudad + "]";
	}
	
	
}
