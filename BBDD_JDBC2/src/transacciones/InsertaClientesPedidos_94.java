/***************************************************************************************************
 * Las Transacciones son instrucciones SQL que cada vez que se ejecutan tienen que
 * ejecutarse todas a la vez.
 * 
 * Una Transaccion es solo una unidad de trabajo, q son varias instrucciones SQL
 * trabajando en quipo
 * Inicio_transaccion -> SQL1 -> SQL2 -> SQL3... -> BBDD
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
			
			//Para que trate nuestras instrucciones SQL como un solo bloque-false(Transacciones: o se ejecuta todo o nada)
			//si es true(por defecto, no haría falta poner setAutoComit, ejecuta cada código SQL independientemente.
			miConexion.setAutoCommit(false);

      Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="INSERT INTO clientes (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";
			    
		    miStatement.executeUpdate(instruccionSql_1);
			    
		    String instruccionSql_2="INSERT INTO pedidos (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";
			    
		    miStatement.executeUpdate(instruccionSql_2);
		    				    
        //Para dar el 'OK' a todo este bloque de instrucciones SQL
        //una vez ha visto que no hay errores en ninguna de las consultas SQL
		    miConexion.commit(); 		    
		   
		    System.out.println("Datos INSERTADOS correctamente");
				
		}catch(Exception e){
				
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
				
			try {
        //para que deje la BBDD como esta si hay un error a la hora de aplicar el SQL(está dentro de una excepcion try-catch
        //Queremos que inserte ambas instruccions, con que una falle le decimos que vuelva a la configuracion incial
				miConexion.rollback();

      } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();	
				
				
			}

		}

	}
