/*
 * Aqui es donde se manejaran los eventos de los JComboBox que vienen del modelo
 * y se envian a la vista para que sean cargados en dichos desplegables.
 * */

package controlador;

import java.awt.event.*;

import modelo.*;

import vista.*;

//Aqui necesitaremos acceder tanto a la info cargada en CargaMenus.java, como
//a la Vista de MarcoAplicacion2 por eso instanciamos objetos de dichas 
//clases(obj y elmarco)
	

//usamos la interfe adaptadora (extends WindowAdapter) en vez de (implements
//WindowListener)para no tener que poner todos los metodos de esta ultima
public class ControladorCargaMenus extends WindowAdapter{ 

  // Para poder cargar el JComboBox que se encuentra en MarcoAplicacion2
  // necesitamos pasarle a esta clase el objeto elmarco
  public ControladorCargaMenus(MarcoAplicacion2 elmarco) {
		
		this.elmarco=elmarco;
	}
	
	
  //Para manejar los eventos al abrir la ventana
  public void windowOpened(WindowEvent e) {
		
    //Primero que nos cargue todo lo que ha devuelto la consulta SQL y que vienen
    //empaquetada en el metodo ejecutaConsultas de la clase CargaMenus
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
	
  //Creamos las dos instancias pertenecientes a las clases que conectamos atraves
  //de esta clase que hemos construido
	CargaMenus obj=new CargaMenus();
	private MarcoAplicacion2 elmarco;
	
}
