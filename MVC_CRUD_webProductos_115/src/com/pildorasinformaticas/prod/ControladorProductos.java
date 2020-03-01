package com.pildorasinformaticas.prod;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloProductos modeloProductos;
	
	@Resource(name="jdbc/Productos")
	private DataSource miPool;
	
	//------Botoń derecho Source--->Override/implements Methods-->GeneritServlet()---->Init()--------------
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
		modeloProductos=new ModeloProductos(miPool);
		}catch(Exception e) {
			
			throw new ServletException(e);
		}
		
		
		}

	//---------------------------------------------------------------------------------------------
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Leer el parametro que llega desde el formulario
		
		String elComando=request.getParameter("instruccion");
		
		//sino se envia el parametro, listar productos
		
		if(elComando==null) elComando="listar"; //sera nulo seguro la primera vez que se ejecute, ya que el formulario será nulo
		
		//Redirigir el flujo de ejecucion al método adecuado
		
		switch(elComando) {
		
		case "listar":
			
			obtenerProductos(request, response);
			
			break;
			
		case "insertarBBDD":
			
			agregarProductos(request, response);
			
			break;
			
		case "cargar":
			
			try {
				cargaProductos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "actualizarBBDD":
			
			try {
				actualizaProductos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "eliminar":
			
			try {
				eliminarProducto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		default:
			
			obtenerProductos(request, response);

		}		
		
		
	}
	
	

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		//Caputar el codigo artículo
		
		String CodArticulo=request.getParameter("cArt");

		//Borrar el producto de la BBDD
		
		modeloProductos.eliminarProducto(CodArticulo);
		
		//Volver a la lista de Productos
		
		obtenerProductos(request, response);

		
		
	}

	private void actualizaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		//leer los datos que le vienen del formulario Actualizar
		
		String CodArticulo=request.getParameter("cArt");
		String Seccion=request.getParameter("seccion");
		String NombreArticulo=request.getParameter("nArt");
		//------Para pasar el String que devuelve el getParameter a formato Fecha----------
		SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
		Date Fecha=null;
		try {
			Fecha=formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------------------------
		double Precio=Double.parseDouble(request.getParameter("precio"));  //con Double.parseDouble convertimos el String que devuelve getParameter en Double
		String Importado=request.getParameter("importado");
		String PaisOrigen=request.getParameter("pOrig");
		
		//Crear objeto de tipo Producto con la info del formulario
		
		Productos ProductoActualizado=new Productos(CodArticulo, Seccion, NombreArticulo, Precio, Fecha, Importado, PaisOrigen);
		
		//Actualizar la BBDD con la info del obj Producto
		
		modeloProductos.actualizarProducto(ProductoActualizado);
		
		//Volver al listado con la info actualizada
		
		obtenerProductos(request, response);
		
	}

	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		//Leer el codigo articulo que viene del listado
		
		String codigoArticulo=request.getParameter("cArt");
		
		//Comuicar con el modelo para que envia el codigo articulo a modelo
		
		Productos elProducto=modeloProductos.getProducto(codigoArticulo);
		
		//Esstablecer el atributo correspondiente a Codigo Articulo
		
		request.setAttribute("ProductoActualizar", elProducto);
		
		//Enviar la informacion Producto al formulario de Actualizar
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizarProducto.jsp");
		
		dispatcher.forward(request, response);
		
	}

	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//Leer la info del producto del formulario
		
		String CodArticulo=request.getParameter("cArt");
		String Seccion=request.getParameter("seccion");
		String NombreArticulo=request.getParameter("nArt");
		//------Para pasar el String que devuelve el getParameter a formato Fecha----------
		SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
		Date Fecha=null;
		try {
			Fecha=formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------------------------
		double Precio=Double.parseDouble(request.getParameter("precio"));  //con Double.parseDouble convertimos el String que devuelve getParameter en Double
		String Importado=request.getParameter("importado");
		String PaisOrigen=request.getParameter("pOrig");
		
		//Crear un obj de tipo Poducto
		
		Productos NuevoProducto=new Productos(CodArticulo, Seccion, NombreArticulo, Precio, Fecha, Importado, PaisOrigen);
		
		//Enviar el obj al modelo y después insertar el obj Producto en la BBDD
		
		try {
			modeloProductos.agregarElNuevoProducto(NuevoProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Volver al listado Productos
		
		obtenerProductos(request, response);

		
	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//Obtener la lista de productos desde el modelo

		List<Productos> productos; //creamos una lista de Productos 
		
		try {
			
			productos=modeloProductos.getProductos(); 	//almacenamos en esa lista productos lo que hay en modeloProductos
		
		
		//Agreagar lista de Productos al request
			
			request.setAttribute("LISTAPRODUCTOS", productos);
		
		//enviar ese request a la pagina JSP
			
			RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListaProductos.jsp");
			
			miDispatcher.forward(request, response);
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
}
