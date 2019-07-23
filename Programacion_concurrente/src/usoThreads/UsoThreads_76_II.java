package usoThreads;
import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads_76_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco2=new MarcoRebote2();
		
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco2.setVisible(true);

	}

}

class PelotaHilos2 implements Runnable{		//Para crear multitareas(hilos) para que aparezcan varias pelotas a la vez
	
	public PelotaHilos2(Pelota unaPelota, Component unComponente) {
		
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



//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota2{
	
	// Mueve la pelota invirtiendo posicion si choca con limites
	
	public void mueve_pelota(Rectangle2D limites){
		
		x+=dx;
		
		y+=dy;
		
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


class LaminaPelota2 extends JPanel{
	
	//Añadimos pelota a la lamina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lamina y botones------------------------------------------------------------------------------

class MarcoRebote2 extends JFrame{
	
	public MarcoRebote2(){
		
		setBounds(600,300,400,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones2=new JPanel();
		
		
		//----------------Añadimos Hilo 1--------------------- 
		arranca1=new JButton("Hilo 1");
		arranca1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				comienza_el_juego2(evento);
			}
			
		});
		
		laminaBotones2.add(arranca1);
		
		//----------------Añadimos Hilo 2--------------------- 
			arranca2=new JButton("Hilo 2");
			arranca2.addActionListener(new ActionListener() {
					
				public void actionPerformed(ActionEvent evento) {
						
					comienza_el_juego2(evento);
				}
					
			});
				
			laminaBotones2.add(arranca2);
				
		//----------------Añadimos Hilo 3--------------------- 
			arranca3=new JButton("Hilo 3");
			arranca3.addActionListener(new ActionListener() {
					
				public void actionPerformed(ActionEvent evento) {
						
					comienza_el_juego2(evento);
				}
					
			});
				
			laminaBotones2.add(arranca3);
			
		//----------------Añadimos Detener 1--------------------- 
			detener1=new JButton("Detener 1");
			detener1.addActionListener(new ActionListener() {
					
				public void actionPerformed(ActionEvent evento) {
						
					detener(evento);
				}
					
			});
				
			laminaBotones2.add(detener1);	
			
		//----------------Añadimos Detener 2--------------------- 
			detener2=new JButton("Detener 2");
			detener2.addActionListener(new ActionListener() {
					
				public void actionPerformed(ActionEvent evento) {
						
					detener(evento);
				}
					
			});
				
			laminaBotones2.add(detener2);	
		
		//----------------Añadimos Detener 3--------------------- 
			detener3=new JButton("Detener 3");
			detener3.addActionListener(new ActionListener() {
					
				public void actionPerformed(ActionEvent evento) {
						
					detener(evento);
				}
					
			});
				
			laminaBotones2.add(detener3);	
		
		//------------------------------------------------------
		
		add(laminaBotones2, BorderLayout.SOUTH);
	}
	
	
	
	
	
	//Añade pelota y la bota 1000 veces
	
	public void comienza_el_juego2 (ActionEvent e){
		
					
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			
			Runnable r=new PelotaHilos(pelota, lamina);
			
			// Thread t=new Thread(r);
			
			if(e.getSource().equals(arranca1)) {
			
				t1=new Thread(r);
				t1.start(); //start llama al metodo run() de Thread
			
			}else if(e.getSource().equals(arranca2)) {
				
				t2=new Thread(r);
				t2.start(); //start llama al metodo run() de Thread
				
			}else if(e.getSource().equals(arranca3)) {
				
				t3=new Thread(r);
				t3.start(); //start llama al metodo run() de Thread
			}
		
		
	}
	
	
	public void detener(ActionEvent e){
		
		// t.stop(); //stop() está desaconsejado en Java
		
		
		if(e.getSource().equals(detener1)) {
		t1.interrupt();
		
		}else if(e.getSource().equals(detener2)) {
			t2.interrupt();
			
		}else if(e.getSource().equals(detener3)) {
			t3.interrupt();
			
		}
		
	}
	
	
	Thread t1, t2, t3;
	JButton arranca1, arranca2, arranca3;
	JButton detener1, detener2, detener3;
	private LaminaPelota lamina;
	
	
}


