package conectaBD;
import java.sql.*;

public class ConsultaPreparada_89 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
			
			
			// 1. Crear Conexion
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );
		
			// 2. Preparar Consulta
			PreparedStatement miSentencia=miConexion.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS"
			+ " WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");
			
			// 3. Establecer los parametros de la consulta
			miSentencia.setString(1, "deportes"); //el 1 se refiere al primer interrogante de arriba, el 2 al segundo....
			miSentencia.setString(2, "USA");
			
			// 4. Ejecutar y recorrer la consulta
			ResultSet rs=miSentencia.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getString(1) + " " + 
									rs.getString(2) + " " + 
									rs.getString(3));
			}
			rs.close();
			
			//REUTILIZACION DE CONSULTA SQL(Para ver en la consulta se pueden hacer varias consultas a la vez sin necesidad de crear más consultas)
			System.out.println("");
			System.out.println("EJECUCIÓN SEGUNDA CONSULTA:");
			System.out.println("");
			
				// 3. Establecer los parametros de la consulta
					miSentencia.setString(1, "cerámica");
					miSentencia.setString(2, "China");
						
				// 4. Ejecutar y recorrer la consulta
					rs=miSentencia.executeQuery();
						
					while(rs.next()) {
							
						System.out.println(rs.getString(1) + " " + 
											rs.getString(2) + " " + 
											rs.getString(3));
					}
					rs.close();
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
