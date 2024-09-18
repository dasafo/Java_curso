/*********************************************************************************************************
 * 
 * Los MetaDatos son datos que describen la BBDD o alguna de sus partes. 
 * Son importantes cuando creamos Apps genericas. Apps que son capaces de 
 * conecatrse con cualquier BBDD y hacer consultas en cualquier tabla de 
 * esa BBDD
 *
 * Hay 3 clases:
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

  // Creamos un metodo que nos devuelve la info de la BBDD, es static porque el metodo desde
  // el que llamamos a este metodo es el main de arriba y es statico
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
	
	
	
  // Creamos un segundo metodo que nos dara informacion de los metadatos de las tablas(tambien static)
	static void mostrarInfoTabla() {
		
		Connection miConexion=null;
		ResultSet miResultSet=null;

		
			try {
			
				miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );

				//Obtencion de MetaDAtos
				DatabaseMetaData datosBBDD=miConexion.getMetaData();
				
				//-------Lista de nombres de las Tablas(getTables)--------
				System.out.println("Lista de tablas");
				
        //Almacenamos en miResultSet los metadatos referentes a todas las tablas
				// miResultSet=datosBBDD.getTables(null, null, "p%", null); //p% para que busque las tablas que empiecen por p
				miResultSet=datosBBDD.getTables(null, null, null, null); 

				System.out.println("");

        // Recorremos usando el ResultSet el nombre de las tablas de la BBDD
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
