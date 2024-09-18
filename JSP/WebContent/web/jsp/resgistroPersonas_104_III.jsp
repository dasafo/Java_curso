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

<html>

<body>

<jsp:include page="formularioRegistro_104_I.html"></jsp:include> <br/><br/> <!-- Para incluir en esta pagina el formulario creado antes -->

Aquí iría el contenido de la web <br/>

Aquí iría el contenido de la web <br/>

Aquí iría el contenido de la web <br/>

Aquí iría el contenido de la web <br/>

Aquí iría el contenido de la web <br/>

<br/>

<jsp:include page="fecha_104_IV.jsp"></jsp:include> <br/><br/> <!-- Para incluir en esta pagina el formulario creado antes -->

</body>





</html>