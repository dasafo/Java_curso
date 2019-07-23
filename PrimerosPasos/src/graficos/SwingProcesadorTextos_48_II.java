package graficos;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class SwingProcesadorTextos_48_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MenuProcesador_II mimarco2=new MenuProcesador_II();
		
		mimarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MenuProcesador_II extends JFrame{
	
	public MenuProcesador_II() {
		
		setBounds(500,300,550,400);
		
		LaminaProcesador_II milamina2=new LaminaProcesador_II();
		
		add(milamina2);
		
		setVisible(true);
	}
	
}


class LaminaProcesador_II extends JPanel{
	
	public LaminaProcesador_II() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu2=new JPanel();
		
		JMenuBar mibarra2=new JMenuBar();
		
		//------------------------------------------
		
		fuente2=new JMenu("Fuente");
		estilo2=new JMenu("Estilo");
		tamagno2=new JMenu("Tamaño");
		
		//------------------------------------------

		configuraMenu2("Arial", "Fuente", "Arial", 9, 10, "");
		configuraMenu2("Courier", "Fuente", "Courier", 9, 10, "");
		configuraMenu2("Verdana", "Fuente", "Verdana", 9, 10, "");

		//------------------------------------------
		
		configuraMenu2("Negrita", "Estilo", "", Font.BOLD, 1, "src/graficos/bold.png");
		configuraMenu2("Cursiva", "Estilo", "", Font.ITALIC, 1, "src/graficos/italic.png");
		
		
		//Sino comentamos lo que sigue, habría que comentar el else if del 'estilo' que hay más abajo del codigo para activar los chekbox
		
		/* JCheckBoxMenuItem negrita=new JCheckBoxMenuItem("Negrita", new ImageIcon("bin/graficos/bold.png"));
		JCheckBoxMenuItem cursiva=new JCheckBoxMenuItem("Cursiva", new ImageIcon("bin/graficos/italic.png"));

		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());

		estilo2.add(negrita);
		estilo2.add(cursiva); */

		
		//------------------------------------------
		
		/*configuraMenu2("12", "Tamaño", "", 9, 12, "");
		configuraMenu2("16", "Tamaño", "", 9, 16, "");
		configuraMenu2("20", "Tamaño", "", 9, 20, "");
		configuraMenu2("24", "Tamaño", "", 9, 24, "");*/
		
		ButtonGroup tamagnoLetra=new ButtonGroup();
		
		JRadioButtonMenuItem doce=new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciseis=new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem veinte=new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinticuatro=new JRadioButtonMenuItem("24");
		
		// veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK)); //para atajos de teclado(Ctrol+d para poner a 24 el tamaño)

		tamagnoLetra.add(doce);
		tamagnoLetra.add(dieciseis);
		tamagnoLetra.add(veinte);
		tamagnoLetra.add(veinticuatro);
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 12));
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 16));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 20));
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 24));

		tamagno2.add(doce);
		tamagno2.add(dieciseis);
		tamagno2.add(veinte);
		tamagno2.add(veinticuatro);

		//------------------------------------------

		mibarra2.add(fuente2);
		mibarra2.add(estilo2);
		mibarra2.add(tamagno2);
		
		laminaMenu2.add(mibarra2); 
		
		add(laminaMenu2, BorderLayout.NORTH); //añadimos laminaMenu arriba en formato BorderLayout
		
		miarea2=new JTextPane(); //creamos el area de texto
		add(miarea2, BorderLayout.CENTER);

		//--------------Mirar ejercicio 49 para menus emergentes--------------------
		JPopupMenu emergente=new JPopupMenu();
		
		JMenuItem negritaE=new JMenuItem("Negrita"); //la E es de emergente
		JMenuItem cursivaE=new JMenuItem("Cursiva");
		
		negritaE.addActionListener(new StyledEditorKit.BoldAction()); //esto lo sacamos de este ejercicio(ver más arriba)
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());

		emergente.add(negritaE);
		emergente.add(cursivaE);

		miarea2.setComponentPopupMenu(emergente); //para que el menu emergente salga en la zona de texto
		//---------------------------------------------------------------------------
		
		
		//Barra de herramientas(ver ejercicio 50)
		
		barra=new JToolBar();
		
		configuraBarra("src/graficos/bold.png").addActionListener(new StyledEditorKit.BoldAction());
		configuraBarra("src/graficos/italic.png").addActionListener(new StyledEditorKit.ItalicAction());
		configuraBarra("src/graficos/underline.png").addActionListener(new StyledEditorKit.UnderlineAction());
		
		barra.addSeparator();
		
		configuraBarra("src/graficos/bolaAzul.gif").addActionListener(new StyledEditorKit.ForegroundAction("PonAzul", Color.BLUE));
		configuraBarra("src/graficos/bolaAmarilla.gif").addActionListener(new StyledEditorKit.ForegroundAction("PonAmarillo", Color.YELLOW));
		configuraBarra("src/graficos/bolaRoja.gif").addActionListener(new StyledEditorKit.ForegroundAction("PonRojo", Color.RED));
		
		barra.addSeparator();

		configuraBarra("src/graficos/alignLeft.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		configuraBarra("src/graficos/alignCenter.png").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		configuraBarra("src/graficos/alignRight.png").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		configuraBarra("src/graficos/alignJustify.png").addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));

		barra.setOrientation(1); //para que los botones se vayan agregando en vertical(=1) o horizontal(por defecto sino se pone nada, =0)

		add(barra, BorderLayout.WEST);
		
	}
	
	
	public JButton configuraBarra(String ruta) {
		
		JButton boton=new JButton(new ImageIcon(ruta));
		
		barra.add(boton);
		
		return boton;
	}
	
	
	public void configuraMenu2(String rotulo2, String menu2, String tipoLetra2, int estilos2, int tam2, String rutaIcono) { //creamos nuestro propio metodo
		
		JMenuItem elem_menu2=new JMenuItem(rotulo2, new ImageIcon(rutaIcono));
		
		if(menu2=="Fuente") {
			
			fuente2.add(elem_menu2);
			
			
			if(tipoLetra2=="Arial") {
				
				elem_menu2.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));

			}else if(tipoLetra2=="Courier") {
				
				elem_menu2.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Courier"));
				
			}else if(tipoLetra2=="Verdana") {
				
				elem_menu2.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Verdana"));
			}
			
			
		} else if(menu2=="Estilo") {
			
			estilo2.add(elem_menu2);
			
			if(estilos2==Font.BOLD) {
				
				elem_menu2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK)); //para atajo de teclado (ctrol+N)
				
				elem_menu2.addActionListener(new StyledEditorKit.BoldAction());

			}else if(estilos2==Font.ITALIC) {
				
				elem_menu2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK)); //para atajo de teclado (ctrol+N)

				elem_menu2.addActionListener(new StyledEditorKit.ItalicAction());
			}
			
		} else if(menu2=="Tamaño") {
			
			tamagno2.add(elem_menu2);
			
			elem_menu2.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam2)); //para que cambie el tamaño de la parte que seleccinamos y no toda
		}
		
		
		
	}
	
	
	 JTextPane miarea2;
	 JMenu fuente2, estilo2, tamagno2;
	 Font letras2;
	 JButton negritaBarra,cursivaBarra, subraBarra, azulBarra, amarilloBarra, rojoBarra, aLeft, aCenter, aRight, aJustify;
	 JToolBar barra;
	 
}


