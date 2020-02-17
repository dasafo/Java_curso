package graficos;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SwingJSlider_45_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSliders mimarco=new FrameSliders();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class FrameSliders extends JFrame{
	
	public FrameSliders() {
		
		setBounds(550,400,550,350);
		
		LaminaSliders milamina=new LaminaSliders();
		
		add(milamina);
		
		setVisible(true);
	}
}

class LaminaSliders extends JPanel{
	
	public LaminaSliders() {
		
		JSlider control=new JSlider(0,100,50); 
		// JSlider control=new JSlider(SwingConstants.VERTICAL, 20,100,25); //SwingConstans para poner en vertical el Slider
		// control.setOrientation(SwingConstants.VERTICAL); //o también así
		
		control.setMajorTickSpacing(50); //distancia entre las marcas gordas
		control.setMinorTickSpacing(25);	//ditancia entre las marcas intermedias
		
		control.setPaintTicks(true); //activamos las marcas para los numeros
		
		control.setFont(new Font("Serif",Font.ITALIC,12)); //le damos formato a los numeros
		
		control.setPaintLabels(true); //para pintar los numeros
		
		// control.setSnapToTicks(true);  //activar el modo iman para que no se quede en una zona intermedia nuestra eleccion
		
		add(control);
		
		
	}
}


