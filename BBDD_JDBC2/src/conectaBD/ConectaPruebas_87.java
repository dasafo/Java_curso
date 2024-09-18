/***************************************************************
 * - Proceso de acceso a una BBDD:
 * 
 *		1- Establecer conexión con la BBDD
 *		2- Crear un objeto Statement
 *		3- Ejecutar sentencia SQL
 *		4- Leer el resultset 		
 * 
 ***************************************************************/

package conectaBD;

import java.sql.*;

public class ConectaPruebas_87 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			// 1. Crear Conexión
      // ---> Para MySQL
			//Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );

      // ---> Para PostgreSQL
			Connection miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/curso_bbdd?ssl=false", "pildoras", "freedom85");

			// 2. Crear objeto STATEMENT
			Statement miStatement=miConexion.createStatement();
			
			// 3. Ejecutar SQL
			ResultSet miResultset=miStatement.executeQuery("SELECT * FROM productos");
			
			// 4. REcorrer el REsultSet
			while(miResultset.next()) { //mientras exista otro registro en la tabla(PRODUCTOS) haz..
			/*	
       //Para el formato de nombres que tenemos en PhpmyAdmin de MySQL
				System.out.println(
          miResultset.getString("NOMBREARTÍCULO") + " " 
						+ miResultset.getString("CÓDIGOARTÍCULO") + " " 
						+ miResultset.getDouble("PRECIO")*2 + " "
						+ miResultset.getDate("FECHA")
						
						);
        */
        // Para el formato de nombres que tenemos en PostgreSQL
				System.out.println(
          miResultset.getString("nombrearticulo") + " " 
						+ miResultset.getString("codigoarticulo") + " " 
						+ miResultset.getDouble("precio")*2 + " "
						+ miResultset.getDate("fecha")
						
						);
				

			}
			
		}catch(Exception e) {
			
			System.out.println("NO CONECTA!!");
			
			e.printStackTrace();
			
		}

	}


}
