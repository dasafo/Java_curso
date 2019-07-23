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
		
		EventosDeRaton EventoRaton=new EventosDeRaton();
		
		//addMouseListener(EventoRaton);
		
		addMouseMotionListener(EventoRaton);
	
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


