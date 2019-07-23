package metaDatos;

import java.sql.*;

public class InfoMetaDatos_96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//mostrarInfoBBDD();
		mostrarInfoTabla();
	}

	static void mostrarInfoBBDD() {
		
		Connection miConexion=null;

		
		try {
			
		miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?useSSL=false", "root", "Kromosoma_85" );

		//Obtencion de MetaDAtos
		
		DatabaseMetaData datosBBDD=miConexion.getMetaData();
		
		//Mostrar informacion de la BBDD
		
		System.out.println("Gestor de BBDD: " + datosBBDD.getDatabaseProductName());
		
		System.out.println("Versión del gestor: " + datosBBDD.getDatabaseProductVersion());
		
		System.out.println("Nombre del Driver: " + datosBBDD.getDriverName());
		
		System.out.println("Versión del Driver: " + datosBBDD.getDriverVersion());

		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	static void mostrarInfoTabla() {
		
		Connection miConexion=null;
		ResultSet miResultSet=null;

		
			try {
			
				miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?useSSL=false", "root", "Kromosoma_85" );

				//Obtencion de MetaDAtos
		
				DatabaseMetaData datosBBDD=miConexion.getMetaData();
				
				//-------Lista de nombres de las Tablas(getTables)--------
				
				System.out.println("Lista de tablas");
				
				// miResultSet=datosBBDD.getTables(null, null, "p%", null); //p% para que busque las tablas que empiecen por p
				miResultSet=datosBBDD.getTables(null, null, null, null); 


				while(miResultSet.next()) {
					
					System.out.println(miResultSet.getString("TABLE_NAME")); //para que muestre el nombre de las Tablas de pruebas de la BBDD
				}
				
				//------Lista de columnas de productos(getColumns)--------
				
				System.out.println("");
				System.out.println("Campos de PRODUCTOS");
				miResultSet=datosBBDD.getColumns(null, null, "PRODUCTOS", null); //para que nos muestre solo las de la tabla PRODUCTOS


				while(miResultSet.next()) {
					
					System.out.println(miResultSet.getString("COLUMN_NAME")); //para que muestre el nombre de las Tablas de pruebas de la BBDD
				}
				
				
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}finally {
				
				try {
					miConexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
	
}
