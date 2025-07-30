package threads.productorconsumidor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import threads.ThreadUtil;

public class ThPC03 {

	

	//el valor maximo permitido
	private static final int CAPACIDAD = 5;
	
	//tenemos una collecion con el comportamiento de una cola que esta preparada para sincronizar hilos y tiene una capacidad
	private static final LinkedBlockingQueue<Integer> buffer = new LinkedBlockingQueue<Integer>(CAPACIDAD);
	
	//Tiene metodos que me da el valor y incrementa en una sola operacion es atomica es un metod sincronizado
	private static AtomicInteger valor = new AtomicInteger();
	
	private static final int CANT_PROD = 3;
	private static final int CANT_CONS = 7;
	
	private static final Object LOCK =new Object();
	
	public static void main(String[] args) {
		
		//le pide los hilos que tu le pongas al sistema operativo
		ExecutorService executor = Executors.newFixedThreadPool(8);
		
		
		//metodos de una cola
		Runnable productor = () -> {
			while(true) {
				ThreadUtil.sleep();
					int v = valor.getAndIncrement();
					//bloquea el hilo sino hay capacidad
					buffer.add(v);
					System.out.println(Thread.currentThread().getName()+ "produjo"+ valor);
					
				
					}
				
			
		};
		Runnable consumidor = ()-> {
		while(true) {
			ThreadUtil.sleep();
			int v;
					try {
						v=  buffer.take();
						System.out.println(Thread.currentThread().getName()+ " consumio "+ v);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
				}
		
			
		};
		for(int i = 1; i <= CANT_PROD;i++) {
			new Thread(productor, "productor").start();
		}
		for(int i = 1; i<= CANT_CONS;i++) {
			new Thread(consumidor, "consumidor").start();
		}
		
	}
}
