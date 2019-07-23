package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SwingBotonRadio_43_III {

	public static void main(String[] args) {
		// TODO Auto-generated method s
		
		MarcoRadio2 mimarco2=new MarcoRadio2();
		
		mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoRadio2 extends JFrame{
	
	public MarcoRadio2() {
		
		setVisible(true);
		setBounds(550,300,500,350);
		
		LaminaRadio2 milamina2=new LaminaRadio2();
		
		add(milamina2);
		
	}
}

class LaminaRadio2 extends JPanel{
	
	public LaminaRadio2() {
		
		setLayout(new BorderLayout());
		
		texto2=new JLabel("En un lugar de la Macha...");
		
		texto2.setFont(new Font("Serif", Font.PLAIN, 12));
		
		add(texto2, BorderLayout.CENTER);
		
		laminaBotones2=new JPanel();
		
		migrupo2=new ButtonGroup();
	
		colocarBotones2("Pequeño", false, 10);
		colocarBotones2("Mediano", true, 12);
		colocarBotones2("Grande", false, 18);
		colocarBotones2("Muy Grande", false, 26);

		add(laminaBotones2, BorderLayout.SOUTH);
		
	}
	
	public void colocarBotones2(String nombre, boolean seleccionado, final int tamagno) {
		
		JRadioButton boton2=new JRadioButton(nombre, seleccionado);
		
		migrupo2.add(boton2);
		
		laminaBotones2.add(boton2);
		
		ActionListener mievento2=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				texto2.setFont(new Font("Serif", Font.PLAIN, tamagno));
				
			}
			
		};
		
		boton2.addActionListener(mievento2);
		
	}
	
	
	private JLabel texto2;
	
	private JRadioButton boton1, boton2, boton3, boton4;
	
	private ButtonGroup migrupo2;
	
	private JPanel laminaBotones2;
}

