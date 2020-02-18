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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SwingBotonRadio_43_II {

	public static void main(String[] args) {
		// TODO Auto-generated method s
		
		MarcoRadio mimarco=new MarcoRadio();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoRadio extends JFrame{
	
	public MarcoRadio() {
		
		setVisible(true);
		setBounds(550,300,500,350);
		
		LaminaRadio milamina=new LaminaRadio();
		
		add(milamina);
		
	}
}

class LaminaRadio extends JPanel{
	
	public LaminaRadio() {
		
		setLayout(new BorderLayout());
		
		texto=new JLabel("En un lugar de la Macha...");
		
		add(texto, BorderLayout.CENTER);
		
		ButtonGroup migrupo=new ButtonGroup();
		
		boton1=new JRadioButton("Pequeño", false);
		boton2=new JRadioButton("Mediano", true);
		boton3=new JRadioButton("Grande", false);
		boton4=new JRadioButton("Muy Grande", false);
		
		JPanel laminaRadio=new JPanel();
		
		EventoRadio mievento=new EventoRadio();
		
		boton1.addActionListener(mievento);
		boton2.addActionListener(mievento);
		boton3.addActionListener(mievento);
		boton4.addActionListener(mievento);

		migrupo.add(boton1);
		migrupo.add(boton2);
		migrupo.add(boton3);
		migrupo.add(boton4);
		
		laminaRadio.add(boton1);
		laminaRadio.add(boton2);
		laminaRadio.add(boton3);
		laminaRadio.add(boton4);
		
		add(laminaRadio, BorderLayout.SOUTH);


	}
	
	 private class EventoRadio implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==boton1) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 10));
				
			}else if(e.getSource()==boton2) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 12));

			}else if(e.getSource()==boton3) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 18));

			}else if(e.getSource()==boton4) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 24));

			}
		}
	} 
	
	private JLabel texto;
	
	private JRadioButton boton1, boton2, boton3, boton4;
}

