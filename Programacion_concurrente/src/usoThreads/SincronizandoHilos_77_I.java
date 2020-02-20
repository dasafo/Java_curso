/*****************************************************************************
 * - Los hilos o threads se usan para crear un programa que pueda realizar
 * varias tareas simultaneamente(multitask). Hasta ahora todos nuestros
 * programas era monotarea.
 * 
 * - Pasos a seguir:
 * 
 * 	1) Crear una clase que implemente la I_Runnable --> M_run()
 * 
 * 	2) Escribir el codigo de la tarea dentro del M_run()
 * 	
 * 	3) Instanciar la clase creada y almacenar la instancia
 * 		en una variable tipo Runnable	
 * 	
 * 	4) Crear instancia de la C_Thread pasando como parametro
 * 		al constructor de Thread el objeto Runnable anterior
 * 	
 * 	5) Poner en marcha el hilo de ejecución con el M_start() de C_Thread
 * 
 *****************************************************************************/
/*
 * HAcemos un programa que recorra primero un hilo y despues el siguiente
 */

package usoThreads;

public class SincronizandoHilos_77_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HilosVarios hilo1=new HilosVarios();
		HilosVarios hilo2=new HilosVarios();

		hilo1.start();
		
		try {
			hilo1.join();	//con join() para indicar que hasta que no termine este hilo1 no comience con el siguiente
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		hilo2.start();
		
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		System.out.println("Tareas terminadas");

	}

}


class HilosVarios extends Thread{
	
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
