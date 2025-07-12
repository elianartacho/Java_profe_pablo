package interfaces;

public interface EjemploInterfaz {
	
	static int numerito =34;
	
	//antes de java 8 solo existian metodos abstractos en una interfaz
	//java 8 incorpora metodos estaticos  default
	//java 11 incorpora metodos private
	
	
	//Metodos abstractos
	void procesa(String str);
	int otroProceso();
	
	//Metodos default
	//cuanquier clase que implemente esta interface recibe los metodos y si quiere lo sobreescribe
	
	default void haceAlgo() {
		System.out.println("soy un metodo default");
		
	}
	
	//metodo static
	static void metodoEstatico() {
		System.out.println("yo soy estatico");
	}
	
	//metodo private
	private String metodoPrivado() {
		
		return "soy privado";
	}
	
	default void metodoDefaultUsaPrivate() {
		System.out.println(metodoPrivado());
	}
	
	//metodo private static
	private static String metodoStaticPrivate() {
		return "soy privado y estatico";
		
	}
	
	static void metodoStaticUsaPrivate() {
		System.out.println(metodoStaticPrivate());
	}
	
	
}
