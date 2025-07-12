package modelo;

public class Circulo extends Figura  implements Dibujable{

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
	public boolean equals(Object otro) {
		if(!super.equals(otro))return false;
		Circulo c = (Circulo)otro;
		return this.radio == c.radio;
	}
	@Override
	public String toString() {
		
		return "Circulo = []";
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		System.out.println("dibujando el circulito");
	}
}
