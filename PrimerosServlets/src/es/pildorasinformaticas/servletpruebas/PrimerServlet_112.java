package es.pildorasinformaticas.servletpruebas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimerServlet_112
 */
@WebServlet("/PrimerServlet_112")
public class PrimerServlet_112 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimerServlet_112() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Especificamos formato de respuesta
		
		PrintWriter salida=response.getWriter();
		
		//Generamos la respuesta de la peticion
		
		salida.println("<html><body>");
		
		salida.println("<h1 style='text-align:center'> Prueba Servlet</h1>");
		
		salida.println("");
		salida.println("");
		salida.println("");
		salida.println("");

		salida.println("Fecha y hora actual: " + new Date());
		
		salida.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
