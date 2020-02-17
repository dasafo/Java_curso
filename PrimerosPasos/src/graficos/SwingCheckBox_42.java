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
		
		texto.setFont(miletra); //establecemos a 'texto' el tipo de letra declarado en el objeto FONT 'miletra'
		
		JPanel laminatexto=new JPanel(); //creamos una lamina
		
		laminatexto.add(texto); //metemos en la laminatexto el texto
		
		add(laminatexto, BorderLayout.CENTER); //situamos laminatexto en el centro de un borderlayout
		
		check1=new JCheckBox("Negrita");
		check2=new JCheckBox("Cursiva");
		
		check1.addActionListener(new ManejaChecks()); //dejamos a la escucha los checkbox de los eventos de la clase ManejaChecks
		check2.addActionListener(new ManejaChecks());
		
		JPanel laminaChecks=new JPanel(); //creamos la lamina para los checks
		
		laminaChecks.add(check1); //añadimos los checks en laminaChecks
		laminaChecks.add(check2);
		
		add(laminaChecks, BorderLayout.SOUTH); //situamos laminachecks en el sur de un borderlayout

	}
	
	private class ManejaChecks implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			int tipo=0;
			
			if(check1.isSelected()) tipo+=Font.BOLD; //si activamos el chekbox es =1(ver API de Font Bold), sino =0
			if(check2.isSelected()) tipo+=Font.ITALIC; //si =2 (ver API de Font Italic)
			
			texto.setFont(new Font("Serif", tipo, 24)); //fuente por defecto
			
		}
		
		
	}
	
	private JLabel texto;
	
	private JCheckBox check1, check2;
	
	
}
