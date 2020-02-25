package modelo;


import java.sql.*;


public class CargaMenus {
	
	public CargaMenus() {
		
		miConexion=new Conexion();
	}
	
	public String ejecutaConsultas() {
		
		Productos miProducto=null;
		
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
		
		return miProducto.getSeccion();
		
	}
	
	
	
	public Conexion miConexion;
	public ResultSet rs;
	public ResultSet rs2;

}
