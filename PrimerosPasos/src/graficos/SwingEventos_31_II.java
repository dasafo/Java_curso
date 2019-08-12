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
 *   				 I_WindowListener--> Tiene 7 métodos(ver API) que hay que incluir
 *
 * I=Interface, M=Metodo, C=Clase
 ************************************************************************************/

package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class SwingEventos_31_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoBotones2 mimarco2=new MarcoBotones2();
		mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco2.setVisible(true);
		
	}

}


class MarcoBotones2 extends JFrame{
	
	public MarcoBotones2() {
	
	setTitle("Botones y eventos");
	setBounds(750, 300, 500, 300);
	
	LaminaBotones2 milamina2=new LaminaBotones2();
	
	add(milamina2);
	
	}	
}


class LaminaBotones2 extends JPanel{ //implementamos la interface ActionListener de JPanel
	
	JButton botonAzul=new JButton("Azul");	//creamos boton
	JButton botonAmarillo=new JButton("Amarillo");
	JButton botonRojo=new JButton("Rojo");
	
	public LaminaBotones2() {
	
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		
		ColorFondo Amarillo=new ColorFondo(Color.YELLOW);
		ColorFondo Azul=new ColorFondo(Color.BLUE);
		ColorFondo Rojo=new ColorFondo(Color.RED);
		
		botonAzul.addActionListener(Azul);  
		botonAmarillo.addActionListener(Amarillo); // (evento=botonAmarillo, addActionListener=fuente, Rojo=qué desencadena la accion(en este caso la proia lamina))
		botonRojo.addActionListener(Rojo);
	}
	
	
	private class ColorFondo implements ActionListener{ //clase interna
		
		public ColorFondo(Color c) { //metodo constructor
			
			colorDeFondo=c;
		}
		
		/*para poder usar setBackground, hemos tenido que meter la clase ColorFondo dentro de la clase
		 * LaminaBotones2 ya que este metodo(setBackground) pertenece a JPanel.
		 * Yo por eso al crear esta subclase(clase interna), hemos tenido que añadir 'private' a ColorFondo*/ 
		public void actionPerformed(ActionEvent e) {
			
			setBackground(colorDeFondo); 
		}
		
		private Color colorDeFondo;
	}
	
}
