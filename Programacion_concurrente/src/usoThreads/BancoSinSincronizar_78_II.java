
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
 * 	Ejercicio:
 *  - Se crea un banco que abre 100 cuentas con un saldo inicial de 2000€
 *    (200.000€ Totales).
 *  - Se pueden realizar transferencias internas entre las cuentas. Cada 
 *    transferencia se realiza usando un Thread/Hilo.
 *  - El saldo total siempre debería ser el mismo (200.000€). Pero sino 
 *    sincronizamos los Thread veremos que al ir realizando transferencias
 *    entre las cuentas, esta cantidad no es fija. Por lo cual deberemos
 *    sincronizar dichos hilos, con la ayuda de M_ReebtrabtLock de I_Lock  
 */


/*
 * Lo mismo que el 78_I pero usando synchronized(Hereda directamente de Object y 
 * no nos permite mas de una condicion) para sincronizar los hilos del codigo 
 * que bloqueamos y mantenemos a la espera dentro de la 
 * clase TRansferencias(await, lock, unlock.....estos si que nos permitirian 
 * mas de una condicion)
 * */


package usoThreads;

import java.util.concurrent.locks.*;

public class BancoSinSincronizar_78_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Banco b=new Banco();
		
		for(int i=0;i<100;i++) { //para que realice transferencias desde la cuenta 0 hasta la 99
			
			EjecucionTransferencias r=new EjecucionTransferencias(b, i, 2000);
			
			Thread t=new Thread(r); //asignamos un hilo por transferencia
			
			t.start();
			
			
		}
		
		
	}

}


class Banco2{
	
	public Banco2() {
		
		cuentas=new double[100]; //creamos 100 cuentas en el banco
		
		for(int i=0;i<cuentas.length;i++) { //añadimos 2000 euros de entrada para cada cuenta
			
			cuentas[i]=2000;
			
		}
		
		
	}
	
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException { //'throws InterruptedException' es debido a await que nos obliga a lanzar una excepcion y lo podemos metar aqui en vez de usar otroa try catch
		
		
			
		while(cuentas[cuentaOrigen]<cantidad) { //para evitar que la cantidad de dinero transferido de cuentaOrigen sea menor que la cantidad que tiene(numeros rojos)
			
			wait(); //ponemos a la espera el hilo(con synchornized)
			
			
		}
		
		
		System.out.println(Thread.currentThread()); //Para que imprima en pantalla el hilo que realiza la tranferencia(un hilo por transferencia)
		
		cuentas[cuentaOrigen]-=cantidad; //restamos a la cuentaOrigen el saldo transferido a cuentaDestino
		
		System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino); //nos infomrma del movimiento
		
		cuentas[cuentaDestino]+=cantidad; //sumamos a cuenta Destino el saldo transferido desde cuentaOrigen
		
		System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal()); //que nos imprima el saldo Total de las cuentas
				
		notifyAll(); //notificamos a los hilos en espera para ver si 'les interesa' el resultado del hilo saliente de TRansferencia
		
		}
		
		
	
	
	public double getSaldoTotal() {
		
		double sumaCuentas=0;
		
		for(double a: cuentas) { //bucle for each(muy util para arrays)
			
			sumaCuentas+=a;
			
		}
		
		return sumaCuentas;
		
	}
	
	private final double[] cuentas;
	

}


class EjecucionTransferencias2 implements Runnable{
	
	public EjecucionTransferencias2(Banco b, int de, double max) {  // 'de' es el numero de la cuenta de origen(entre 0 y 199) y 'max' es la cantidad máxima permitida por transferencia
		
		banco=b;
		deLaCuenta=de; //cuenta origen
		cantidadMax=max;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	try { //creamos un try catch por usar sleep
		
		while(true) { //true para hacer infinitas transacciones
			
			int paraLaCuenta=(int)(100*Math.random()); //para la cuenta destino numero....
			
			double cantidad=cantidadMax*Math.random();
			
			banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
			
			Thread.sleep((int)(Math.random()*10));
			
		}
		
	}catch(InterruptedException e){}
	
		
	}
	
	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;
	
	
	
	
}






