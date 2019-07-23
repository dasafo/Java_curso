package graficos;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class SwingEventosCuadros_40_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoPrueba mimarco=new MarcoPrueba();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoPrueba extends JFrame{
	
	public MarcoPrueba() {
		
		setBounds(500,300,500,350);
		
		LaminaPrueba milamina=new LaminaPrueba();
		
		add(milamina);
		setVisible(true);
	}
}

class LaminaPrueba extends JPanel{
	
	public LaminaPrueba() {
		
		JTextField micampo=new JTextField(20);
		
		EscuchaTexto el_evento=new EscuchaTexto();
		
		Document midoc=micampo.getDocument();
		
		midoc.addDocumentListener(el_evento);
		
		add(micampo);
	}
	
	private class EscuchaTexto implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			System.out.println("Has insertado texto");

		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			System.out.println("Has borrado texto");

		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			

		}
		
		
	}
}
