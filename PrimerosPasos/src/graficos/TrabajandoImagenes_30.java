package graficos;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;


public class TrabajandoImagenes_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoImagen mimarco=new MarcoImagen();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}


class MarcoImagen extends JFrame{
	
	public MarcoImagen() {
	
	setTitle("Prueba con Imagen");
	setBounds(750, 300, 500, 500);
	
	LaminaConImagen milamina=new LaminaConImagen();
	
	add(milamina);
	
	milamina.setForeground(Color.PINK);  //Para establcer un color unificado en el frame
	
	}	
}


class LaminaConImagen extends JPanel{
	
	public LaminaConImagen() {
		
		//Estamos obligados a lanzar una excepcion
				try {
				imagen=ImageIO.read(new File("src/graficos/redstar.png")); //lo ideal sería hacerlo con una imagen de una bola de 15x15
				}
				catch(IOException e) {
					
					System.out.println("La imagen no se encuentra");
				}
				
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// File miimagen=new File("src/graficos/redstar.png");
		
		
		int anchuraImagen=imagen.getWidth(this);
		
		int alturaImagen=imagen.getHeight(this);
		
		g.drawImage(imagen, 0, 0, null);
		
		//hacemos un mosaico con la imagen
		for(int i=0;i<300;i++) {
			
			for(int j=0;j<350;j++) {
				if(i+j>0) {
				
				g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*j);
			}
			}
		}
		
		
	}
	
	private Image imagen;
	
	
}
