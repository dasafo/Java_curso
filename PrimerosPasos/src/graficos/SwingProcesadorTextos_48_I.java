package graficos;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class SwingProcesadorTextos_48_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MenuProcesador_I mimarco=new MenuProcesador_I();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MenuProcesador_I extends JFrame{
	
	public MenuProcesador_I() {
		
		setBounds(500,300,550,400);
		
		LaminaProcesador_I milamina=new LaminaProcesador_I();
		
		add(milamina);
		
		setVisible(true);
	}
	
}


class LaminaProcesador_I extends JPanel{
	
	public LaminaProcesador_I() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu=new JPanel();
		
		JMenuBar mibarra=new JMenuBar();
		
		//------------------------------------------
		
		fuente=new JMenu("Fuente");
		estilo=new JMenu("Estilo");
		tamagno=new JMenu("Tamaño");
		
		//------------------------------------------

		configuraMenu("Arial", "Fuente", "Arial", 9, 10);
		configuraMenu("Courier", "Fuente", "Courier", 9, 10);
		configuraMenu("Verdana", "Fuente", "Verdana", 9, 10);

		//------------------------------------------
		
		configuraMenu("Negrita", "Estilo", "", Font.BOLD, 1);
		configuraMenu("Cursiva", "Estilo", "", Font.ITALIC, 1);
		
		//------------------------------------------
		
		configuraMenu("12", "Tamaño", "", 9, 12);
		configuraMenu("16", "Tamaño", "", 9, 16);
		configuraMenu("20", "Tamaño", "", 9, 20);
		configuraMenu("24", "Tamaño", "", 9, 24);
		
		//------------------------------------------

		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamagno);
		
		laminaMenu.add(mibarra); 
		
		add(laminaMenu, BorderLayout.NORTH); //añadimos laminaMenu arriba en formato BorderLayout
		
		miarea=new JTextPane(); //creamos el area de texto
		add(miarea, BorderLayout.CENTER);

	}
	
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam) { //creamos nuestro propio metodo
		
		JMenuItem elem_menu=new JMenuItem(rotulo);
		
		if(menu=="Fuente") {
			
			fuente.add(elem_menu);
		}else if(menu=="Estilo") {
			
			estilo.add(elem_menu);
		}else if(menu=="Tamaño") {
			
			tamagno.add(elem_menu);
		}
		
		elem_menu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, tam));
		
	}
	
	private class GestionaEventos implements ActionListener{

		String tipoTexto, menu;
		
		int estiloLetra, tamagnoLetra;
		
		GestionaEventos(String elemento, String texto2, int estilo2, int tamLetra){
			
			tipoTexto=texto2;
			estiloLetra=estilo2;
			tamagnoLetra=tamLetra;
			menu=elemento;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			letras=miarea.getFont();
			
			if(menu=="Arial" || menu=="Courier" || menu=="Verdana") {
				
				estiloLetra=letras.getStyle(); //para que mantega el estilo y el tamaño
				tamagnoLetra=letras.getSize();
				
			}else if(menu=="Cursiva" || menu=="Negrita") {
				
				if(letras.getStyle()==1 || letras.getStyle()==2) { //negrita y cursiva almacenan el 1 y 2l 2(ver API)
					
					estiloLetra=3; //la suma de negrita y cursiva da =3
				}
				
				tipoTexto=letras.getFontName();
				tamagnoLetra=letras.getSize();
				
			}else if(menu=="12" || menu=="16" || menu=="20" || menu=="24") {
				
				estiloLetra=letras.getStyle();
				tipoTexto=letras.getFontName();
			}
			
			miarea.setFont(new Font(tipoTexto, estiloLetra ,tamagnoLetra));
			
			System.out.println("Tipo: " + tipoTexto + " Estilo: " + estiloLetra + " Tamaño: " + tamagnoLetra);
		}
		
		
	}
	
	
	 JTextPane miarea;
	 JMenu fuente, estilo, tamagno;
	 Font letras;
	
}


