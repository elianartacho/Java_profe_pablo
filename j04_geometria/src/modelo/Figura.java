package modelo;

public abstract class Figura {
	
private double y;	
private double x;

public Figura(double x,double y) {
	this.y=y;
	this.x=x;
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


public static Punto centroMasas(Figura... figs) {
	double cmx= 0.0;
	double cmy=0.0;
	double sumaArea = 0;
	for(int i= 0;i< figs.length; i++) {
		sumaArea += figs[i].area();
		cmx= figs[i].area()* figs[i].getX();
		cmy=figs[i].area()* figs[i].getY(); 
			
		}
	double coordX = cmx / sumaArea;
	double coordY = cmy / sumaArea;
	Punto p = new Punto(coordX, coordY);
	
	return p;
	
}

public boolean equals(Object otro) {
	if(otro == null)return false;
	if(this == otro)return true;
	if(this.getClass()!= otro.getClass()) return false;
	Figura otra =(Figura) otro;
	return this.x == otra.x && this.y == otra.y;
}
@Override
public String toString() {
	return "Figura [y=" + y + ", x=" + x + "]";
} 


}
