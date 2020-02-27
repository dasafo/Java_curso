/*********************************************************************************************************
 * 
 * Los MetaDatos son datos que describen la BBDD o alguna de sus partes. Hay 3 clases:
 * 
 *  - Relativos a la BBDD:
 *  	-> Gestor de BBDD
 *  	-> Versión del gestor
 *  	-> Driver de conexion a BBDD
 *  	-> Version del Driver
 *  
 *  - Relativos a un conjunto de resultados:
 *  	-> Nombres de las Tablas
 *  	-> Nombres de los campos de las Tablas
 *  	-> Tipo de datos de los campos
 *  	-> Propiedades de los campos
 *  
 *  - Relativos a parámetros de sentencias preparadas
 *  
 * Obtenemos los MetaDatos mediate: 
 * 
 * 		I_Connection
 * 			-> M_getMetaData()
 * 				--> I_DatabaseMetaData
 * 					---> M_getDatabaseProductName(), M_getDatabaseProductVersion(), M_getDriverName()
 * 						 M_getDriverVersion(), M_getTables(), M_ getString(), M_ getColumns(),
 * 						 .......
 * 					
 ******************************************************************************************************/

package metadatos;

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
			
		miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );

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
			
				miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );

				//Obtencion de MetaDAtos
		
				DatabaseMetaData datosBBDD=miConexion.getMetaData();
				
				//-------Lista de nombres de las Tablas(getTables)--------
				
				System.out.println("Lista de tablas");
				
				// miResultSet=datosBBDD.getTables(null, null, "p%", null); //p% para que busque las tablas que empiecen por p
				miResultSet=datosBBDD.getTables(null, null, null, null); 

				System.out.println("");

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
