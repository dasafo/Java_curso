package graficos;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class SwingEventosCuadros_40_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoPassword mimarco=new MarcoPassword();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoPassword extends JFrame{
	
	public MarcoPassword() {
		
		setBounds(400,300,550,400);
		
		LaminaPassword milamina=new LaminaPassword();
		
		add(milamina);
		
		setVisible(true);
	}
}

class LaminaPassword extends JPanel{
	
	public LaminaPassword() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaSuperior=new JPanel();
		
		laminaSuperior.setLayout(new GridLayout(2,2));
		
		add(laminaSuperior, BorderLayout.NORTH);
		
		JLabel etiqueta1=new JLabel("Usuario");
		JLabel etiqueta2=new JLabel("Contraseña");
		
		JTextField c_usuario=new JTextField(15);
		
		CompruebaPass mievento=new CompruebaPass();
		
		c_contra=new JPasswordField(15);
		c_contra.getDocument().addDocumentListener(mievento);
	
		
		laminaSuperior.add(etiqueta1);
		laminaSuperior.add(c_usuario);
		laminaSuperior.add(etiqueta2);
		laminaSuperior.add(c_contra);
		
		JButton enviar=new JButton("Enviar");
		
		add(enviar, BorderLayout.SOUTH);

	}
	
	private class CompruebaPass implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			char [] contrasena;
			
			contrasena=c_contra.getPassword();
			
			if(contrasena.length<8 || contrasena.length>12) {
				
				c_contra.setBackground(Color.RED);
			}else {
				
				c_contra.setBackground(Color.WHITE);

			}
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			char [] contrasena;
			
			contrasena=c_contra.getPassword();
			
			if(contrasena.length<8 || contrasena.length>12) {
				
				c_contra.setBackground(Color.RED);
			}else {
				
				c_contra.setBackground(Color.WHITE);

			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	JPasswordField c_contra;
	
}
