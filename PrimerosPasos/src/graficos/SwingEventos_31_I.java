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

import javax.swing.*;

import java.awt.event.*;

public class SwingEventos_31_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoBotones mimarco=new MarcoBotones();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
		
	}

}


class MarcoBotones extends JFrame{
	
	public MarcoBotones() {
	
	setTitle("Botones y eventos");
	setBounds(750, 300, 500, 300);
	
	LaminaBotones milamina=new LaminaBotones();
	
	add(milamina);
	
	}	
}


class LaminaBotones extends JPanel implements ActionListener{ //implementamos la interface ActionListener de JPanel
	
	//creamos 3 botones
	JButton botonAzul=new JButton("Azul");	
	JButton botonAmarillo=new JButton("Amarillo");
	JButton botonRojo=new JButton("Rojo");
	
	
	public LaminaBotones() { //constructor
	
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		
		/*Con 'this' le decimos que ponemos como Listener a esta propia clase(la lamina). 
		Al hacer click en boton hace lo que le diga actionPerformed 
		(evento=botonAmarillo, addActionListener=fuente, this=qué desencadena la accion
		(en este caso la propia lamina))*/
		botonAzul.addActionListener(this);  
		botonAmarillo.addActionListener(this); 
		botonRojo.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) { //metodo de la interface ActionListener
		
		/*
		 * Creamos una variable de tipo objeto y le decimos que es igual a 'e', que es 
		 * el objeto evento que recibe ActionPerformed por parámetros. 
		 * Y con getsource() que es un metodo de la clase ActionEvent, 
		 * este método nos dice quién es la fuente (botón rojo, azúl o amarillo)
		 */
		Object botonPulsado=e.getSource();
		
		if(botonPulsado==botonAzul) {
			setBackground(Color.BLUE);
		}
		else if(botonPulsado==botonAmarillo) {
			setBackground(Color.YELLOW);
		}
		else {
			setBackground(Color.RED);

		}
	
		
	}
		
}



