package graficos;

import javax.swing.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class EventosVentana_32_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoVentana2 mimarco=new MarcoVentana2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setTitle("Ventana 1");
		mimarco.setBounds(	300, 300, 500, 350);
		
		MarcoVentana2 mimarco2=new MarcoVentana2();
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//DISPOSE_ON_CLOSE Asi si presiono en esta ventana solo se cierra esta
		mimarco2.setTitle("Ventana 2");
		mimarco2.setBounds(900, 300, 500, 350);

}
}


class MarcoVentana2 extends JFrame{
	
	public MarcoVentana2() {
	
	// setTitle("Respondiendo");
	// setBounds(300, 300, 500, 350);
	
	setVisible(true);
	
	/*M_Ventana2 oyente_ventana2=new M_Ventana2();
	addWindowListener(oyente_ventana2);*/
	addWindowListener(new M_Ventana2());
	
	}	
}


class M_Ventana2 extends WindowAdapter{ //implementamos una Clase Adaptadora para no tener que poner todos los métodos para la ventana como en ejemplo anterior
	
	
	public void windowIconified(WindowEvent e) { //cuando minimece la ventana...
		
		System.out.println("Ventana minimizada");
		
	}
	
	
}
