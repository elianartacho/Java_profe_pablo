package String;

public class PruebasStringBuilder {
	
public static void main (String[]arg) {
	StringBuilder sb = new StringBuilder("Hola ");
	
	sb.append("que tal");
		
	System.out.println(sb);
	
	String cadena ="hola ";
	cadena = cadena +" que tal";
	
	System.out.println(cadena);
	
}
}
