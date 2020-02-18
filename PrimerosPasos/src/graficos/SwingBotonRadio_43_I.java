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
import java.awt.*;

public class SwingBotonRadio_43_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoRadioSintaxis mimarco=new MarcoRadioSintaxis();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoRadioSintaxis extends JFrame{
	
	public MarcoRadioSintaxis() {
		
		setVisible(true);
		setBounds(550,300,500,300);
		
		LaminaRadioSintaxis milamina=new LaminaRadioSintaxis();
		
		add(milamina);
		
	}
}


class LaminaRadioSintaxis extends JPanel{
	
	public LaminaRadioSintaxis() {
		
		ButtonGroup migrupo1=new ButtonGroup(); //para agrupar botones de radio(para que solo uno de ellos pueda estar activado)
		
		ButtonGroup migrupo2=new ButtonGroup();  
		
		JRadioButton boton1=new JRadioButton("Azul", false);
		JRadioButton boton2=new JRadioButton("Rojo", true); //dejamos este activado
		JRadioButton boton3=new JRadioButton("Verde", false);
		
		JRadioButton boton4=new JRadioButton("Masculino", false);
		JRadioButton boton5=new JRadioButton("Femenino", false);

		migrupo1.add(boton1); //agrupamos los botones de colores
		migrupo1.add(boton2);
		migrupo1.add(boton3);
		
		migrupo2.add(boton4); //agrupamos los botones de genero
		migrupo2.add(boton5);

		add(boton1);
		add(boton2);
		add(boton3);
		
		add(boton4);
		add(boton5);

		
		
	}
}