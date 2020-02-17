package graficos;

import java.awt.*;
import javax.swing.*;

public class SwingMenuEmergente_49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MarcoEmergente mimarco=new MarcoEmergente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoEmergente extends JFrame{
	
	public MarcoEmergente() {
		
		setBounds(100,100,300,250);
		
		LaminaEmergente milamina=new LaminaEmergente();
		
		add(milamina);
		setVisible(true);
	}
}


class LaminaEmergente extends JPanel{
	
	public LaminaEmergente() {
		
		setLayout(new BorderLayout());
		
		JPanel laminamenu=new JPanel();
		
		JMenuBar mibarra=new JMenuBar();
		
		JMenu fuente=new JMenu("Fuente");
		JMenu estilo=new JMenu("Estilo");
		JMenu tamagno=new JMenu("Tamaño");
		
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamagno);
		
		laminamenu.add(mibarra);
		
		add(laminamenu, BorderLayout.NORTH);
		
		JTextPane miarea=new JTextPane();
		
		add(miarea, BorderLayout.CENTER);

		//--------------------------------------------------------
		
		//Construimos el menú emergente
		JPopupMenu emergente=new JPopupMenu();
		
		JMenuItem opcion1=new JMenuItem("Opción 1");
		JMenuItem opcion2=new JMenuItem("Opción 2");
		JMenuItem opcion3=new JMenuItem("Opción 3");

		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);

		miarea.setComponentPopupMenu(emergente); //para que el menu emergente salga en la zona de texto
		
	}
}


