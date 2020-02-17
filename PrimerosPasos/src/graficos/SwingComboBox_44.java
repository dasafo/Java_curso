package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingComboBox_44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoCombo mimarco=new MarcoCombo();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCombo extends JFrame{
	
	public MarcoCombo() {
		
		setBounds(550,300,550,400);
		
		laminaCombo milamina=new laminaCombo();
		
		add(milamina);
		
		setVisible(true);

	}
}

class laminaCombo extends JPanel{
	
	public laminaCombo() {
		
		setLayout(new BorderLayout());
		
		texto=new JLabel("En un lugar de la Mancha...");
		
		texto.setFont(new Font("Serif", Font.PLAIN,18));
		
		add(texto, BorderLayout.CENTER);
			
		JPanel laminaNorte=new JPanel();
		
		micombo=new JComboBox();
		
		micombo.setEditable(true); //para dejar escribir en el cuadro
		
		micombo.addItem("Serif"); //metodo de JComboBox para añadir strings al desplegable
		micombo.addItem("SansSerif");
		micombo.addItem("Monospaced");
		micombo.addItem("Dialog");
		
		eventoCombo mievento=new eventoCombo();
		
		micombo.addActionListener(mievento);
		
		laminaNorte.add(micombo); //añadimos el desplegable a la lamina 'laminaNorte'
		
		add(laminaNorte,BorderLayout.NORTH); //añadimos la laminNorte al norte de un BorderLayout

		
		
	}
	
	
	private class eventoCombo implements ActionListener{ //metodo que indica el evento a realiza

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			/* getSelectedItem devuelve lo que hay pero en forma de Object(ver API), 
			pero el primer argumento de Font debe ser un string, por eso hacemos castin*/
			texto.setFont(new Font((String)micombo.getSelectedItem(), Font.PLAIN,18));
		}
		
		
	}
	
	private JLabel texto;
	private JComboBox micombo;
	
}
