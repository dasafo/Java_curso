package procedimientoAlmacenado;

import java.sql.*;

import javax.swing.JOptionPane;

public class ActualizaProductos_93 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double nPrecio=Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
		
		String nArticulo=JOptionPane.showInputDialog("Introduce nombre artículo:");
		
		try {
			
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?useSSL=false", "root", "Kromosoma_85" );

			CallableStatement miSentencia=miConexion.prepareCall("{call ACTUALIZA_PROD(?,?)}"); //CallableSatetement para llamar a procedimientos creados con SQL en la BBDD
																							 //Para crear el procedimiento ACTUALIZA_PROD en SQL se ha puesto en phpmyadmin esto: 
																						     // CREATE PROCEDURE ACTUALIZA_PROD(N_PRECIO DOUBLE(10.2), N_ART VARCHAR(20)) UPDATE PRODUCTOS SET PRECIO=N_PRECIO WHERE NOMBREARTÍCULO=N_ART;
		
			miSentencia.setDouble(1, nPrecio);
			miSentencia.setString(2, nArticulo);
			
			miSentencia.execute();
			
			System.out.println("Actualizacion OK");

		}catch(Exception e) {
			
		}
			

	}

}
