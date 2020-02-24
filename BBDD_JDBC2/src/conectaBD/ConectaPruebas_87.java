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
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );
			
			// 2. Crear objeto STATEMENT
			Statement miStatement=miConexion.createStatement();
			
			// 3. Ejecutar SQL
			ResultSet miResultset=miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
			// 4. REcorrer el REsultSet
			while(miResultset.next()) { //mientras exista otro registro en la tabla(PRODUCTOS) haz..
				
				System.out.println(miResultset.getString("NOMBREARTÍCULO") + " " 
				
						+ miResultset.getString("CÓDIGOARTÍCULO") + " " 
						+ miResultset.getDouble("PRECIO")*2 + " "
						+ miResultset.getDate("FECHA")
						
						);
				
			}
			
		}catch(Exception e) {
			
			System.out.println("NO CONECTA!!");
			
			e.printStackTrace();
			
		}

	}


}
