package com.cursogetafe.herenciajoined;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;


@Entity
@Table(name = "figuras02")

//significa herencia y se usa para indicar que es el padre y que tipo de estragia vamos a usar
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Figura implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idFigura;
private double y;	
private double x;

public Figura() {}

public Figura(double x,double y) {
	this.y=y;
	this.x=x;
}


public int getIdFigura() {
	return idFigura;
}

public void setIdFigura(int idFigura) {
	this.idFigura = idFigura;
}

public double getX() {
	return x;
}
public void setX(double x) {
	this.x = x;
}
public double getY() {
	return y;
}
public void setY(double y) {
	this.y = y;
}
public abstract double area();
public abstract double perimetro();

@Override
public int hashCode() {
	return Objects.hash(idFigura);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Figura other = (Figura) obj;
	return idFigura == other.idFigura;
}

@Override
public String toString() {
	return "Figura [idFigura=" + idFigura + ", y=" + y + ", x=" + x + "]";
}





}
