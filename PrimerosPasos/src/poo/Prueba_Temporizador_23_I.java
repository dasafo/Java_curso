package poo;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer; //Importamos este paquete en concreto para que Timer no tenga conflicto con otro de los paquetes (java.util) que también posee Timer
import java.awt.Toolkit;

public class Prueba_Temporizador_23_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DameLaHora oyente=new DameLaHora();
		
		Timer miTemporizador=new Timer(5000, oyente);
		
		miTemporizador.start(); //start() está en la clase Timer de la API
		
		JOptionPane.showMessageDialog(null, "Pulsa OK para detener");
	
		System.exit(0); //exit() es un método de System
	
	}

}


class DameLaHora implements ActionListener{		//ActionListener es una interface
	
	public void actionPerformed(ActionEvent e) { //Metodo del interface ActionListener que llama al evento cuando es invocado 
		
		Date ahora=new Date();
		
		System.out.println("Te pongo la hora cada 5 sg: " + ahora);
		
		Toolkit.getDefaultToolkit().beep(); //Toolkit es una clase de java.awt, y nos da un sonido(beep) cada 5seg(en este caso)
		
	}
}