package controlador;

import java.awt.event.*;

import modelo.*;

import vista.*;

public class ControladorCargaMenus extends WindowAdapter{ //usamos la interfe adaptadora (extends WindowAdapter) en vez de (implements WindowListener) 
																 //para no tener que poner todos los metodos de esta ultima
	
	public ControladorCargaMenus(MarcoAplicacion2 elmarco) {
		
		this.elmarco=elmarco;
	}
	
	
	public void windowOpened(WindowEvent e) {
		
		obj.ejecutaConsultas();
		
		try {
		
			while(obj.rs.next()) { //a cada vuelta del bucle guaramos el elemento y lo mentemos en el JComboBox de MarcoAplicacion
			
				elmarco.secciones.addItem(obj.rs.getString(1));
			
			}
			while(obj.rs2.next()) { //a cada vuelta del bucle guaramos el elemento y lo mentemos en el JComboBox de MarcoAplicacion
				
				elmarco.paises.addItem(obj.rs2.getString(1));
			
			}
		}catch(Exception e2) {
			
			e2.printStackTrace();
			System.out.println("uuuuuueeeee");
			
		}
		
	}
	
	CargaMenus obj=new CargaMenus();
	
	private MarcoAplicacion2 elmarco;
	
}
