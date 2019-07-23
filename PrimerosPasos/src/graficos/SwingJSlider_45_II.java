package graficos;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SwingJSlider_45_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSliders2 mimarco2=new FrameSliders2();
		
		mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class FrameSliders2 extends JFrame{
	
	public FrameSliders2() {
		
		setBounds(550,400,550,350);
		
		LaminaSliders2 milamina2=new LaminaSliders2();
		
		add(milamina2);
		
		setVisible(true);
	}
}

class LaminaSliders2 extends JPanel{
	
	public LaminaSliders2() {
		
		setLayout(new BorderLayout());
		
		rotulo2=new JLabel("En un lugar de la Mancha..");
		
		add(rotulo2, BorderLayout.CENTER);
		
		control2=new JSlider(8,50, 12);
		
		control2.setMajorTickSpacing(20);
		control2.setMinorTickSpacing(5);
		control2.setPaintTicks(true);
		control2.setPaintLabels(true);
		
		control2.setFont(new Font("Serief", Font.ITALIC,10));
		
		control2.addChangeListener(new EventoSlider());
		
		JPanel laminaSlider=new JPanel();
		
		laminaSlider.add(control2);
		
		add(laminaSlider, BorderLayout.NORTH);
		
		
	}
	
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			
			// contador++;
			// System.out.println("Estas manipulando el deslizante: " + control2.getValue());
		
			rotulo2.setFont(new Font("Serif", Font.PLAIN, control2.getValue()));
		
		}
		
		
	}
	
	private JLabel rotulo2;
	private JSlider control2;
	private static int contador;
}


