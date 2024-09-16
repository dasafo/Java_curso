/*
* Aqui es donde se establece la conexion a la bbdd
 * */

package modelo;

import java.sql.*;

public class Conexion {
	
	Connection miConexion=null;
	
	public Conexion() {
		
		
	}
	
  // Creamos un metodo de tipo Connection para llamarlo cada vez que queramos
  // conectarnos con la bbdd
	public Connection dameConexion() {
		
		try {
			
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );
		
		}catch(Exception e) {
			System.out.println("hjdsghfdksjfhksd");
		}
		
		return miConexion;
	}

}
