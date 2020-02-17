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
 *   									 Pero también podemos usar clases adaptadoras 
 *   									 como WindowAdapter, KeyAdapter o MouseAdapter.
 *   				 I_WindowStateListener--> M_windowStateChanged(WindowEvent e)
 *
 * I=Interface, M=Metodo, C=Clase
 ************************************************************************************/



package graficos;

import javax.swing.*;
import java.awt.Frame;
import java.awt.event.*;

public class EventosVentana_32_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoEstado mimarco=new MarcoEstado();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoEstado extends JFrame{
	
	public MarcoEstado() {
	
	setVisible(true);
	setBounds(300, 300, 500, 350);
	CambiaEstado nuevo_estado=new CambiaEstado();
	
	addWindowStateListener(nuevo_estado);
	
	}	
}


class CambiaEstado implements WindowStateListener{
	
	public void windowStateChanged(WindowEvent e) {
		
		System.out.println("La ventana ha cambiado de estado");
		
		// System.out.println(e.getNewState()); //nos devuelve el numero asociado a ese cambio de estado con windowStateChanged(ver API)
		
		if(e.getNewState()==Frame.MAXIMIZED_BOTH) { // es lo mismo que: if(e.getNewState()==6, ver API)
			System.out.println("La ventana está a pantalla completa");
			
		}else if(e.getNewState()==Frame.NORMAL) {
			
			System.out.println("La ventana está normal");

		}else if(e.getNewState()==Frame.ICONIFIED) {
			
			System.out.println("La ventana está minimizada");

		}
		
	}
	
}


