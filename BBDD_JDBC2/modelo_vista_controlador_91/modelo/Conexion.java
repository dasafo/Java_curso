package modelo;

import java.sql.*;

public class Conexion {
	
	Connection miConexion=null;
	
	public Conexion() {
		
		
	}
	
	public Connection dameConexion() {
		
		try {
			
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );
		
		}catch(Exception e) {
			System.out.println("hjdsghfdksjfhksd");
		}
		
		return miConexion;
	}

}
