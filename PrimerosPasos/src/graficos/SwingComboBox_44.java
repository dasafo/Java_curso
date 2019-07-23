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
		
		setVisible(true);
		setBounds(550,300,550,400);
		
		laminaCombo milamina=new laminaCombo();
		
		add(milamina);
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
		
		micombo.addItem("Serif");
		micombo.addItem("SansSerif");
		micombo.addItem("Monospaced");
		micombo.addItem("Dialog");
		
		eventoCombo mievento=new eventoCombo();
		
		micombo.addActionListener(mievento);
		
		laminaNorte.add(micombo);
		
		add(laminaNorte,BorderLayout.NORTH);

		
		
	}
	
	
	private class eventoCombo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			texto.setFont(new Font((String)micombo.getSelectedItem(), Font.PLAIN,18));
		}
		
		
	}
	
	private JLabel texto;
	private JComboBox micombo;
	
}
