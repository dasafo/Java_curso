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

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class EventosFuentes_36_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoAccion marco=new MarcoAccion();
		
		marco.setVisible(true);
	}

}

class MarcoAccion extends JFrame{
	
	public MarcoAccion() {
		
		setTitle("Prueba acciones");
		setBounds(600,350,600,300);
		
		PanelAccion lamina=new PanelAccion();
		
		add(lamina);
		
		
	}
	
}

class PanelAccion extends JPanel{
	
	public PanelAccion() {
		
		//instanciamos la clase oyente
		AccionColor accionAmarillo=new AccionColor("Amarillo", new ImageIcon("src/graficos/bolaAmarilla.gif"), Color.YELLOW);
		AccionColor accionAzul=new AccionColor("Azul", new ImageIcon("src/graficos/bolaAzul.gif"), Color.BLUE);
		AccionColor accionRojo=new AccionColor("Rojo", new ImageIcon("src/graficos/bolaRoja.gif"), Color.RED);

		/*JButton botonAmarillo=new JButton(accionAmarillo);
		add(botonAmarillo);*/
		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));

		
		/*JButton botonAmarillo=new JButton("Amarillo");
		JButton botonAzul=new JButton("Azul");
		JButton botonRojo=new JButton("Rojo");
		
		add(botonAmarillo);
		add(botonAzul);
		add(botonRojo);*/

		// 1-Creamos mapa de entrada
		InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		//KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl A");
		
		//2- Creamos y Guardamos la combinacion de teclas y le asociamos un valor(fondo_rojo,...)
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");

		//3- Asignar objetos a las acciones
		ActionMap mapaAccion=getActionMap();
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_azul", accionAzul);
		mapaAccion.put("fondo_rojo", accionRojo);
		
		
	}
	
	//Creamos la clase que hará de oyente
	private class AccionColor extends AbstractAction{ //metemos esta clase dentro de PanelAccion para poder usar setBackground()
													//también la encapsulamos 'private' para que no se pueda acceder desde fuera
		public AccionColor(String nombre, Icon icono, Color color_boton) {
			
			//Con putValue() almacenamos el objeto del evento. Action es una interface
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Pone la lámina de color " + nombre); //texto que sale al dejar el raton sobre el boton
			putValue("color_de_fondo", color_boton); //Clave:VAlor
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Color c=(Color)getValue("color_de_fondo"); //con getValue rescatamos el valor del clave:valor de un evento
			setBackground(c);		//ponemos la lamina del color que hay almacenado en 'c'
			
			System.out.println("Nombre: " + getValue(Action.NAME) + ". Descripción: " + getValue(Action.SHORT_DESCRIPTION));
		}
		
		
	}
	
}







