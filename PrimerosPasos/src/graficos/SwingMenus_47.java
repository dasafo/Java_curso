package graficos;

import javax.swing.*;

public class SwingMenus_47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MenuFrame mimarco=new MenuFrame();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MenuFrame extends JFrame{
	
	public MenuFrame() {
		
		setBounds(500,300,550,400);
		
		MenuLamina milamina=new MenuLamina();
		
		add(milamina);
		
		setVisible(true);
	}
}


class MenuLamina extends JPanel{
	
	public MenuLamina() {
		
		JMenuBar mibarra=new JMenuBar(); //creamos la barra
		
		JMenu archivo=new JMenu("Archivo"); //insertamos los menús en la barra
		JMenu edicion=new JMenu("Edición");
		JMenu herramientas=new JMenu("Herramientas");
		JMenu opciones=new JMenu("Opciones"); //este sera un menu dentro de otro menu
		
		
		JMenuItem guardar=new JMenuItem("Guardar");
		JMenuItem guardar_como=new JMenuItem("Guardar Como...");
		
		JMenuItem cortar=new JMenuItem("Cortar", new ImageIcon("src/graficos/cut.png"));
		JMenuItem copiar=new JMenuItem("Copiar", new ImageIcon("src/graficos/copy.png"));
		copiar.setHorizontalTextPosition(SwingConstants.LEFT); //ponemos a la izquierda el icono de copiar
		JMenuItem pegar=new JMenuItem("Pegar", new ImageIcon("src/graficos/paste.png"));
		
		
		JMenuItem generales=new JMenuItem("Generales");
		
		JMenuItem opcion1=new JMenuItem("Opción 1");
		JMenuItem opcion2=new JMenuItem("Opción 2");


		archivo.add(guardar);
		archivo.add(guardar_como);
		
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		
		edicion.addSeparator(); //pintamos separadores
		
		herramientas.add(generales);
		
		opciones.add(opcion1);
		opciones.add(opcion2);
		
		edicion.add(opciones); //le especificamos que opciones va dentro de edicion


		mibarra.add(archivo); //le decimos que esos menus van en la barra mibarra
		mibarra.add(edicion);
		mibarra.add(herramientas);
		
		add(mibarra); //agregamos la barra del menu en la lamina milamina
	}
}
