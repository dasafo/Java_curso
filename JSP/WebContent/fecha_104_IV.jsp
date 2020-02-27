<!-- 
 ************************* Objetos JSP Predefinidos **************************

- Los Principales:

	-> Request: Este objeto respresenta la peticion del cliente. Pertenece
				a I_javax.servlet.ServletRequest. Proporciona
				los datos recibidos vía formulario, GET/POST,...
				
	-> Response: Este objeto encapsula la respuesta por parte del servidor.
				 Perteneciente a I_javax.servlet.ServletResponse
				 
	-> Session: Este objeto proporciona una sesion unica para cada usuario.
				Perteneciente a I_javax.servlet.http.HttpSession
				
	-> Out: Este objeto proporciona recursos para escribir contenido en pagina 
	        web. Perteneciente a I_javax.servlet.jsp.JspWriter

I: Interfaz

******************************************************************************
 -->

Fecha: <%= new java.util.Date() %> 	<!-- Para que nos de la fecha actual -->