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

import javax.swing.JFrame;

public class EventosRaton_34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoRaton mimarco=new MarcoRaton();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

}

class MarcoRaton extends JFrame{
	
	public MarcoRaton() {
		
		setVisible(true);
		setBounds(700 ,300, 600, 450);
		
		//EventosDeRaton EventoRaton=new EventosDeRaton();
		//addMouseListener(EventoRaton); //o tambien se puede poner como...
		//addMouseMotionListener(EventoRaton);
		addMouseMotionListener(new EventosDeRaton()); //esta última linea dice lo mismo que las 2 superiores

	}
}


/*class EventosDeRaton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Has hecho Click");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de presionar el click del ratón");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de levantar el click del ratón");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de entrar a la ventana con el ratón");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de salir de la ventana con el ratón");

	}
	
}*/



/*class EventosDeRaton extends MouseAdapter{	//Clases adaptadas para no tener que escribir todos los metodos
	
	public void mouseClicked(MouseEvent e) {
		
		// System.out.println("Coordenada X: " + e.getX() + " Coordenada Y: " + e.getY());  //nos da las coordenadas donde hacemos click

		System.out.println(e.getClickCount());	//numero de cliks que hacemos
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		// System.out.println(e.getModifiersEx());	//nos da el valor de las constantes(ver API) al pulsar boton derecho, izquierdo, rueda de raton
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) {
			 System.out.println("HAs pulsado el botón izquierdo");
			 
		}else if(e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK){
		 	System.out.println("HAs pulsado la rueda del ratón");
		 	
		}else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK) {		 
			System.out.println("Has pulsado el botón derecho");
		
		}
	}
	
}*/

class EventosDeRaton implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Estás arrastrando.");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Estás moviendo.");
	}
	
	
}


