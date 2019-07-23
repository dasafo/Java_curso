package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class SwingEventos_31_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoBotones2 mimarco2=new MarcoBotones2();
		mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco2.setVisible(true);
		
	}

}


class MarcoBotones2 extends JFrame{
	
	public MarcoBotones2() {
	
	setTitle("Botones y eventos");
	setBounds(750, 300, 500, 300);
	
	LaminaBotones2 milamina2=new LaminaBotones2();
	
	add(milamina2);
	
	}	
}


class LaminaBotones2 extends JPanel{ //implementamos la interface ActionListener de JPanel
	
	JButton botonAzul=new JButton("Azul");	//creamos boton
	JButton botonAmarillo=new JButton("Amarillo");
	JButton botonRojo=new JButton("Rojo");
	
	public LaminaBotones2() {
	
	add(botonAzul);
	add(botonAmarillo);
	add(botonRojo);
	
	ColorFondo Amarillo=new ColorFondo(Color.YELLOW);
	ColorFondo Azul=new ColorFondo(Color.BLUE);
	ColorFondo Rojo=new ColorFondo(Color.RED);
	
	botonAzul.addActionListener(Azul);  
	botonAmarillo.addActionListener(Rojo); // (evento=botonAmarillo, addActionListener=fuente, Rojo=qué desencadena la accion(en este caso la proia lamina))
	botonRojo.addActionListener(Amarillo);
	}
	
	
	private class ColorFondo implements ActionListener{
		
		public ColorFondo(Color c) {
			
			colorDeFondo=c;
		}
		
		public void actionPerformed(ActionEvent e) {
			
			setBackground(colorDeFondo);
		}
		
		private Color colorDeFondo;
	}
	
}
