<!-- -------------------------------------- Servlets -------------------------------------------------
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
 * 				-> C_HttpServlet
 * 					-> M_ doGet(request,response) * Encargado de recibir la peticion (request)
 * 						.......
 * 
 * 			-> I_HttpServletResponse
 * 				-> I_ServletResponse
 * 					-> M_getWriter()	
 * 						-> C_PrintWriter()
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
---------------------------------------------------------------------------------------------------------->
<!--
***************************** Modelo, Vista, Controlador (MVC) ********************************

 - Un MVC es un patrón de diseño a la hora de crear aplicaciones de servidor Java

 - Consiste en separar la parte lógica de la parte visual en nuestros proyectos. 
   Para ello se integran los Servlets y JSP en nuestros ptoyectos para que trabajen juntos.
   
	-> Los Servlets se encargan de la parte lógica
	-> Los JSP se encargan de la parte visual	
	
 - Camino que sigue el modelo MVC:
 
	 1- El cliente manda una peticion(Request) al Servidor.
	 2- Dicha peticion llega al Servlet que se comunica con la BBDD
	 3- La BBDD proporciona los datos pedidos de vuelta al Servlet.
	 4- El Servlet pasa la info al JSP, que fabrica un archivo HTML
	 5- El JSP manda esta informacion en HTML al cliente.
	 
	 		Cliente -> Controlador (Servlet) -> Modelo (BBDD) -> 
	 		
	 		-> Controlador (Servlet) -> Vista (JSP)-> Cliente
	
 - El Servlet(Controlador) se comunica con el JSP (Vista) mediante:
 	
 		I_RequestDispatcher -> M_forward()
 
 - Ventajas del modelo MVC:
 
 	-> Elimina codigo HTML del Servlet (no mas println)
 	-> Elimina codigo Java en JSP (no mas scriplets)
 	-> Favorece el desarrollo por varios programadores
 	-> Favorece el matenimiento dle proyecto
 	-> Favorece la depuracion de los errores
 	-> Favorece la escalabilidad del proyecto
 	
********************************************************************************************
-->
<!--	
/******************************************************************************
 * 
 * Aqui veremos un ejemplo de comunicacion entre el Servlet y el JSP
 * 
 ******************************************************************************	
-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="tempProductos" items="${lista_productos}">
	
		${tempProductos}<br>
	
	
	
	</c:forEach>






</body>
</html>