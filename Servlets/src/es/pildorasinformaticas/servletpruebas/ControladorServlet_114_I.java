/*************************************** Servlets ***************************************************
 * 
 * - Son programas Java que se ejecutan en un servidor web
 * - Reciben una peticion del cliente (navegador) y realiza tareas como:
 * 	
 * 		-> Generar una respuesta HTML
 * 		-> Llamar a otros Servlets
 * 		-> Utilizar Cookies y sesiones
 * 		-> Enlace (controlador) entre el cliente y la BBDD
 * 
 * - A diferencia de los JSP que son HTML+Codigo Java, un Servlet solo tiene
 *  codigo Java que produce el código HTML que será el código mandado al usuario
 *  
 * - Pasos para crear Servlets:
 * 
 * 		1- Creación de clase que herede de:
 * 
 * 			-> I_Servlet
 * 				--> C_HttpServlet
 * 					---> M_ doGet(request,response) * Encargado de recibir la peticion (request)
 * 						.......
 * 
 * 			-> I_HttpServletResponse
 * 				--> I_ServletResponse
 * 					---> M_getWriter()	
 * 						----> C_PrintWriter()
 * 
 *  	2- Establecer el formato de la respuesta (html)
 *  
 *  	3- Generar el contenido de la respuesta (html)
 *  
 * - Cuando un usuario manda una peticion (request) al Servidor para que este le envie una respuesta
 *   (Response), este Request inicial puede ser de tipo GET o POST:
 *   
 *   	- GET
 *   		-> Envia la informacion utilizando la URL del navegador como vehiculo de transporte
 *   			(www.paginaweb.es?campo1=valor1&campo2=valor2&.....)	
 *   		-> Recomendable para hacer depuraciones
 *   		-> Limitaciones en cuanto a la cantidad de datos a enviar
 *   		-> Se puede guardar en favoritos o enviar la URL a alguien
 *   	
 *   	- POST
 *   		-> Se envia la info de la peticion utilizando el objeto Request como vehiculo de transporte
 *   		-> Util para enviar gran cantidad de informacion
 *   		-> Capacidad de enviar datos adjuntos, datos binarios.
 *   
 **********************************************************************************************************/


package es.pildorasinformaticas.servletpruebas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControladorServlet_114_I
 */
@WebServlet("/ControladorServlet_114_I")
public class ControladorServlet_114_I extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorServlet_114_I() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String [] productos={"Destornillador", "Serrucho", "Tornillo", "Taladro"}; //Información que proporcionaría la BBDD y la guardamos en un String
		
		request.setAttribute("lista_productos", productos); //Almacenamos tambien en el request esa infromacion
		
		RequestDispatcher miDispatcher=request.getRequestDispatcher("/VistaJSP_114_II.jsp"); //creamos el objeto RequestDispatcher(miDispatcher) para poder comunicar con JSP y enviarle la informacion
		
		miDispatcher.forward(request, response); //enviamos la info a JSP (VistaJSP_114_II)con foward
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
