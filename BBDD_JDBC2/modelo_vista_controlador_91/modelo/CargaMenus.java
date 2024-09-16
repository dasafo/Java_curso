/*
 *Aqui es donde se crea una clase que almacenara la informacion que sera 
 enviada a la Vista para que se muestre en los comboBox de la parte superior
 de la ventana. Aqui digamos que empaquetamos la info y en la Vista (MarcoAplicacion2)
 estara a la escucha de un evento(q a su vez estara en el Controlador y enlazara la clase de este archivo junto a la de la Vista) y asi recibir esta info y despues cargarla en la 
 vista
 */

package modelo;


import java.sql.*;


public class CargaMenus {
	
	public CargaMenus() {
		
		miConexion=new Conexion();
	}
	
  // cresmos un metodo que sea capaz de ejecutar la consulta necesaria para
  // obtener las diferentes secciones para cargar el JcomboBox
	public String ejecutaConsultas() {
		
		Productos miProducto=null;
		
    //Establecemos la conexion usando la clase creada en Conexion.java
		Connection accesoBBDD=miConexion.dameConexion();
		
		try {
			
			Statement secciones=accesoBBDD.createStatement();
			Statement paises=accesoBBDD.createStatement();

			rs=secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
			rs2=paises.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");

					
				miProducto=new Productos();
				
				miProducto.setSeccion(rs.getString(1)); //almacena la sección en miProducto
				miProducto.setpOrigen(rs2.getString(1));							
			
			rs.close();
			rs2.close();
			
			accesoBBDD.close();

		}catch(Exception e) {
			System.out.println("pooooosssss");
			
		}
		
    //que nos devuelva usando el getter para seccion de PRoductos, lo que 
    //hay almacenado dentro de miProducto
		return miProducto.getSeccion();
		
	}
	
	
	
	public Conexion miConexion;
	public ResultSet rs; //aqui guardaremos lo q nos devuelva la consulta correspondiente
	public ResultSet rs2;

}
