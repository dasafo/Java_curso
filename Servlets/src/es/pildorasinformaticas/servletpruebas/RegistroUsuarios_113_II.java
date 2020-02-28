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
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroUsuarios_113_II
 */
@WebServlet("/RegistroUsuarios_113_II")
public class RegistroUsuarios_113_II extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuarios_113_II() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // ----------------Para info enviada tipo GET----------------------
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		PrintWriter salida=response.getWriter();
		
		salida.println("<html><body>");
		
		salida.println("Nombre introducido: " + request.getParameter("nombre"));
		salida.println("<br><br>");
		salida.println("Apellido introducido: " + request.getParameter("apellido"));
		
		salida.println("</body></html>");
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
    // ----------------Para info enviada tipo POST----------------------

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html"); //para indicarle que el texto será enviado en Html
		
		PrintWriter salida=response.getWriter();
		
		salida.println("<html><body>");
		
		salida.println("Nombre introducido: " + request.getParameter("nombre"));
		salida.println("<br><br>");
		salida.println("Apellido introducido: " + request.getParameter("apellido"));
		
		salida.println("</body></html>");
	}

}
