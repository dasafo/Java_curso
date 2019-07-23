package graficos;

import java.awt.event.*;
import javax.swing.*;

public class EventosFuentes_36_II {

	static void main(String[] args) {
		
		Marco_Principal1 mimarco1=new Marco_Principal1();
		
		mimarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco1.setVisible(true);
		
	}
	
}


class Marco_Principal1 extends JFrame{
	
	public Marco_Principal1() {
		
		setTitle("PRueba Varios");
		setBounds(1300,100,300,200);
		
		Lamina_Principal1 lamina1=new Lamina_Principal1();
		
		add(lamina1);
		
	}
	
}


class Lamina_Principal1 extends JPanel{
	
	public Lamina_Principal1() {
		
		JButton boton_nuevo1=new JButton("Nuevo");
		
		add(boton_nuevo1);
		
		boton_cerrar1=new JButton("Cerrar todo");
		
		add(boton_cerrar1);
		
		OyenteNuevo1 miOyente1=new OyenteNuevo1();
		
		boton_nuevo1.addActionListener(miOyente1);
		
	}
	
	private class OyenteNuevo1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Marco_Emergente1 marco1=new Marco_Emergente1(boton_cerrar1);
			
			marco1.setVisible(true);
			
		}
		
		
	}
	
	JButton boton_cerrar1;
	
}


class Marco_Emergente1 extends JFrame{
	
	public Marco_Emergente1(JButton boton_principal1){
		
		contador1++;
		
		setTitle("Ventana " + contador1);
		
		setBounds(40*contador1, 40*contador1, 300,150);
		
		CierraTodos1 oyenteCerrar1=new CierraTodos1();
		
		boton_principal1.addActionListener(oyenteCerrar1);
		
	}
	
	private class CierraTodos1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			dispose();
		}
		
		
	}
	
	private static int contador1=0;

}

