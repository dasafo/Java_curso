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
 *					 I_MouseListener-->Tiene 5 metodos(ver API) pero también podemos
 *									   usar la clase adaptadora MouseAdapter
 *					 I_MouseMotionListener-->M_mouseDragged(..) y M_mouseMoved(..)
 *					 I_FocusListener--> M_focusGained(..) y M_focusLost(..)
 *										Con clase adaptadora FocusAdapter
 *					 I_WindowsFocusListener--> M_windowGainedFocus(..) y M_windowLostFocus(..)
 *											   Con clase adaptadora WindowAdapter
 *
 * I=Interface, M=Metodo, C=Clase
 ************************************************************************************/



package graficos;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class EventosFoco_35_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoFoco mimarco=new MarcoFoco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

}

class MarcoFoco extends JFrame{
	
	public MarcoFoco() {
		
		setVisible(true);
		setBounds(300 ,300, 600, 450);
		
		
		add(new LaminaFoco());
	
	}
}


class LaminaFoco extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		setLayout(null);	//invalidamos las posiciones que Java da a los objetos dentro del frame por defecto
		
		cuadro1=new JTextField();
		cuadro2=new JTextField();

		cuadro1.setBounds(120,10,150,20);
		cuadro2.setBounds(120,50,150,20);
		
		add(cuadro1);
		add(cuadro2);
		
		LanzaFocos elFoco=new LanzaFocos();
		
		cuadro1.addFocusListener(elFoco);


	}
	
	class LanzaFocos implements FocusListener{	//Clase interna de laminaFoco para acceder a JTextField cuadro 1 y cuadro2

		@Override
		public void focusGained(FocusEvent e) { //cuando gana el foco
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {	//lo que tiene que hacer cuando el objeto(ventana, celda,..) pierde el foco
			// TODO Auto-generated method stub
			
			String email=cuadro1.getText();
			boolean comprobacion=false;
			
			for(int i=0;i<email.length();i++) {
				
				if(email.charAt(i)=='@') {
					
					comprobacion=true;
				}
			}
			
			if(comprobacion) {
				
				System.out.println("Correcto");
			}else {
				
				System.out.println("Incorrecto");

			}
		}
		
		
	}
	
	
	JTextField cuadro1;
	JTextField cuadro2;
	
}



