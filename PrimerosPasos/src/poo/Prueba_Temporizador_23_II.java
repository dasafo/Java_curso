package poo;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer; //Para evitar conflicto con otro paquete(java.util) que también tiene Timer
import java.awt.Toolkit;


public class Prueba_Temporizador_23_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reloj mireloj=new Reloj(3000,true);
		
		mireloj.enMarcha();
		
		//Sacamos una ventana para que nos de tiempo a ver lo que pasa:
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");
		System.exit(0);
	
	}

}



class Reloj{
	
	public Reloj(int intervalo, boolean sonido) {	//Constructor
		
		this.intervalo=intervalo;
		this.sonido=sonido;
		
	}
	
	public void enMarcha() {		//SETTER
		
		ActionListener oyente=new DameLaHora2(); //instanciamos un objeto(oyente) perteneciente a la interfaz ActionListener
		
		Timer mitemporizador=new Timer(intervalo, oyente);
		
		mitemporizador.start();
	}
	
	private int intervalo; 	//Encapsulamiento
	private boolean sonido;
	
	
	/*
	Ahora creamos una clase interna(una clase dentro de otra), estas pueden ser 
	private, el resto de clases no, porque sino no podemos acceder a la superclase Reloj
	*/
	private class DameLaHora2 implements ActionListener{	
		
		public void actionPerformed( ActionEvent evento) { //metodo de la interface ActionListener
			
			Date ahora=new Date(); //almacenamos la hora actual en un objeto
			
			System.out.println("Te pongo la hora cada 3 sg " + ahora);
			
			if(sonido==true) {   // o if(sonido)...es lo mismo. En este caso podemos acceder desde esta subclase a private sonido, porque esta dentro de su clase
				
				Toolkit.getDefaultToolkit().beep();
			}
			
		}
	
	}
	
}


