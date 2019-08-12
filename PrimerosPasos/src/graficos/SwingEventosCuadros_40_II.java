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
		
		setLayout(new BorderLayout()); //distribucion borderlayout para la lamina principal
		
		JPanel laminaSuperior=new JPanel(); //creamos una lamina que irá arriba
		
		laminaSuperior.setLayout(new GridLayout(2,2)); //la lámina superior tendrá distribucion GridLayout
		
		add(laminaSuperior, BorderLayout.NORTH); //la lamina de arruba irá en la zona nodre de BorderLayout
		
		JLabel etiqueta1=new JLabel("Usuario");
		JLabel etiqueta2=new JLabel("Contraseña (entre 8 y 12 carácteres)");
		
		JTextField c_usuario=new JTextField(15); //campo de texto para meter usuario
		CompruebaPass mievento=new CompruebaPass(); //creamos la instancia para el evento del password
		
		c_contra=new JPasswordField(15); //cuadro de texto para meter un Password
		c_contra.getDocument().addDocumentListener(mievento); //ponemos el cuadro contraseña a la esucha a la espera de 'mievento'
	
		
		laminaSuperior.add(etiqueta1);
		laminaSuperior.add(c_usuario);
		laminaSuperior.add(etiqueta2);
		laminaSuperior.add(c_contra);
		
		JButton enviar=new JButton("Enviar");
		
		add(enviar, BorderLayout.SOUTH);

	}
	
	private class CompruebaPass implements DocumentListener{ //clase para los eventos del Password

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
			char [] contrasena; //creamos un char [] ya que getPassword(ver abajo) devuelve este tipo de datos
			
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
			
			char [] contrasena; //creamos un char [] ya que getPassword(ver abajo) devuelve este tipo de datos
			
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
