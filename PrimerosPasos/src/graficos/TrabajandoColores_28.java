package graficos;

import javax.swing.*;
import java.awt.geom.*;

import java.awt.*;

public class TrabajandoColores_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoConColor mimarco=new MarcoConColor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
		
	}

}

class MarcoConColor extends JFrame{
	
	public MarcoConColor() {
	
	setTitle("Prueba con colores");
	setSize(400, 400);
	
	LaminaConColor milamina=new LaminaConColor();
	
	add(milamina);
	
	// milamina.setBackground(Color.YELLOW);
	milamina.setBackground(SystemColor.window); //para que le de a la lamina el color del sistema operativo que tengamos
	
	}
	
}


class LaminaConColor extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	
		Graphics2D g2=(Graphics2D) g; //refundimos g de la clase Graphics a la clase Graphics2D
		
		Rectangle2D rectangulo=new Rectangle2D.Double(100, 100, 200, 150);
		g2.setPaint(Color.BLACK);
		g2.draw(rectangulo);
		g2.setPaint(Color.RED);
		g2.fill(rectangulo);	//para que rellene el rectangulo
		
		
		Ellipse2D elipse=new Ellipse2D.Double();
		elipse.setFrame(rectangulo);	//también se puede poner las coordenadas, aqui le hemos dicho que coga las del rectangulo anteior
		
		Color micolor=new Color(125,189,200);
		g2.setPaint(micolor);
		// g2.setPaint(new Color(19,162,59).brighter().brighter()); //brighter para darle brillo al color(si se pone otra vez, es más brillante aún)
																	//darkhter para oscurecer
		g2.fill(elipse); //rellena la elipse
	
	}
	
}



