package threads;

public class Th03Estados1 {

	public static void main(String[] args)  {
		
		
		Thread th1 = new Thread();
		System.out.println(th1.getState());//new 
		
		
		th1.start();
		System.out.println(th1.getState());//runnable
		
		//nos hemos creado una clase para mandar el hilo a dormir
		ThreadUtil.sleep(200);//ponemos a dormir por 200 ms
		
		System.out.println(th1.getState());//terminated
		
	}
}
