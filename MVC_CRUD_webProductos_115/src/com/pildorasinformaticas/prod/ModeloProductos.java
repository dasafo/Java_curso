/****************************************************************************************************
 * Hoja de Ruta para este MVC, el cual consisitrá en hacer consultas CRUD 
 * (Create, Read, Update, Delete)
 * 
 * 		
 * 	1- Crear objetos de tipo Productos para poder manipularlos *Productos.java*
 * 	2- Crear un Modelo(BBDD). Es el archvo Java pertienente, encargado de
 * 		   de conectar con las BBDD y de crear los registros que se pidan. *ModeloProductos.java*
 * 	3- Crear un controlador (Servlet). Encargado de obtener dichos registros y 
 *  	   mandarlos a la Vista(JSP) *ControladorProductos.java*
 *  4- Crear la página JSP. Que es la interfaz que el usuario vera finalmente. *ListaProductos.jsp*
 * 
 ***************************************************************************************************/

package com.pildorasinformaticas.prod;


import java.util.*;
import java.sql.*;
import javax.sql.DataSource;
import java.util.Date;

public class ModeloProductos {
	
	private DataSource origenDatos; //variable encargada de almacenar el Conexion Pool
	
	public ModeloProductos(DataSource origenDatos) {
		
		this.origenDatos=origenDatos;
		
	}
	
	//El dato que nos devuelva sera una lista. Le decimos a nuestro modelo que nos
	// devuelva una lista de tipo Productos
	public List<Productos> getProductos() throws Exception{
		
		List<Productos> productos=new ArrayList<>();
		
		Connection miConexion=null;
		Statement miStatement=null;
		ResultSet miResultset=null;
		
		//----- 1. Establecer la conexion
		
		miConexion=origenDatos.getConnection(); //los datos de la conexion estan en el Pool de datos(origenDatos)
		
		//------ 2. Crear la sentencia SQL y el Statement
		
		String instruccionSql="SELECT * FROM PRODUCTOS";
		
		miStatement=miConexion.createStatement();
				
		//------- 3. Ejecutar SQL
		
		miResultset=miStatement.executeQuery(instruccionSql);
		
		//------- 4. Recorrer el REsultSet(tabla virtual conregristros) obtenido
		
		while(miResultset.next()) { //recorremos el REsultset
			
			String c_art=miResultset.getString("CÓDIGOARTÍCULO");
			String seccion=miResultset.getString("SECCIÓN");
			String n_art=miResultset.getString("NOMBREARTÍCULO");
			
			double precio=miResultset.getDouble("PRECIO");
			Date fecha=miResultset.getDate("FECHA");
			
			String importado=miResultset.getString("IMPORTADO");
			String p_orig=miResultset.getString("PAÍSDEORIGEN");

			//en cada vuelta se guarda en la variable temporal temProd los datos ...
			Productos temProd=new Productos(c_art, seccion, n_art, precio, fecha, importado, p_orig);
			
			productos.add(temProd); //...y se añaden a miResultset
			
						
		}
		
		return productos; //que nos devuelva el listado
		
	}

	public void agregarElNuevoProducto(Productos nuevoProducto) throws Exception{
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		
		
		//---- 1. Obtener la conexion con la BBDD
		
		try {
			
			miConexion=origenDatos.getConnection();
			
		
		
		//---- 2. Crear instruccion SQL que inserte el producto. Crear la consulta preparada(statement)
		
		String sql="INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSDEORIGEN)" + 
		"VALUES(?,?,?,?,?,?,?)";
		
		miStatement=miConexion.prepareStatement(sql);
		
		//---- 3. establecer paramentro para el producto
		
		miStatement.setString(1, nuevoProducto.getcArt());
		miStatement.setString(2, nuevoProducto.getSeccion());
		miStatement.setString(3, nuevoProducto.getnArt());
		miStatement.setDouble(4, nuevoProducto.getPrecio());
		//____Hay que pasar el Date de java.util(getFecha) a un Date de java.sql(setDate) 
		//que no trabaja con horas solo fecha
		java.util.Date utilDate=nuevoProducto.getFecha();
		java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
		miStatement.setDate(5, fechaConvertida);
		//________________________________________________________________________________
		miStatement.setString(6, nuevoProducto.getImportado());
		miStatement.setString(7, nuevoProducto.getpOrig());

		
		//---- 4. Ejecutar la instrucion SQL
		
		miStatement.execute();
		
		//-----------------------------------------------------------------------
		
		}finally {
			
			miStatement.close();
			miConexion.close();
			
		}
		
	}

