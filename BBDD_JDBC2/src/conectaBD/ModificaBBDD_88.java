package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBBDD_88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			
			// 1. Crear Conexión
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );
			
			// 2. Crear objeto STATEMENT
			Statement miStatement=miConexion.createStatement();
			
			//String instruccionSql="INSERT INTO PRODUCTOS(CÓDIGOARTÍCULO,NOMBREARTÍCULO, PRECIO) VALUES ('AR77', ' PANTALÓN', 25.35)"; //insertar un valor a la tabla
			//String instruccionSql="UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";  //multiplicar por 2 el precio del artículo AR77
			String instruccionSql="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77'"; //borrar el artículo AR77 de PRODUCTOS

			miStatement.executeUpdate(instruccionSql);
			
			 //System.out.println("Datos INSERTADOS correctamente");
			//System.out.println("Datos MODIFICADOS correctamente");
		System.out.println("Datos ELIMINADOS correctamente");

		}catch(Exception e) {
			
			System.out.println("NO CONECTA!!");
			
			e.printStackTrace();
			
		}

	
	}

}
