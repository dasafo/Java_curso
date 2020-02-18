package graficos;

import javax.swing.*;

import java.awt.*;

public class TrabajandoFuentes_29_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoConFuentes mimarco=new MarcoConFuentes();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}


class MarcoConFuentes extends JFrame{
	
	public MarcoConFuentes() {
	
	setTitle("Prueba con Fuentes");
	setSize(400, 400);
	
	LaminaConFuentes milamina=new LaminaConFuentes();
	
	add(milamina);
	
	milamina.setForeground(Color.PINK);  //Para establcer un color unificado en el frame
	
	}	
}


class LaminaConFuentes extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	
		Graphics2D g2=(Graphics2D) g; //refundimos g de la clase Graphics a la clase Graphics2D
		
		Font mifuente=new Font("Arial", Font.BOLD, 26);
		g2.setFont(mifuente);
		// g2.setColor(Color.BLUE);
		
		g2.drawString("David", 100, 100);
		g2.setFont(new Font("Arial", Font.ITALIC, 14));
		// g2.setColor(new Color(128, 90, 50).brighter());
		
		g2.drawString("Curso de Java", 100, 200);
		
	
	}
	
}
