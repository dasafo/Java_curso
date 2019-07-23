package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class EventosFuentes_36_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoAccion marco=new MarcoAccion();
		
		marco.setVisible(true);
	}

}

class MarcoAccion extends JFrame{
	
	public MarcoAccion() {
		
		setTitle("Prueba acciones");
		setBounds(600,350,600,300);
		
		PanelAccion lamina=new PanelAccion();
		
		add(lamina);
		
		
	}
	
}

class PanelAccion extends JPanel{
	
	public PanelAccion() {
		
		AccionColor accionAmarillo=new AccionColor("Amarillo", new ImageIcon("src/graficos/bolaAmarilla.gif"), Color.YELLOW);
		AccionColor accionAzul=new AccionColor("Azul", new ImageIcon("src/graficos/bolaAzul.gif"), Color.BLUE);
		AccionColor accionRojo=new AccionColor("Rojo", new ImageIcon("src/graficos/bolaRoja.gif"), Color.RED);

		/*JButoon botonAmarillo=new JButton(accionAmarillo);
		add(botonAmarillo);*/
		
		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));

		
		/*JButton botonAmarillo=new JButton("Amarillo");
		JButton botonAzul=new JButton("Azul");
		JButton botonRojo=new JButton("Rojo");
		
		add(botonAmarillo);
		add(botonAzul);
		add(botonRojo);*/

		InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		// KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl A");
		
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");

		ActionMap mapaAccion=getActionMap();
		
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_azul", accionAzul);
		mapaAccion.put("fondo_rojo", accionRojo);
		
		
	}
	
	private class AccionColor extends AbstractAction{ //metemos esta clase dentro de PanelAccion para poder usar setBackground()

		public AccionColor(String nombre, Icon icono, Color color_boton) {
			
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Pone la lámina de color " + nombre);
			putValue("color_de_fondo", color_boton);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Color c=(Color)getValue("color_de_fondo");
			setBackground(c);		
			
			System.out.println("Nombre: " + getValue(Action.NAME) + " De scripción: " + getValue(Action.SHORT_DESCRIPTION));
		}
		
		
	}
	
}







