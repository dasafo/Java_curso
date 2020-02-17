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
 *
 * I=Interface, M=Metodo, C=Clase
 ************************************************************************************/

package graficos;

import javax.swing.*;

import java.awt.event.*;

public class EventosVentana_32_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoVentana mimarco=new MarcoVentana();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setTitle("Ventana 1");
		mimarco.setBounds(	300, 300, 500, 350);
		
		MarcoVentana mimarco2=new MarcoVentana();
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//DISPOSE_ON_CLOSE Asi si presiono en esta ventana solo se cierra esta
		mimarco2.setTitle("Ventana 2");
		mimarco2.setBounds(900, 300, 500, 350);

}
}


class MarcoVentana extends JFrame{
	
	public MarcoVentana() {
	
	// setTitle("Respondiendo");
	// setBounds(300, 300, 500, 350);
	
	setVisible(true);
	
	M_Ventana oyente_ventana=new M_Ventana();
	
	addWindowListener(oyente_ventana); //ponemos nuestra ventana a la escucha
	
	}	
}

//al implementar la interfaz WindowListener debemos poner sus 7 metodos, o usar clases adaptadoras(ver siguiente ejercicio)
class M_Ventana implements WindowListener{ 
	
	public void windowActivated(WindowEvent e) {
		
		System.out.println("Ventana Activada");
	}
	
	public void windowClosed(WindowEvent e) {
		
		System.out.println("La ventana ha sido cerrada");
	}
	
	public void windowClosing(WindowEvent e) {
		
		System.out.println("Cerrando Ventana");

	}
	
	public void windowDeactivated(WindowEvent e) {
		
		System.out.println("Ventana desactivada");
	}
	
	public void windowDeiconified(WindowEvent e) { //cuando la ventana se restaura...
		
		System.out.println("Ventana REstaurada");

	}
	
	public void windowIconified(WindowEvent e) { //cuando minimece la ventana...
		
		System.out.println("Ventana minimizada");
		
	}
	
	public void windowOpened(WindowEvent e) {
	
		System.out.println("Ventana Abierta");
	}
	
	
}
