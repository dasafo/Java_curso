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
		
		botonInsertar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				areaTexto.append("EN un luegar de la Mancha...");
				
			}
			
			
			
		});
		
		laminaBotones.add(botonInsertar);
		
		botonSaltoLinea=new JButton("Salto Linea");
		
		botonSaltoLinea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				boolean saltar=!areaTexto.getLineWrap(); //almacenamos en saltar lo contrario que tengamos en areaTExto, si NO hay salto de linea se almacena un true
				
				areaTexto.setLineWrap(saltar); //asi establecemos saltos de linea siempre que pulsemos el boton
				
				
				// botonSaltoLinea.setText(saltar ? "Quitar salto" : "Saltar linea");  //es lo mimsmo que el siguiente if, else
				if(saltar) {
					
					botonSaltoLinea.setText("No hay salto");
				}else {
					
					botonSaltoLinea.setText("Salto línea");
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
