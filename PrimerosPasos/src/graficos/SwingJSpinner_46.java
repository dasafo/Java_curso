package graficos;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class SwingJSpinner_46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FrameSpinner mimarco=new FrameSpinner();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}



class FrameSpinner extends JFrame{
	
	public FrameSpinner() {
		
		setBounds(550,350,550,350);
		setVisible(true);
		add(new LaminaSpinner());
	}
}



class LaminaSpinner extends JPanel{
	
	public LaminaSpinner() {
		
		// String lista[]= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); //para que muestre las tipografias disponibles en el PC
		// JSpinner control=new JSpinner(new SpinnerListModel(lista));

		// JSpinner control=new JSpinner(new MiModeloJSpinner()); //para hacerlo con una clase dentro de otra
		
		
		JSpinner control=new JSpinner(new SpinnerNumberModel(5,0,10,1) { //para hacerlo con calases internas anonimas, que eqiuvale a lo que hemos comentado de código mas abajo
			
			public Object getNextValue() {
				
				return super.getPreviousValue();
			}
			
			public Object getPreviousValue() {
				
				return super.getNextValue();

			}
			
			
		}); 
		
		Dimension d=new Dimension(200,20);
		control.setPreferredSize(d);
		
		add(control);
		
	}
	
	/*private class MiModeloJSpinner extends SpinnerNumberModel{ //queremos que los botones de arriba/abajo funcionen al revés
		
		public MiModeloJSpinner() {
			
			super(5,0,10,1);
		}
		
		public Object getNextValue() {
			
			return super.getPreviousValue();
		}
		
		public Object getPreviousValue() {
			
			return super.getNextValue();

		}
		
	}*/
	
	
}




