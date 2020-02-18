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
import java.awt.event.*;
import javax.swing.*;

public class SwingAreaTexto_41_II {

	public static void main(String[] args) {
		// TODO Auto-generate
		
		MarcoPruebaArea mimarco=new MarcoPruebaArea();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}


class MarcoPruebaArea extends JFrame{
	
	public MarcoPruebaArea() {
		
		setTitle("Probando área de texto");
		setBounds(500,300,500,350);
		
		setLayout(new BorderLayout());
		
		laminaBotones=new JPanel();
		
		botonInsertar=new JButton("Insertar");
		
		/*ahora haremos lo mismo que hemos hecho en el ejericios anteriores de poner objetos a la escucha
		 de otros eventos, pero en vez de definir el evento en otra clase(siempre recomendable, lo hacemos
		 todo a la vez, ponemos el boton a la escucha del evento y definimos el metodo del evento*/
		botonInsertar.addActionListener(new ActionListener(){ 

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				areaTexto.append("En un lugar de la Mancha...");
				
			}
			
			
			
		});
		
		laminaBotones.add(botonInsertar);
		
		botonSaltoLinea=new JButton("Salto Linea");
		
		botonSaltoLinea.addActionListener(new ActionListener() { //hacmos lo mismo que en botonInsertar

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				boolean saltar=!areaTexto.getLineWrap(); //almacenamos en saltar lo contrario que tengamos en areaTExto, si NO hay salto de linea se almacena un true
														 //getLineWrap nos indica si en el texto hay saltos de linea
				
				areaTexto.setLineWrap(saltar); //asi establecemos saltos de linea siempre que pulsemos el boton
											   //setLineWrap establece los saltos de linea(cuando es True)
				
				// botonSaltoLinea.setText(saltar ? "Quitar salto" : "Saltar linea");  //es lo mimsmo que el siguiente if, else
				if(saltar) {
					
					botonSaltoLinea.setText("No hay salto");
				}else {
					
					botonSaltoLinea.setText("Hay salto línea");
				}
				
			}
			
			
		});
		
		laminaBotones.add(botonSaltoLinea);
		
		add(laminaBotones, BorderLayout.SOUTH);
		
		areaTexto=new JTextArea(8,20);
		
		laminaConBarras=new JScrollPane(areaTexto);
		
		add(laminaConBarras, BorderLayout.CENTER);
	}
	
	private JPanel laminaBotones;
	
	private JButton botonInsertar, botonSaltoLinea;
	
	private JTextArea areaTexto;
	
	private JScrollPane laminaConBarras;
	
}
