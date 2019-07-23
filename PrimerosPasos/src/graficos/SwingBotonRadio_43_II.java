package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SwingBotonRadio_43_II {

	public static void main(String[] args) {
		// TODO Auto-generated method s
		
		MarcoRadio mimarco=new MarcoRadio();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoRadio extends JFrame{
	
	public MarcoRadio() {
		
		setVisible(true);
		setBounds(550,300,500,350);
		
		LaminaRadio milamina=new LaminaRadio();
		
		add(milamina);
		
	}
}

class LaminaRadio extends JPanel{
	
	public LaminaRadio() {
		
		setLayout(new BorderLayout());
		
		texto=new JLabel("En un lugar de la Macha...");
		
		add(texto, BorderLayout.CENTER);
		
		ButtonGroup migrupo=new ButtonGroup();
		
		boton1=new JRadioButton("Pequeño", false);
		boton2=new JRadioButton("Mediano", true);
		boton3=new JRadioButton("Grande", false);
		boton4=new JRadioButton("Muy Grande", false);
		
		JPanel laminaRadio=new JPanel();
		
		EventoRadio mievento=new EventoRadio();
		
		boton1.addActionListener(mievento);
		boton2.addActionListener(mievento);
		boton3.addActionListener(mievento);
		boton4.addActionListener(mievento);

		migrupo.add(boton1);
		migrupo.add(boton2);
		migrupo.add(boton3);
		migrupo.add(boton4);
		
		laminaRadio.add(boton1);
		laminaRadio.add(boton2);
		laminaRadio.add(boton3);
		laminaRadio.add(boton4);
		
		add(laminaRadio, BorderLayout.SOUTH);


	}
	
	 private class EventoRadio implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==boton1) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 10));
				
			}else if(e.getSource()==boton2) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 12));

			}else if(e.getSource()==boton3) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 18));

			}else if(e.getSource()==boton4) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, 24));

			}
		}
	} 
	
	private JLabel texto;
	
	private JRadioButton boton1, boton2, boton3, boton4;
}

