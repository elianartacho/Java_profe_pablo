package threads.productorconsumidor;

import java.util.LinkedList;
import java.util.Queue;

import threads.ThreadUtil;

public class ThPC01 {

	//internamente se organiza con likedList
	private static final Queue<Integer> buffer = new LinkedList<Integer>();
	//el valor maximo permitido
	private static final int CAPACIDAD = 5;
	//va a ir almacenando los valores
	private static int valor = 0;
	
	public static void main(String[] args) {
		//metodos de una cola
		Runnable productor = () -> {
			while(true) {
				ThreadUtil.sleep();
				if (buffer.size() < CAPACIDAD) {
					buffer.offer(valor);
					System.out.println(Thread.currentThread().getName()+ " produjo" + valor);
					valor++;
					
					if(buffer.size() > CAPACIDAD) {
						System.err.println("Error se produjeron "+ buffer.size());
						//sino termina en cero tuvo un problema
						System.exit(1);
					}
				}
				
			}
		};
		Runnable consumidor = ()-> {
		while(true) {
			ThreadUtil.sleep();
			if(buffer.size()> 0) {
				int v =buffer.poll();
			System.out.println(Thread.currentThread().getName()+ " consumio "+ v);
			
			
			if(buffer.size()< 0) {
				System.err.println("Error el tamaño del bufer" + buffer.size());
				System.exit(1);
			}
			}
		}	
		};
		new Thread(productor, "productor").start();
		new Thread(consumidor, "consumidor").start();
	}
}
