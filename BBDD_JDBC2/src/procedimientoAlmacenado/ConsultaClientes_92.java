package procedimientoAlmacenado;

import java.sql.*;

public class ConsultaClientes_92 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );

			CallableStatement miSentencia=miConexion.prepareCall("{call MUESTRA_CLIENTES}"); //CallableSatetement para llamar a procedimientos creados con SQL en la BBDD
																							 //Para crear el procedimiento MUESTRA_CLIENTES en SQL se ha puesto en phpmyadmin esto: 
																						     // CREATE PROCEDURE MUESTRA_CLIENTE() SELECT * FROM CLIENTES WHERE POBLACIÓN='BARCELONA'
			
			ResultSet rs=miSentencia.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			
		}

	}

}
