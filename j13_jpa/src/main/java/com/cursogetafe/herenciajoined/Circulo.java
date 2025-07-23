package com.cursogetafe.herenciajoined;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "circulo_02")
public class Circulo extends Figura {
	
	public Circulo() {}

	@Column(name="r")
	private double radio;

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public Circulo (double x,double y, double radio) {
		super(x, y);
		this.radio= radio;
		
	}
	public double getDiametro() {
		double diametro = 2 * radio;
				return diametro;
	}
	
	@Override
	public double area() {
		return Math.PI * Math.pow(radio,2);
	}
	 
	@ Override
	public double perimetro () {
		return Math.PI * getDiametro();
		
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + "]";
	}
	
	

}
