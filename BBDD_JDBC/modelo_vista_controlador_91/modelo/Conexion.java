package modelo;

import java.sql.*;

public class Conexion {
	
	Connection miConexion=null;
	
	public Conexion() {
		
		
	}
	
	public Connection dameConexion() {
		
		try {
			
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?useSSL=false", "root", "Kromosoma_85" );
		
		}catch(Exception e) {
			
		}
		
		return miConexion;
	}

}
