/*
 * Aqui es donde creamos las consultas preparadas y se prepara para mandar a la bbdd
 * la consulta elegida en los desplegables/JCombobox. Se envia mediante la clase 
 * ControladorBotonEjecuta en Controlador que se encarga de manejar los eventos
 * del boton Consulta 
 * */
package modelo;

import java.sql.*;

public class EjecutaConsultas {
	
	public EjecutaConsultas() {
		
    //Establecemos la conexion a la bbdd
		miConexion=new Conexion();
	}
	
	
  //Aqui recibe lo que el usuario a elegido en los desplegables/JCombobox
  //y actua en consecuancia segun le indicamos en esta clase
	public ResultSet filtraBBDD(String seccion, String pais) {
		
		
    //Almacenamos la conexion a la bbdd en la variable conecta de tipo Connection
		Connection conecta=miConexion.dameConexion();
		
		rs=null; //limpiamos las consultas anteriores si las hubiera
		
		try {
      //Si se elige una seccion en el JCombobox/desplegable y se deja Todos para paises...
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
			
				enviaConsultaSeccion=conecta.prepareStatement(ConsultaSeccion);
				
				enviaConsultaSeccion.setString(1, seccion);
				
				rs=enviaConsultaSeccion.executeQuery();
			
			
      // Si se elige un Pais y el otro desplegable se deja para Todos....
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				
				enviaConsultaPais=conecta.prepareStatement(ConsultaPais);
				
				enviaConsultaPais.setString(1, pais);
				
				rs=enviaConsultaPais.executeQuery();

				
			
      // Si se dejan ambos desplegables como Todos
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
