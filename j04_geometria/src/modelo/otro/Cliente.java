package modelo.otro;

import modelo.Dibujable;

public class Cliente implements Dibujable{
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
private String nombre;
@Override
public void dibujar() {
	// TODO Auto-generated method stub
	System.out.println("dibujando cliente");
}
}
