package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Th06EcuacionSegundoGrado {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		double a = 1;
		double b = -3;
		double c = 2;
		
		//Calcular b al cuadrado
		//lanza un hilo y hace el calculo
		CompletableFuture<Double> bCuadrado = CompletableFuture.supplyAsync(()-> {
			ThreadUtil.sleep(3000);
			System.out.println("Calculando bCuadrado");
			return b* b;
			});
		
		//Calcular 4 * c
		CompletableFuture<Double> cuatroAC = CompletableFuture.supplyAsync(()-> {
			ThreadUtil.sleep(4000);
			System.out.println("Calculando 4ac");
			return 4 * a * c;
			});
		//vamos a calcular el discrimandte que es el resultado de los b^2 - 4ac
		// A aCuadrado lo combinamos con cuatroAC .Esa operacion se realizara cuando los dos hayan finalizado
		//Usar thenCombine y le pasaremosuna Bifuntion
		
		CompletableFuture<Double> discriminante = bCuadrado.thenCombine(cuatroAC,(b2,ac4) -> {
			ThreadUtil.sleep(1000);
			System.out.println("Clalculando Discriminante");
			return b2 - ac4;
		});
		
		//vamos a calcular la raiz del discriminante
		//si el discriminate es menor que 0 lanzamos una excepcion
		CompletableFuture<Double> raizDiscriminante = discriminante.thenApply(d -> {
			ThreadUtil.sleep();
			if(d < 0) 
				throw new RuntimeException("Discriminate negativo : no hay raices reales");
				System.out.println("Calculando raiz del discriminante");
				return Math.sqrt(d);
			
		});
		
		CompletableFuture<Double> menosB = CompletableFuture.supplyAsync(()-> {
			ThreadUtil.sleep(500);
			System.out.println("Claculando -b");
			return -b;
		});
		CompletableFuture<Double> dosA= CompletableFuture.supplyAsync(()-> {
			ThreadUtil.sleep(750);
			System.out.println("Claculando 2a");
			return 2* a;
		});
		
		//calcular x1 ((-b * raiz(discri)/ 2a)
		//combinar menosB con raizDiscriminante y al resultado (cuando termine)
		CompletableFuture<Double> x1 = menosB.thenCombine(raizDiscriminante, (mB,raiz)-> {
			ThreadUtil.sleep(500);
			return mB + raiz;
		}).thenCombine(dosA, (num, dA)-> num / dA);
		//aqui usamos(return ) una sola intrucion que es bifuntion despues del .
		
		//calcular x2 ((-b * raiz(discri)/ 2a)
		//combinar menosB con raizDiscriminante y al resultado (cuando termine)
		CompletableFuture<Double> x2 = menosB.thenCombine(raizDiscriminante, (mB,raiz)-> {
			ThreadUtil.sleep(500);
			return mB - raiz;
		}).thenCombine(dosA, (num, dA)-> num / dA);
		
		System.out.println("x1  = "+ x1.get());
		System.out.println("x2  = "+ x2.get());
		
	}
}
