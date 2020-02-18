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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwingTexto_39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoTexto mimarco=new MarcoTexto();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoTexto extends JFrame{
	
	public MarcoTexto() {
		
		setBounds(600,300,600,350);
		
		LaminaTexto milamina=new LaminaTexto();
		
		add(milamina);
		setVisible(true);
	}
}


class LaminaTexto extends JPanel{
	
	public LaminaTexto() {
		
		setLayout(new BorderLayout());
		
		JPanel milamina2=new JPanel();
		
		milamina2.setLayout(new FlowLayout());
		
		resultado=new JLabel("", JLabel.CENTER);
		
		JLabel texto1=new JLabel("Email: ");
		milamina2.add(texto1);
		
		campo1=new JTextField(20);
		milamina2.add(campo1);
		
		add(resultado, BorderLayout.CENTER);
		
		// System.out.println(campo1.getText().trim()); //trim() para quitar espacios adicionales
		
		JButton miboton=new JButton("Comprobar"); //creamos el boton
		
		DameTexto mievento=new DameTexto(); //creamos el objeto que luego dejaremos a la escucha
		
		miboton.addActionListener(mievento); //dejamos el objeto del evento del boton a la escucha
		
		milamina2.add(miboton); //agregamos el boton a la lamina
		
		add(milamina2, BorderLayout.NORTH);
		
		
	}
	
	private class DameTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		int correcto=0;
		
		String email=campo1.getText().trim(); //trim() para que quite los espacios en blanco al principio o final
		
		for(int i=0;i<email.length();i++) {
			if(email.charAt(i)=='@') {
				
				correcto++;
			}
			
		}
		if(correcto!=1) {
			
			resultado.setText("Incorrecto");
		}else {
			
			resultado.setText("Correcto");

		}
		
		System.out.println(campo1.getText().trim()); //trim() para que quite los espacios en blanco al principio o final
		}
	}

	private JTextField campo1;
	private JLabel resultado;
}
