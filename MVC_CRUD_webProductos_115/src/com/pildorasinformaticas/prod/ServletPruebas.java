package com.pildorasinformaticas.prod;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jdbc.pool.DataSource;
// import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Definir o establcer el DataSource de nuestro Connection Pool,
		//fabricado en el archivo WebContent/META_INF/context.xml
		
	@Resource(name="jdbc/Productos") //nombre identificatvo del Connection Pool
	private DataSource miPool;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// Crear el obj printWriter
		PrintWriter salida=response.getWriter();
				
		//Le decimos que la respuesta será de tipo texto plano
		response.setContentType("text/plain");
				
		// Crear conexion BBDD
				
		Connection miConexion=null;
				
		Statement miStatement=null;
				
		ResultSet miResultset=null;
				
		try {
					
			miConexion=miPool.getConnection(); //hemos conectado el pull de conexiones para contactar con la BBDD
					
			String miSql="SELECT * FROM PRODUCTOS";
					
			miStatement=miConexion.createStatement();
					
			miResultset=miStatement.executeQuery(miSql);
					
			while(miResultset.next()) {
						
			String nombre_articulo=miResultset.getString(3); //3 para que pille el nombre de los artículos(tercera columna de PRODUCTOS)
						
			salida.println(nombre_articulo);
					
			}
					
			}catch(Exception e) {
					
				e.printStackTrace();
			}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
