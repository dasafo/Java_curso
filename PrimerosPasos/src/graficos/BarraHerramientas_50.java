package graficos;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class BarraHerramientas_50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoBarra mimarco=new MarcoBarra();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoBarra extends JFrame{
	
	public MarcoBarra(){
		
		setTitle("Marco con Barra");
		
		setBounds(500,300,600,450);
		
		lamina=new JPanel();
		
		add(lamina);
		
		// configuracin de acciones
		
		Action accionAzul=new AccionColor("Azul", new ImageIcon("src/graficos/bolaAzul.gif"), Color.BLUE);
		
		Action accionAmarillo=new AccionColor("Amarillo", new ImageIcon("src/graficos/bolaAmarilla.gif"), Color.YELLOW);
		
		Action accionRojo=new AccionColor("Rojo", new ImageIcon("src/graficos/bolaRoja.gif"), Color.RED);
		
		Action accionSalir=new AbstractAction("Salir", new ImageIcon("src/graficos/exit.png")) {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.exit(0); //para que salga de la aplicacion
			}
			
			
		};
		
		JMenu menu=new JMenu("Color");
		
		menu.add(accionAzul);
		menu.add(accionAmarillo);
		menu.add(accionRojo);

		JMenuBar barraMenus=new JMenuBar();
		
		barraMenus.add(menu);
		
		setJMenuBar(barraMenus);
		
		//Construccion de la barra de herramientas
		
		JToolBar barra=new JToolBar();
		
		barra.add(accionAzul);
		barra.add(accionAmarillo);
		barra.add(accionRojo);
		
		barra.addSeparator();
		
		barra.add(accionSalir);
		
		add(barra, BorderLayout.NORTH);

	}
		
	
	private class AccionColor extends AbstractAction{
		
		public AccionColor(String nombre, Icon icono, Color c){
			
			putValue(Action.NAME, nombre);
			
			putValue(Action.SMALL_ICON, icono);
			
			putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);
			
			putValue("Color", c);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			Color c=(Color) getValue("Color");
			
			lamina.setBackground(c);
			
		}		
		
	}
	private JPanel lamina;
}



