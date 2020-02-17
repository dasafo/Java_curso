package execepciones_I;

import javax.swing.*;

public class Fallos_56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] miMatriz=new int[5];
		
		miMatriz[0]=5;
		miMatriz[1]=38;
		miMatriz[2]=-15;
		miMatriz[3]=92;
		miMatriz[4]=71;

		
		for(int i=0; i<5;i++) {
			
			System.out.println("Posición " + i + " = " + miMatriz[i]);;
		}
		
		//Peticion de datos personales
		
		String nombre=JOptionPane.showInputDialog("Introduce tu nombre: ");
		
		int edad=Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad: " ));
		
		System.out.println("Holi " + nombre + " ,tienes " + edad + " años. " + " El programa terminó su ejecución.");
	
	}

}
