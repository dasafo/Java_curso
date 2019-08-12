package graficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAreaTexto_41_II {

	public static void main(String[] args) {
		// TODO Auto-generate
		
		MarcoPruebaArea mimarco=new MarcoPruebaArea();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}


class MarcoPruebaArea extends JFrame{
	
	public MarcoPruebaArea() {
		
		setTitle("Probando área de texto");
		setBounds(500,300,500,350);
		
		setLayout(new BorderLayout());
		
		laminaBotones=new JPanel();
		
		botonInsertar=new JButton("Insertar");
		
		/*ahora haremos lo mismo que hemos hecho en el ejericios anteriores de poner objetos a la escucha
		 de otros eventos, pero en vez de definir el evento en otra clase(siempre recomendable, lo hacemos
		 todo a la vez, ponemos el boton a la escucha del evento y definimos el metodo del evento*/
		botonInsertar.addActionListener(new ActionListener(){ 

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				areaTexto.append("En un lugar de la Mancha...");
				
			}
			
			
			
		});
		
		laminaBotones.add(botonInsertar);
		
		botonSaltoLinea=new JButton("Salto Linea");
		
		botonSaltoLinea.addActionListener(new ActionListener() { //hacmos lo mismo que en botonInsertar

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				boolean saltar=!areaTexto.getLineWrap(); //almacenamos en saltar lo contrario que tengamos en areaTExto, si NO hay salto de linea se almacena un true
														 //getLineWrap nos indica si en el texto hay saltos de linea
				
				areaTexto.setLineWrap(saltar); //asi establecemos saltos de linea siempre que pulsemos el boton
											   //setLineWrap establece los saltos de linea(cuando es True)
				
				// botonSaltoLinea.setText(saltar ? "Quitar salto" : "Saltar linea");  //es lo mimsmo que el siguiente if, else
				if(saltar) {
					
					botonSaltoLinea.setText("No hay salto");
				}else {
					
					botonSaltoLinea.setText("Hay salto línea");
				}
				
			}
			
			
		});
		
		laminaBotones.add(botonSaltoLinea);
		
		add(laminaBotones, BorderLayout.SOUTH);
		
		areaTexto=new JTextArea(8,20);
		
		laminaConBarras=new JScrollPane(areaTexto);
		
		add(laminaConBarras, BorderLayout.CENTER);
	}
	
	private JPanel laminaBotones;
	
	private JButton botonInsertar, botonSaltoLinea;
	
	private JTextArea areaTexto;
	
	private JScrollPane laminaConBarras;
	
}
