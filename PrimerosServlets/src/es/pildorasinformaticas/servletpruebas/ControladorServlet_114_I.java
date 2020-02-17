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
