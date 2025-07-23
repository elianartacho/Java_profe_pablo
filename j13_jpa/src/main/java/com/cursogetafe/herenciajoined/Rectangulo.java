package com.cursogetafe.herenciajoined;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "rectangulo_02")
public class Rectangulo extends Figura{
	
	//nombramos la columna como se llama en la tabla de la bbdd
	@Column(name = "l1")
	private double lado1;
	
	@Column(name = "l2")
	private double lado2;
	
	public Rectangulo() {}
	
	public double getLado1() {
		return lado1;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}
	
@Override
public double area() {
	
	return lado1 * lado2;
}

@Override
public double perimetro() {
	return 2*(lado1 * lado2);
}

	
	
public Rectangulo(double x,double y,double lado1, double lado2) {
	super(x,y);
	this.lado1=lado1;
	this.lado2=lado2;
	
}


@Override
public String toString() {
	return "Rectangulo [lado2=" + lado2 + ", lado1=" + lado1 + ", getX()=" + getX() + ", getY()=" + getY() + "]";
}	


}
