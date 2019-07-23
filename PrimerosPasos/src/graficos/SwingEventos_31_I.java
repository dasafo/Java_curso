package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class SwingEventos_31_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoBotones mimarco=new MarcoBotones();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
		
	}

}


class MarcoBotones extends JFrame{
	
	public MarcoBotones() {
	
	setTitle("Botones y eventos");
	setBounds(750, 300, 500, 300);
	
	LaminaBotones milamina=new LaminaBotones();
	
	add(milamina);
	
	}	
}


class LaminaBotones extends JPanel implements ActionListener{ //implementamos la interface ActionListener de JPanel
	
	JButton botonAzul=new JButton("Azul");	//creamos boton
	JButton botonAmarillo=new JButton("Amarillo");
	JButton botonRojo=new JButton("Rojo");
	
	public LaminaBotones() {
	
	add(botonAzul);
	add(botonAmarillo);
	add(botonRojo);
	
	botonAzul.addActionListener(this);  //con this le decimos que ponemos como Listener a la propia lamina. Al hacer click en boton azul haz lo que te diga actionPerformed
	botonAmarillo.addActionListener(this); // (evento=botonAmarillo, addActionListener=fuente, this=qué desencadena la accion(en este caso la proia lamina))
	botonRojo.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) { //metodo de la interface ActionListener
		
		Object botonPulsado=e.getSource();
		
		if(botonPulsado==botonAzul) {
			setBackground(Color.BLUE);
		}
		else if(botonPulsado==botonAmarillo) {
			setBackground(Color.YELLOW);
		}
		else {
			setBackground(Color.RED);

		}
	
		
	}
		
}



