/************************************************************************************************
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
 *					 I_MouseListener-->Tiene 5 metodos(ver API) pero también podemos
 *									   usar la clase adaptadora MouseAdapter
 *					 I_MouseMotionListener-->M_mouseDragged(..) y M_mouseMoved(..)
 *					 I_FocusListener--> M_focusGained(..) y M_focusLost(..)
 *										Con clase adaptadora FocusAdapter
 *					 I_WindowsFocusListener--> M_windowGainedFocus(..) y M_windowLostFocus(..)
 *											   Con clase adaptadora WindowAdapter
 *					 I_Action --> Tiene 6 métodos(ver API) + otro importado de ActionListener
 *								  (actioPe  rformed). Tiene una clase ABSTRACTA que hace la función
 *								  de adaptadora que es C_AbstractAction
 *
 * I=Interface, M=Metodo, C=Clase
 **************************************************************************************************/


package graficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAreaTexto_41_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoArea mimarco=new MarcoArea();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoArea extends JFrame{
	
	public MarcoArea() {
	
	setBounds(500,300,500,350);
	
	LaminaArea milamina=new LaminaArea();
	
	add(milamina);
	
	setVisible(true);
	
	}
	
}

class LaminaArea extends JPanel{
	
	public LaminaArea() {
		
		miarea=new JTextArea(8,20);
		
		JScrollPane laminaBarras=new JScrollPane(miarea); //creamos lamina con barras de desplazamiento en la cual instertamos miarea
		
		miarea.setLineWrap(true); //para que salte abajo atomaticamente cuando llegue al final de la linea
		
		add(laminaBarras); //añadimos laminaBarras ya que es la lamina donde está incrustada miarea
		
		JButton miboton=new JButton("Dale");
		
		miboton.addActionListener(new GestionaArea()); //ponemos miboton a la escucha de lo que haga el evento dado en GEstionArea()
		
		add(miboton);
		
	}
	
	private class GestionaArea implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			System.out.println(miarea.getText());
		}
		
		
	}
	private JTextArea miarea;
}
