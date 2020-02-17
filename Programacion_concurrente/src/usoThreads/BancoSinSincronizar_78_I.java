package usoThreads;

import java.util.concurrent.locks.*;

public class BancoSinSincronizar_78_I {

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


class Banco{
	
	public Banco() {
		
		cuentas=new double[100]; //creamos 100 cuentas en el banco
		
		for(int i=0;i<cuentas.length;i++) { //añadimos 2000 euros de entrada para cada cuenta
			
			cuentas[i]=2000;
			
		}
		
		saldoSuficiente=cierreBanco.newCondition(); //ponemos condicion al cierre del codigo(lock unlock), y esa condicion esta relacionada con saldoSuficiente(await) 
		
	}
	
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException { //'throws InterruptedException' es debido a await que nos obliga a lanzar una excepcion y lo podemos metar aqui en vez de usar otroa try catch
		
		cierreBanco.lock(); //lock(semaforo rojo) para bloquear esta parte de código(hasta unlock) para que solo pueda ser leido por un solo hilo(así evitamos superposiciones de hilos en esta parte)
		
		try {
			
		while(cuentas[cuentaOrigen]<cantidad) { //para evitar que la cantidad de dinero transferido de cuentaOrigen sea menor que la cantidad que tiene(numeros rojos)
			
			// System.out.println("--------------CANTIDAD INSUFICIENTE: " + cuentaOrigen + "......SALDO: " + cuentas[cuentaOrigen]+ "......TRASNFERENCIA DE: " + cantidad);
			
			// return;
			
			saldoSuficiente.await(); //cuando se cumple el while, mantenemos a la espera el hilo, 
			
		}/*else {
			
			System.out.println("---------------CANTIDAD OK--------------" + cuentaOrigen);
			
		}*/
		
		
		System.out.println(Thread.currentThread()); //Para que imprima en pantalla el hilo que realiza la tranferencia(un hilo por transferencia)
		
		cuentas[cuentaOrigen]-=cantidad; //restamos a la cuentaOrigen el saldo transferido a cuentaDestino
		
		System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino); //nos infomrma del movimiento
		
		cuentas[cuentaDestino]+=cantidad; //sumamos a cuenta Destino el saldo transferido desde cuentaOrigen
		
		System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal()); //que nos imprima el saldo Total de las cuentas
		
		
		saldoSuficiente.signalAll(); //con esto despierta a todos los hilos q estan a la espera para que puedan hacer la operacion de este hilo(si coincide)
		
		
		}finally {  //ponemos un finally para que esto siempre se ejecute(lo que no pasa con catch, que solo se ejecuta cuando hay excepcion)
			
			cierreBanco.unlock(); //desbloqueamos el codigo para que entre el proximo hilo(semaforo verde)
		}
		
		}
	
	
	public double getSaldoTotal() {
		
		double sumaCuentas=0;
		
		for(double a: cuentas) { //bucle for each(muy util para arrays)
			
			sumaCuentas+=a;
			
		}
		
		return sumaCuentas;
		
	}
	
	
	
	
	private final double[] cuentas;
	
	private Lock cierreBanco=new ReentrantLock(); //para impedir que mas de un hilo lea a la vez una parte del código que eligamos

	private Condition saldoSuficiente; //Para usar Await(hilos a la espera compatibles con la tranferencia que se les pide sin entrar en numeros rojos)

}


class EjecucionTransferencias implements Runnable{
	
	public EjecucionTransferencias(Banco b, int de, double max) {  // 'de' es el numero de la cuenta de origen(entre 0 y 199) y 'max' es la cantidad máxima permitida por transferencia
		
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






