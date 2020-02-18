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

public class SwingJSlider_45_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSliders2 mimarco2=new FrameSliders2();
		
		mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class FrameSliders2 extends JFrame{
	
	public FrameSliders2() {
		
		setBounds(550,400,550,350);
		
		LaminaSliders2 milamina2=new LaminaSliders2();
		
		add(milamina2);
		
		setVisible(true);
	}
}

class LaminaSliders2 extends JPanel{
	
	public LaminaSliders2() {
		
		setLayout(new BorderLayout());
		
		rotulo2=new JLabel("En un lugar de la Mancha..");
		
		add(rotulo2, BorderLayout.CENTER);
		
		control2=new JSlider(8,50, 12);
		
		control2.setMajorTickSpacing(20);
		control2.setMinorTickSpacing(5);
		control2.setPaintTicks(true);
		control2.setPaintLabels(true);
		
		control2.setFont(new Font("Serief", Font.ITALIC,10));
		
		control2.addChangeListener(new EventoSlider());
		
		JPanel laminaSlider=new JPanel();
		
		laminaSlider.add(control2);
		
		add(laminaSlider, BorderLayout.NORTH);
		
		
	}
	
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			
			// contador++;
			// System.out.println("Estas manipulando el deslizante: " + contador);

			// System.out.println("Estas manipulando el deslizante: " + control2.getValue()); //getvalue caputra el valor del deslizante
		
			rotulo2.setFont(new Font("Serif", Font.PLAIN, control2.getValue()));
		
		}
		
		
	}
	
	private JLabel rotulo2;
	private JSlider control2;
	//private static int contador;
}


