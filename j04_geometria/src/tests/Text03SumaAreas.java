package tests;
import modelo.Figura;
import modelo.Rectangulo;

public class Text03SumaAreas {

	public static double sumAreas(Figura... figs) {
		int suma = 0;
		for(int i= 0;i< figs.length; i++) {
			suma += figs[i].area();
				
			}
			return suma;
		

	}
	
	public static void main (String[]arg) {
		Rectangulo r1 = new Rectangulo(1,2,3,4);
		Rectangulo r2= new Rectangulo(1,2,3,4);
		
	//Figura[] figs=	{r1 , r2};
	
		
		System.out.println(sumAreas(r1,r2));
		
	}
}
