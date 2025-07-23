package agenda.modelo;


import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


public class Contacto implements Comparable<Contacto>, Cloneable, Serializable{
	
	private int idContacto;
	private String nombre;
	private String apellidos;
	private String apodo;
	private Domicilio dom;
	private Set<String> telefonos;
	private Set<String> correos;
	
	
	public Contacto() {
		telefonos = new LinkedHashSet<String>();
		correos= new LinkedHashSet<String>();
		dom = new Domicilio();
	}
	
	
	public Contacto(int idContacto, String nombre, String apellidos, String apodo, Domicilio dom) {
		
		//hace una lllamada al constructor por defecto que el anterior
		this();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.dom = dom;
	}



	public int getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	public Domicilio getDom() {
		return dom;
	}
	public void setDom(Domicilio dom) {
		this.dom = dom;
	}
	public Set<String> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Set<String> telefonos) {
		this.telefonos = telefonos;
	}
	//metodo para recibir un array de datos como lista de valores y lo guardo en el set 
	public void addTelefonos (String... telefonos) {
		for(String telefono: telefonos) {
			this.telefonos.add(telefono);
		};
	}
	
	public Set<String> getCorreos() {
		return correos;
	}
	public void setCorreos(Set<String> correos) {
		this.correos = correos;
	}
	
	public void addCorreos (String... correos) {
		for(String correo :correos) {
			this.correos.add(correo);
		}
	}
	
	
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellidos=" + apellidos + ", apodo=" + apodo + ", dom=" + dom
				+ ", telefonos=" + telefonos + ", correos=" + correos + ", idContacto=" + idContacto + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(idContacto);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return idContacto == other.idContacto;
	}

    //para definir( el orden natural) en exte caso elegimos por por id 
	@Override
	public int compareTo(Contacto c) {
		
		return this.idContacto -c.idContacto;
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Contacto (idContacto, nombre,apellidos,apodo,dom);
	}
}
