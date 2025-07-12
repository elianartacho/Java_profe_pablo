package interfaces;

public class TestInterFaces {

		public static void main(String[] args) {
			//un objeto de una clase que implemente Ej..
			
			EjemploInterfaz INormal = new EjemploInterfaz(){

				@Override
				public void procesa(String str) {
					System.out.println("desde procesa" + str);
				}

				@Override
				public int otroProceso() {
					
					return 2025;
				}
				
			};
			
			//esto es lo mismo lo de abajo hace lo mismo
			INormal.procesa("hola que tal");
			System.out.println(INormal.otroProceso());
			
			MiInterfazFuncional iFuncional = new MiInterfazFuncional() {

				@Override
				public void hacerAlgo() {
					System.out.println("haciendo algo");
					
				}
			};
			
			iFuncional.hacerAlgo();
			
			//podemos usar una expresion lambda
			//-> es lo wque indica una operacion lambda operador flecha
			
			MiInterfazFuncional iFuncional2 = () -> {System.out.println("soy hace algo desde lambda");};
			
			iFuncional2.hacerAlgo();
		}
}
