package graficos;

import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		miMarco marco1=new miMarco();
		
		marco1.setVisible(true);	//hacemos la ventana visible
		
		/*Ahora le decimos que cuando se cierre la ventana el programa se para.
		 * setDefaultCloseOperation devuelve un int que es justo también 
		 * lo que es EXIT_ON_CLOSE
		*/
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
	}

}

class miMarco extends JFrame{	//heredamos esta clase de JFrame
	
	public miMarco() {	//Constructor
		
		// setSize(500,300); //le damos tamaño al frame
		// setLocation(500,300);	//Le indicamos dónde queremos que salga el frame. (0,0) esta en la esquina superior izquierda de la pantalla.
		
		setBounds(500, 300, 550, 250); //Hace lo mismo que las dos anteiores juntas
		// setResizable(false); //impedimos(false) que no se pueda redimensionar el frame manualmente
		
		// setExtendedState(Frame.MAXIMIZED_BOTH); //EL frame se abre a pnatalla completa
		// setExtendedState(6); //Es lo mismo (Frame.MAXIMIZED_BOTH=6, ver API)
		
		setTitle("Mi ventana");
		
	}
	
}
