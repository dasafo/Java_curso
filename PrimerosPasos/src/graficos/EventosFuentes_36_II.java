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

import java.awt.event.*;
import javax.swing.*;

public class EventosFuentes_36_II {

	static void main(String[] args) {
		
		Marco_Principal_I mimarco_I=new Marco_Principal_I();
		
		mimarco_I.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco_I.setVisible(true);
		
	}
	
}


class Marco_Principal_I extends JFrame{
	
	public Marco_Principal_I() {
		
		setTitle("PRueba Varios");
		setBounds(1300,100,300,200);
		
		Lamina_Principal_I lamina_I=new Lamina_Principal_I();
		
		add(lamina_I);
		
	}
	
}


class Lamina_Principal_I extends JPanel{
	
	public Lamina_Principal_I() {
		
		JButton boton_nuevo_I=new JButton("Nuevo");
		
		add(boton_nuevo_I);
		
		boton_cerrar_I=new JButton("Cerrar todo");
		
		add(boton_cerrar_I);
		
		OyenteNuevo_I miOyente_I=new OyenteNuevo_I();
		
		boton_nuevo_I.addActionListener(miOyente_I);
		
	}
	
	private class OyenteNuevo_I implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Marco_Emergente_I marco_I=new Marco_Emergente_I(boton_cerrar_I);
			
			marco_I.setVisible(true);
			
		}
		
		
	}
	
	JButton boton_cerrar_I;
	
}


class Marco_Emergente_I extends JFrame{
	
	public Marco_Emergente_I(JButton boton_principal_I){
		
		contador1++;
		
		setTitle("Ventana " + contador1);
		
		setBounds(40*contador1, 40*contador1, 300,150);
		
		CierraTodos_I oyenteCerrar_I=new CierraTodos_I();
		
		boton_principal_I.addActionListener(oyenteCerrar_I);
		
	}
	
	private class CierraTodos_I implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			dispose();
		}
		
		
	}
	
	private static int contador1=0;

}

