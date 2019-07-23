package graficos;


import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

public class SwingCheckBox_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCheck mimarco=new MarcoCheck();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}


class MarcoCheck extends JFrame{
	
	public MarcoCheck() {
		
		setBounds(550,300,550,350);
		setVisible(true);
		LaminaCheck milamina=new LaminaCheck();
		
		add(milamina);
		
	}
}


class LaminaCheck extends JPanel{
	
	public LaminaCheck() {
		
		setLayout(new BorderLayout());
		
		Font miletra=new Font("Serif", Font.PLAIN, 24);
		
		texto=new JLabel("En un lugar de la Mancha...");
		
		texto.setFont(miletra);
		
		JPanel laminatexto=new JPanel();
		
		laminatexto.add(texto);
		
		add(laminatexto, BorderLayout.CENTER);
		
		check1=new JCheckBox("Negrita");
		check2=new JCheckBox("Cursiva");
		
		check1.addActionListener(new ManejaChecks());
		check2.addActionListener(new ManejaChecks());
		
		JPanel laminaChecks=new JPanel();
		
		laminaChecks.add(check1);
		laminaChecks.add(check2);
		
		add(laminaChecks, BorderLayout.SOUTH);

	}
	
	private class ManejaChecks implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			int tipo=0;
			
			if(check1.isSelected()) tipo+=Font.BOLD; //si activamos el chekbox es =1(ver API de Font Bold), sino =0
			if(check2.isSelected()) tipo+=Font.ITALIC; //si =2 (ver API de Font Italic)
			
			texto.setFont(new Font("Serif", tipo, 24));
			
		}
		
		
	}
	
	private JLabel texto;
	
	private JCheckBox check1, check2;
	
	
}
