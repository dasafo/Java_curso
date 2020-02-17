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
		//Tabmbein se podria haber hecho asi:
		//ActionListener oyente=new DameLaHora();
		
		Timer miTemporizador=new Timer(5000, oyente); //5000 milisegundos(delay). El primer Timer es la clase y Timer() el constructor
		
		miTemporizador.start(); //start() está en la clase Timer de la API
		
		//Sacamos una ventana para que nos de tiempo a ver lo que pasa
		JOptionPane.showMessageDialog(null, "Pulsa OK para detener");
		System.exit(0); //exit() es un método de System
	
	}

}


class DameLaHora implements ActionListener{		//ActionListener es una interface y debemos implementar todos sus metodos
	
	public void actionPerformed(ActionEvent e) { //Metodo del interface ActionListener que llama al evento cuando es invocado 
		
		Date ahora=new Date(); //instanciamos la clase Date para que nos muestre la hora actual creando de esta forma el objeto 'ahora'
		
		System.out.println("Te pongo la hora cada 5 sg: " + ahora);
		
		Toolkit.getDefaultToolkit().beep(); //Toolkit es una clase de java.awt, y nos da un sonido(beep) cada 5seg(en este caso)
		
	}
}