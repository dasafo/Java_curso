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

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SwingJSlider_45_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSliders mimarco=new FrameSliders();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class FrameSliders extends JFrame{
	
	public FrameSliders() {
		
		setBounds(550,400,550,350);
		
		LaminaSliders milamina=new LaminaSliders();
		
		add(milamina);
		
		setVisible(true);
	}
}

class LaminaSliders extends JPanel{
	
	public LaminaSliders() {
		
		JSlider control=new JSlider(0,100,50); 
		// JSlider control=new JSlider(SwingConstants.VERTICAL, 20,100,25); //SwingConstans para poner en vertical el Slider
		// control.setOrientation(SwingConstants.VERTICAL); //o también así
		
		control.setMajorTickSpacing(50); //distancia entre las marcas gordas
		control.setMinorTickSpacing(25);	//ditancia entre las marcas intermedias
		
		control.setPaintTicks(true); //activamos las marcas para los numeros
		
		control.setFont(new Font("Serif",Font.ITALIC,12)); //le damos formato a los numeros
		
		control.setPaintLabels(true); //para pintar los numeros
		
		// control.setSnapToTicks(true);  //activar el modo iman para que no se quede en una zona intermedia nuestra eleccion
		
		add(control);
		
		
	}
}


