package com.cursogetafe.ejemplo07herenciasingletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue ("CIRCULO")
public class Circulo02 extends Figura02 {
	
	public Circulo02() {}

	@Column(name="r")
	private double radio;

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public Circulo02 (double x,double y, double radio) {
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
		return "Circulo02 [radio=" + radio + "]";
	}

	
	
	

}
