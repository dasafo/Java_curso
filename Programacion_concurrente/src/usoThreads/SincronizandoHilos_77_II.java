package usoThreads;

public class SincronizandoHilos_77_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HilosVarios2 hilo1=new HilosVarios2();
		HilosVarios3 hilo2=new HilosVarios3(hilo1);

		hilo2.start(); //este hilo no comenzara hasta que no termine el 1(ver clase HilosVarios3)
		
		
		hilo1.start();		
		
		
		System.out.println("Tareas terminadas");

	}

}


class HilosVarios2 extends Thread{
	
	public void run() {
		
		for(int i=0;i<15;i++) {
			
			System.out.println("Ejecutando hilo " + getName()); //getName para que nos indique el hilo que se ejecuta
		
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
}


class HilosVarios3 extends Thread{
	
	public HilosVarios3(Thread hilo) {
		
		this.hilo=hilo;
		
		
	}
	
	public void run() {
		
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i=0;i<15;i++) {
			
			System.out.println("Ejecutando hilo " + getName()); //getName para que nos indique el hilo que se ejecuta
		
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	private Thread hilo;
	
}
