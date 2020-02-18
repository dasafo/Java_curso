package graficos;
import javax.swing.*;
import java.awt.*;


public class EscribiendoEnMarco_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoConTexto mimarco=new MarcoConTexto();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConTexto extends JFrame{
	
	public MarcoConTexto() {
		
		setVisible(true);  //hacemos visible nuestro frame
		
		setSize(600,450);
		
		setLocation(400,200);
		
		setTitle("Primer texto");
		
		Lamina milamina=new Lamina();	//instanciamos
		
		add(milamina); //añadimos una lamina al frame para poder añadir cosas
		
	}
	
}


class Lamina extends JPanel{		//Para dibujar encima del frame(colocamos una 'Layer' primero)
									
	public void paintComponent(Graphics g) {	//JPanel hereda de JComponent
		
		super.paintComponent(g);	//Invocamos a paintComponent de la clase JComponent. Hace lo que tiene programado en JComponent y además haz lo que sigue(escribir un texto).
		
		g.drawString("Estamos aprendiendo Swing", 100, 100);
		
		
	}
}