	public Productos getProducto(String codigoArticulo) {
		// TODO Auto-generated method stub
		
		Productos elProducto=null;
		
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		
		ResultSet miResultset=null;
		
		String cArticulo=codigoArticulo;
		
		try {
		
		//-------- 1. Establecer la conexion con la BBDD
		
		miConexion=origenDatos.getConnection();
		
		//-------- 2. Crear SQL que busque el producto
		
		String sql="SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
		
		//-------- 3. Crear la consulta preparada
		
		miStatement=miConexion.prepareStatement(sql);
		
		//-------- 4.Establecer los parámetros de esa consulta
		
		miStatement.setString(1, cArticulo);
		
		//-------- 5. Ejecutar la consulta
		
		miResultset=miStatement.executeQuery();
		
		//-------- 6. Obtener los datos de respuesta
		
		if(miResultset.next()) {
			
			String c_Art=miResultset.getString("CÓDIGOARTÍCULO");
			String seccion=miResultset.getString("SECCIÓN");
			String n_art=miResultset.getString("NOMBREARTÍCULO");
			
			double precio=miResultset.getDouble("PRECIO");
			Date fecha=miResultset.getDate("FECHA");
			
			String importado=miResultset.getString("IMPORTADO");
			String p_orig=miResultset.getString("PAÍSDEORIGEN");

			
			elProducto=new Productos(c_Art, seccion, n_art, precio, fecha, importado, p_orig);
			
		}else {
			
			throw new Exception("No hemos encontrado el producto con código artículo= " + cArticulo);
		}
				
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return elProducto;
	}

	public void actualizarProducto(Productos productoActualizado) throws Exception{
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		PreparedStatement miStatement=null;

		//-------1. Establecer la conexion con la BBDD
		
		try {
		miConexion=origenDatos.getConnection();
		
		//-------2. Crear SQL que busque el producto
		
		String sql="UPDATE PRODUCTOS SET SECCIÓN=?, NOMBREARTÍCULO=?, PRECIO=?, FECHA=?, IMPORTADO=?, PAÍSDEORIGEN=? WHERE CÓDIGOARTÍCULO=?";
		

		//-------3. Crear la consulta preparada
		
		miStatement=miConexion.prepareStatement(sql);
		
		//-------4. Establecer los parámetros
		
		miStatement.setString(1, productoActualizado.getSeccion());
		miStatement.setString(2, productoActualizado.getnArt());
		miStatement.setDouble(3, productoActualizado.getPrecio());
		//--Hay que pasar el Date de java.util(getFecha) a un Date de java.sql(setDate) que no trabaja con horas solo fecha
		java.util.Date utilDate=productoActualizado.getFecha();
		java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
		miStatement.setDate(4, fechaConvertida);
		//--------------------------------------------------------------------------------------------------------------
		miStatement.setString(5, productoActualizado.getImportado());
		miStatement.setString(6, productoActualizado.getpOrig());
		miStatement.setString(7, productoActualizado.getcArt());
		
		//-------5. Ejecutar la instruccion SQL

		miStatement.execute();
		}finally {
			
			miStatement.close();
			miConexion.close();
			
		}

	}

	public void eliminarProducto(String codArticulo) throws Exception{
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		PreparedStatement miStatement=null;

		//-------1. Establecer la conexion con la BBDD
		
		try {
		miConexion=origenDatos.getConnection();
		
		//-------2. Crear instuccion SQL de eliminacion
		
		String sql="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
		
		//-------3. Preparar o crear la consulta
		
		miStatement=miConexion.prepareStatement(sql);
		
		//-------4. Establecer parámetros de consulta
		
		miStatement.setString(1, codArticulo);
		
		//-------5. Ejecutar sentencia SQL
		
		miStatement.execute();
		
		}finally {
			
			miStatement.close();
			miConexion.close();
			
		}
		
	}
	
	
	

}
