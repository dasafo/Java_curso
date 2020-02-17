package graficos;

import java.awt.*;

import javax.swing.*;

public class AplGraficasDisposicionesBox_51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCaja mimarco=new MarcoCaja();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}

class MarcoCaja extends JFrame{
	
	public MarcoCaja() {
		
		setTitle("Marco en la caja");
		setBounds(600,350,200,200);
		
		
		JLabel rotulo1=new JLabel("Nombre");
		JTextField texto1=new JTextField(10);
		texto1.setMaximumSize(texto1.getPreferredSize()); //para que cuando se redimensione la pantalla no tengamos problemas
		Box cajaH1=Box.createHorizontalBox(); //creamos caja horizontal
		cajaH1.add(rotulo1);
		cajaH1.add(Box.createHorizontalStrut(10));
		cajaH1.add(texto1);
		
		JLabel rotulo2=new JLabel("Contraseña");
		JTextField texto2=new JTextField(10);
		texto2.setMaximumSize(texto2.getPreferredSize());
		Box cajaH2=Box.createHorizontalBox(); //creamos caja horizontal
		cajaH2.add(rotulo2);
		cajaH2.add(Box.createHorizontalStrut(10));
		cajaH2.add(texto2);
		
		JButton boton1=new JButton("OK");
		JButton boton2=new JButton("Cancelar");
		
		Box cajaH3=Box.createHorizontalBox(); //creamos caja horizontal
		cajaH3.add(boton1);
		cajaH3.add(Box.createGlue()); //Glue para adpatar la distacia de ambos botones cuando se redimensiona
		cajaH3.add(boton2);
		
		Box cajaVertical=Box.createVerticalBox();
		
		cajaVertical.add(cajaH1); //agrupamos las 3 cajas creadas en otra vertical
		cajaVertical.add(cajaH2);
		cajaVertical.add(cajaH3);
		
		add(cajaVertical, BorderLayout.CENTER); //le decimos que la ponga en un BorderLayout y en el centro
		
		
	}
}
