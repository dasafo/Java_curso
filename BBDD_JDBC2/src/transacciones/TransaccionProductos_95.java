package transacciones;

import java.sql.*;

import javax.swing.JOptionPane;

public class TransaccionProductos_95 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		
		try{					
				
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?useSSL=false", "root", "Kromosoma_85" );
			
			
			miConexion.setAutoCommit(false);//Para que trate nuestras instrucciones SQL como un solo bloque-false(Transacciones: o se ejecuta todo o nada)
											//si es true(por defecto, no haría falta poner setAutoComit, ejecuta cada código SQL independientemente.
			Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN='ITALIA'"; //borrar los prouctos de Italia	   			    
		    String instruccionSql_2="DELETE FROM PRODUCTOS WHERE PRECIO>300"; //después que borre los productos con un precio mayor de 300
		    String instruccionSql_3="UPDATE PRODUCTOS SET PRECIO=PRECIO*1.15"; // y después con los productos que queden, aumentarlos un 15%
		    
		    boolean ejecutar=ejecutarTransaccion();
		    
		    if(ejecutar) {
		    
		    miStatement.executeUpdate(instruccionSql_1);
		    miStatement.executeUpdate(instruccionSql_2);
		    miStatement.executeUpdate(instruccionSql_3);
		    
		    miConexion.commit(); //para dar el OK a la transaccion(bloque)
		    
		    System.out.println("Se ejecutó la transacción CORRECTAMENTE");
		    
		    }else {
		    	
		    	System.out.println("NO se ejecutó la BBDD");
		    }
		    
		}catch(Exception e) {
			
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
	
	static boolean ejecutarTransaccion() {
		
		String ejecucion=JOptionPane.showInputDialog("¿Ejecutamos transacción?");
		
		if(ejecucion.equals("Si")) return true;
		
		else return false;
		
	}

}