package poo;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;


public class Prueba_Temporizador_23_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reloj mireloj=new Reloj(3000,true);
		
		mireloj.enMarcha();
		
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
		
		ActionListener oyente=new DameLaHora2();
		
		Timer mitemporizador=new Timer(intervalo, oyente);
		
		mitemporizador.start();
	}
	
	private int intervalo; 	//Encapsulamiento
	private boolean sonido;
	
	
	private class DameLaHora2 implements ActionListener{	//creamos una clase interna(una clase dentro de otra), estas pueden ser private, el resto de clases no.
	
		public void actionPerformed( ActionEvent evento) {
			
			Date ahora=new Date();
			
			System.out.println("Te pongo la hora cada 3 sg " + ahora);
			
			if(sonido==true) {   // o if(sonido)...es lo mismo. En este caso podemos acceder desde esta subclase a private sonido, porque esta dentro de su clase
				
				Toolkit.getDefaultToolkit().beep();
			}
			
		}
	
	}
	
}


