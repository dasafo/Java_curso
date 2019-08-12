package poo;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;


public class Prueba_Temporizador_23_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reloj2 mireloj2=new Reloj2();
		
		mireloj2.enMarcha2(3000, true);
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");
		System.exit(0);
	
	}

}



class Reloj2{
	

	public void enMarcha2(int intervalo2, final boolean sonido2) {	//ponemos el final en sonido porque se hace así cuando se quiere acceder desde una clase interna local, cosa que no hace con intervalo
		
		/*Creamos una clase interna local(ahora dentro de un método de una clase), no puede ser private. 
		Y solo es visible para este método, ni siquiera para la clase que la engloba. Pero desde esta clase interna local 
		si se puede acceder. Esto se usa cuando una clase solo la vamos a utilizar una vez*/

		 class DameLaHora2 implements ActionListener{	//esta clase interna dentro de un metodo, no puede ser 'private'
			public void actionPerformed( ActionEvent evento2) {
				
				Date ahora2=new Date();
				
				System.out.println("Te pongo la hora cada 3 sg " + ahora2);
				
				if(sonido2==true) {   // o if(sonido2)...es lo mismo. En este caso podemos acceder desde esta subclase a private sonido, porque esta dentro de su clase
					
					Toolkit.getDefaultToolkit().beep();
				}
				
			}
		
		}
		
	
		ActionListener oyente2=new DameLaHora2();
		
		Timer mitemporizador2=new Timer(intervalo2, oyente2);
		
		mitemporizador2.start();
	}
	

	
}


