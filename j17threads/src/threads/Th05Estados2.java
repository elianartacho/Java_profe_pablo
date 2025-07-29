package threads;

import java.util.concurrent.locks.Lock;

public class Th05Estados2 {

	public static void main(String[] args) {
		
		Object lock = new Object();

		// hilo estado waiting
		Thread th1 = new Thread(() -> {
			synchronized (lock) {
				try {
					lock.wait();// espera indefinida hasta que otro hilo ejecute notifyne o 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});
		
		//hilo dormido
		Thread th2 = new Thread (()->{
		ThreadUtil.sleep(5000);	
	
		});
		
		th1.start();
		th2.start();
		
		System.out.println(th1.getName()+ ": "+ th1.getState());
		System.out.println(th2.getName()+ ": "+ th2.getState());
	}
}
