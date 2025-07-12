package modelo;
import modelo.Figura;


public class Punto implements Dibujable {
	
	private double x;
	private double y;
	
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
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
	
	public boolean equals(Object otro) {
		if(otro == null)return false;
		if(this == otro)return true;
		if(this.getClass() != otro.getClass()) return false;
		Punto otra = (Punto)otro;
		return this.x ==otra.x && this.y ==otra.y;
	}
@Override
public String toString() {
	
	return "Punto (" + x +"," +y + ")";}
@Override
public void dibujar() {
	// TODO Auto-generated method stub
	System.out.println("dibujando punto");
}
}