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

package usoThreads;
import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads_76_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoRebote(); //instanciamos un objeto para crear un marco
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para que el marco se cierre al darle a salir
		
		marco.setVisible(true); //hacemos visible el marco

	}

}



class PelotaHilos implements Runnable{		//Para crear multitareas(hilos) para que aparezcan varias pelotas a la vez
	
	public PelotaHilos(Pelota unaPelota, Component unComponente) {
		
		pelota=unaPelota;
		componente=unComponente;
		
		
	}
	
	public void run() {
		
		
		System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
		
		// for (int i=1; i<=3000; i++){
		// while(!Thread.interrupted()) { //Mientras no se interrumpa el hilo rebotara sin fin, al contrario que el for de arriba que hace 3000 iteraciones
		while(!Thread.currentThread().isInterrupted()) { //hace lo mismo que el while de arriba
		
		
			pelota.mueve_pelota(componente.getBounds());
			
			componente.paint(componente.getGraphics());
			
			try {
				Thread.sleep(4); //con sleep reatardamos cada accion de este bucle for durante 4 milisengudos(ver API)
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
				// e.printStackTrace();
				// System.out.println("Hilo bloqueado. Imposible su interrupción");
				//System.exit(0);
				Thread.currentThread().interrupt();
				
			}
		}
		System.out.println("Estado del hilo al terminar: " + Thread.currentThread().isInterrupted());

		
	}
	
	private Pelota pelota;
	private Component componente;
	
	
}



//-------------------Movimiento de la pelota------------------
class Pelota{
	
	// Mueve la pelota invirtiendo posicion si choca con limites
	
	public void mueve_pelota(Rectangle2D limites){ //metodo donde caputura las dimensiones de la pantalla que se abre
		
		x+=dx;
		y+=dy;
		
		//Cuando llegue a los limites se cambia el signo para que rebote en xy
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posicion inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
	
}

// Lamina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
	
	//Añadimos pelota a la lamina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	//Pintamos las pelotas
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	//En este ArrayList se irán agregando las diferentes pelotas que se van creando
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//------------Marco con lamina y botones------------------------

class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		setBounds(600,300,400,350); //creamos un marco
		
		setTitle ("Rebotes"); //le ponemos titulo al marco
		
		lamina=new LaminaPelota(); //instanciamos una lamina
		
		add(lamina, BorderLayout.CENTER); //colocamos la lamina en el centro de un BorderLayout
		
		JPanel laminaBotones=new JPanel();
		
		
		//Dibuja el botón de Dale y estan a la escucha(ActionListener) del evento 
		ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				comienza_el_juego(); //El evento consiste en ejecutar esta funcion
			}
			
		});
		
		
		//Dibuja el botón de Salir y estan a la escucha(ActionListener) del evento
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				System.exit(0); //el evento consiste en salir
				
			}
			
		});
		
		//Dibuja el botón de Detener
	ponerBoton(laminaBotones, "Detener", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				detener();
			}
			
		});
		
		
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	//Ponemos botones
	
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
		JButton boton=new JButton(titulo);
		
		c.add(boton);
		
		boton.addActionListener(oyente);
		
	}
	
	//Añade pelota y la bota 1000 veces
	
	public void comienza_el_juego (){ 
		
		/*cada vez que se pulsa al boton Dale! se crea una pelota 
		 * que le asocia al hilo Thread la variable T. Por eso cuando le
		 * damos a parar solo nos parará el último de los hilos(o pelotas).
		 * Si queremos que nos pare determinada pelota, lo vemos en UsoThreads_76_II  
		*/		
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			
			Runnable r=new PelotaHilos(pelota, lamina);
			
			// Thread t=new Thread(r);
			t=new Thread(r);
			
			t.start(); //start llama al metodo run() de Thread
			
		
		
	}
	
	
	public void detener(){
		
		// t.stop(); //stop() está desaconsejado en Java
		
		t.interrupt();
	}
	
	
	Thread t;
	private LaminaPelota lamina;
	
	
}

