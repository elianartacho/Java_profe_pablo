package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Th04Sincronizacion {

	public static void main(String[] args) {
	//	m1();
		
		//m1 hilos desincronizados
//		Thread th1 = new Thread(()->{
//				while(true) {
//					ThreadUtil.sleep();
//					m1();
//				}
//		});
//		
//		Thread th2 = new Thread(()->{
//			while(true) {
//				ThreadUtil.sleep();
//				m1();
//			}
//	});
//		th1.start();
//		th2.start();
		
//	
//		Thread th1 = new Thread(() -> {
//			while (true) {
//				ThreadUtil.sleep();
//				m1();
//			}
//		});
//
//		Thread th2 = new Thread(() -> {
//			while (true) {
//				ThreadUtil.sleep();
//				m1();
//			}
//		});
//		th1.start();
//		th2.start();

		//
		
//	

	Lock lock = new ReentrantLock();
	Thread th1 = new Thread(() -> {
		while (true) {
			ThreadUtil.sleep();
			m1();
		}
	});

	Thread th2 = new Thread(() -> {
		while (true) {
			ThreadUtil.sleep();
			m1();
		}
	});
	th1.start();
	th2.start();

}
	
	
	//no estan sincronzados
	public static void m1() {
		System.out.println(Thread.currentThread().getName() + " entrando ");
		ThreadUtil.sleep();
		
		System.out.println(Thread.currentThread().getName() + " saliendo ");
		System.out.println("--------------");
	}
	
	//van a estar sincronizados
	public static synchronized void  m2() {
		System.out.println(Thread.currentThread().getName() + " entrando ");
		ThreadUtil.sleep();
		
		System.out.println(Thread.currentThread().getName() + " saliendo ");
		System.out.println("--------------");
	}
	
	public static synchronized void m3(Object lock) {
		// este no esta sincronizado
		System.out.println(Thread.currentThread().getName() + " hace cosas ");

		// estos estaran sincronizados los sincroniza el objeto lock
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + " entrando ");
			ThreadUtil.sleep();

			System.out.println(Thread.currentThread().getName() + " saliendo ");
			System.out.println("--------------");
		}
	}

	public static synchronized void m4(Lock lock) {
		// este no esta sincronizado
		System.out.println(Thread.currentThread().getName() + " hace cosas ");

		// se inicia un lock
		lock.lock();
		System.out.println(Thread.currentThread().getName() + " entrando ");
		ThreadUtil.sleep();

		System.out.println(Thread.currentThread().getName() + " saliendo ");
		System.out.println("--------------");
		lock.unlock();
		// sino se desbloque queda en un lock infinito
	}
	
	
}
