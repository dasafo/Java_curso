/***********************************************************************************
 * 
 * 1.- Objeto evento(click ratón, tecla,...)
 * 		-C_EventObject--> C_ActionEvent(para acciones del raton) 
 * 						  C_WindowEvent(eventos de maximizar ventana,minimizar,...)
 * 
 * 2.- Objeto fuente(quien desencadena el evento(botón, radiobutton,..))
 * 		-C_JButton--> M_addActionListener(Object listener)
 * 
 * 3.- Objeto Listener(quien recibe la acción(que zona tiene que cambiar))
 * 		-C_JPanel--> I_ActionListener--> M_actionPerformed(Object evento)
 *   				 I_WindowListener--> Tiene 7 métodos(ver API) que hay que incluir.
 *   									 Pero también podemos usar su clase adaptadora 
 *   									 WindowAdapter.
 *   				 I_WindowStateListener--> M_windowStateChanged(WindowEvent e)
 *					 I_KeyListener--> M_keyPressed(..),M_keyRelased(..) y M_keyTyped(..)
 *									  Tabmién tiene su clase adaptadora KeyAdapter
 *
 * I=Interface, M=Metodo, C=Clase
 ************************************************************************************/



package graficos;

import javax.swing.*;
import java.awt.Frame;
import java.awt.event.*;
import javax.swing.JPanel;

public class EventosTeclado_33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoConTeclas mimarco=new MarcoConTeclas();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoConTeclas extends JFrame{
	
	public MarcoConTeclas() {
		
		setVisible(true);
		setBounds(700, 300, 600, 450);
		
		EventoDeTeclado tecla=new EventoDeTeclado(); //instanciamos un objeto de la clase que esta a la escucha
		addKeyListener(tecla); //lo ponemos a la escucha
		
	}
}

class EventoDeTeclado implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int codigo=e.getKeyCode();
		System.out.println(codigo); //nos muestra el codigo de la tecla pulsada
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		char letra=e.getKeyChar();		
		System.out.println(letra); //nos muestra la letra que se pula al soltar

	}
	
	
}
