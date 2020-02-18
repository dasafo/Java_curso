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

//Hacemos lo mismo que en anterior ejercicio pero mejor y más simplificado

public class SwingBotonRadio_43_III {

	public static void main(String[] args) {
		// TODO Auto-generated method s
		
		MarcoRadio2 mimarco2=new MarcoRadio2();
		
		mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoRadio2 extends JFrame{
	
	public MarcoRadio2() {
		
		setVisible(true);
		setBounds(550,300,500,350);
		
		LaminaRadio2 milamina2=new LaminaRadio2();
		
		add(milamina2);
		
	}
}

class LaminaRadio2 extends JPanel{
	
	public LaminaRadio2() {
		
		setLayout(new BorderLayout());
		
		texto2=new JLabel("En un lugar de la Macha...");
		
		texto2.setFont(new Font("Serif", Font.PLAIN, 12));
		
		add(texto2, BorderLayout.CENTER);
		
		laminaBotones2=new JPanel();
		
		migrupo2=new ButtonGroup(); //instanciamos un objeto que nos agrupara los radiobutton
	
		colocarBotones2("Pequeño", false, 10); //creamos los botones usando el metodo colocarBotones2
		colocarBotones2("Mediano", true, 12);
		colocarBotones2("Grande", false, 18);
		colocarBotones2("Muy Grande", false, 26);

		add(laminaBotones2, BorderLayout.SOUTH);
		
	}
	
	public void colocarBotones2(String nombre, boolean seleccionado, final int tamagno) {
		
		JRadioButton boton2=new JRadioButton(nombre, seleccionado);
		
		migrupo2.add(boton2); //metemos el boton2 en el agrupamiento migrupo2
		
		laminaBotones2.add(boton2); //añadimos el boton a la lamina de los botones
		
		ActionListener mievento2=new ActionListener() { //creamos el evento

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				texto2.setFont(new Font("Serif", Font.PLAIN, tamagno));
				
			}
			
		};
		
		boton2.addActionListener(mievento2); //ponemos el boton2 a la escucha del evento 'mievento2'
		
	}
	
	
	private JLabel texto2;
	
	private JRadioButton boton1, boton2, boton3, boton4;
	
	private ButtonGroup migrupo2;
	
	private JPanel laminaBotones2;
}

