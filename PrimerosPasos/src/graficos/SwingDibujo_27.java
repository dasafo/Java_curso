package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.geom.*;

public class SwingDibujo_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoConDibujos mimarco=new MarcoConDibujos();
		
		mimarco.setVisible(true);
		 mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}


class MarcoConDibujos extends JFrame{
	
	public MarcoConDibujos() { //constructor
		
		setTitle("Prueba de dibujo");
		setSize(400,400);
		
		LaminaConFiguras milamina=new LaminaConFiguras();
		
		add(milamina);
		
	}
	
}


class LaminaConFiguras extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g); //llamamos al metodo paitnComponent de la clase padre
		
		// g.drawRect(50, 50, 200, 200);		//dibuja rectangulo o cuadrado
		// g.drawLine(100, 100, 300, 200);			//dibuja rectas
		// g.drawArc(50, 100, 1000, 200, 120, 150);		//dibuja arcos
	
		Graphics2D g2=(Graphics2D) g; //refundimos g de la clase Graphics a la clase Graphics2D
		
		/*Ahora aplicando el principio de sustitucion para instanciar, REctabl2D es abstacta(ver API) 
		 * pero Rectangle2D.Double (es una constructor) heredera de esa clase abstacta y se puede instanciar*/
		Rectangle2D rectangulo=new Rectangle2D.Double(100, 100, 200, 150); //Rectangle2D.Double aqui es el constructor de la clase del mismo nombre
		
		g2.draw(rectangulo);
		
		Ellipse2D elipse=new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);	//también se puede poner las coordenadas, aqui le hemos dicho que coga las del rectangulo anteior
		
		g2.draw(elipse);
		
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		
		
		//Dibujamos un circulo que englobe a el resto dibujado
		double CentroenX=rectangulo.getCenterX();
		double CentroenY=rectangulo.getCenterY();
		double radio=150;
		Ellipse2D circulo=new Ellipse2D.Double();
		circulo.setFrameFromCenter(CentroenX, CentroenY,CentroenX+radio, CentroenY+radio);
		g2.draw(circulo);
	}
	
	
	
}


