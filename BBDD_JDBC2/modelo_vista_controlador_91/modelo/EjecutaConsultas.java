package modelo;

import java.sql.*;

public class EjecutaConsultas {
	
	public EjecutaConsultas() {
		
		miConexion=new Conexion();
	}
	
	
	public ResultSet filtraBBDD(String seccion, String pais) {
		
		
		Connection conecta=miConexion.dameConexion();
		
		rs=null;
		
		try {
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
			
				enviaConsultaSeccion=conecta.prepareStatement(ConsultaSeccion);
				
				enviaConsultaSeccion.setString(1, seccion);
				
				rs=enviaConsultaSeccion.executeQuery();
			
			
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				
				enviaConsultaPais=conecta.prepareStatement(ConsultaPais);
				
				enviaConsultaPais.setString(1, pais);
				
				rs=enviaConsultaPais.executeQuery();

				
			
			}else {
				
				enviaConsultaTodos=conecta.prepareStatement(ConsultaTodos);
				
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);

				rs=enviaConsultaTodos.executeQuery();
				}
		
		}catch(Exception e) {
			
			System.out.println("BRRRRRR");
		}
		
		return rs;
		
	}
	
	private Conexion miConexion;
	
	private ResultSet rs;
	
	private PreparedStatement enviaConsultaSeccion;
	
	private final String ConsultaSeccion="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	
	private PreparedStatement enviaConsultaPais;
	
	private final String ConsultaPais="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	
	private PreparedStatement enviaConsultaTodos;
	
	private final String ConsultaTodos="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";

	
}
