package graficos;

import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		miMarco marco1=new miMarco();
		
		marco1.setVisible(true);	
		
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
		
		setTitle("Mi ventana");
		
	}
	
}
