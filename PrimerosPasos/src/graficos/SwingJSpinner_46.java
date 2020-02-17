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
		add(new LaminaSpinner());
		setVisible(true);

	}
}



class LaminaSpinner extends JPanel{
	
	public LaminaSpinner() {
		
		// JSpinner control= new JSpinner(new SpinnerDateModel()); //nos hace un spinner con la fecha y hora
		
		// String lista[]= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); //para que muestre las tipografias disponibles en el PC
		// JSpinner control=new JSpinner(new SpinnerListModel(lista));

		// JSpinner control=new JSpinner(new MiModeloJSpinner()); //para hacerlo con una clase dentro de otra
		
		
		/*Clases internas anonimas: que equivale a lo que hemos comentado de código mas abajo, pero ahora creamos 
		  una instancia y dentro del constructor creamos la clase interna anonima*/
		JSpinner control=new JSpinner(new SpinnerNumberModel(5,0,10,1) { 
						
			public Object getNextValue() {
					
				return super.getPreviousValue();
			}
				
			public Object getPreviousValue() {
					
				return super.getNextValue();
	
			}
							
		}); 
		
		Dimension d=new Dimension(200,20); //creamos un objeto para indicar el tamaño del spinner(por defecto es lo primero que aparece)
		control.setPreferredSize(d); //para añadir ese tamaño del objeto 'd' al spinner
		
		add(control);
		
	}
	
	/*private class MiModeloJSpinner extends SpinnerNumberModel{ //queremos que los botones de arriba/abajo funcionen al revés
		
		public MiModeloJSpinner() {
			
			super(5,0,10,1); //con super llamamos al constructor de la clase padre(el constructor de SpinnerNumberModel)
		}
		
		public Object getNextValue() { //sobreescribimos un metodo(de SpinnerNumberModel) para que haga lo que queremos nosotros
			
			return super.getPreviousValue(); //de esta forma le decimos que nos devuelva el valor anterior
		}
		
		public Object getPreviousValue() { //sobreescribimos un metodo(de SpinnerNumberModel) para que haga lo que queremos nosotros
			
			return super.getNextValue(); //de esta forma le decimos que nos devuelva el valor siguiente

		}
		
	}*/
	
	
}




