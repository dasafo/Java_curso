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
		
		if(e.getNewState()==Frame.MAXIMIZED_BOTH) { // es lo mismo que: if(e.getNewState()==6)
			System.out.println("La ventana está a pantalla completa");
			
		}else if(e.getNewState()==Frame.NORMAL) {
			
			System.out.println("La ventana está normal");

		}else if(e.getNewState()==Frame.ICONIFIED) {
			
			System.out.println("La ventana está minimizada");

		}
		
	}
	
}


