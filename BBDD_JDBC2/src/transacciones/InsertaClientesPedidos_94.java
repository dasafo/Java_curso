/***************************************************************************************************
 * Las Transacciones son instrucciones SQL que cada vez que se ejecutan tienen que
 * ejecutarse todas a la vez.
 * 
 * Las transacciones garantizan en una BBDD las caracteristicas ACID:
 * - Atomicidad : O ejecutas o todo o nada.
 * - Consistencia : Integridad de los datos. Si hay un fallo, las tareas realizas son revertidas.
 * - Aislamiento
 * - Durabilidad
 * 
 * Metodos usados para Transacciones:
 * 	-> M_setAutoCommit() : Indica que las instrucciones SQL pueden ser tratadas como un bloque(False)
 * 	-> M_commit() : Confirma el bloque de intrucciones o transaccion
 * 	-> M_rollBack() : Garantiza la integridad de los datos. Si falla algo revierte todos los cambios.
 * 
 ****************************************************************************************************/

package transacciones;

import java.sql.*;
import java.time.chrono.MinguoChronology;

public class InsertaClientesPedidos_94 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		Connection miConexion=null;
		try{					
				
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );
			
			
			miConexion.setAutoCommit(false);//Para que trate nuestras instrucciones SQL como un solo bloque-false(Transacciones: o se ejecuta todo o nada)
											//si es true(por defecto, no haría falta poner setAutoComit, ejecuta cada código SQL independientemente.
			Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="INSERT INTO clientes (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";
			    
		    miStatement.executeUpdate(instruccionSql_1);
			    
		    String instruccionSql_2="INSERT INTO pedidos (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";
			    
		    miStatement.executeUpdate(instruccionSql_2);
		    				    
		    miConexion.commit(); //Para dar el 'OK' a todo este bloque de instrucciones SQL
		    
		   
		    System.out.println("Datos INSERTADOS correctamente");
				
		}catch(Exception e){
				
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
				
			try {
				miConexion.rollback(); //para que deje la BBDD como esta si hay un error a la hora de aplicar el SQL(está dentro de una excepcion try-catch
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();	
				
				
			}

		}

	}
