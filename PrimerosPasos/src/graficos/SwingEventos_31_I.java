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
 *   				 I_WindowListener--> Tiene 7 métodos(ver API que hay que incluir
 *
 * I=Interface, M=Metodo, C=Clase
 ************************************************************************************/

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
		
		/*Creamos una variable de tipo objeto y le decimos que es igual a 'e', que es el objeto evento 
		 que recibe ActionPerformed por parámetros. Y con getsource() que es un metodo de la clase ActionEvent,
		  este método nos dice quién es la fuente (botón rojo, azúl o amarillo)*/
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



