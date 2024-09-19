<%-- 
*************************************** Cookies*************************************

- Una cookie es un archivo de texto que se almacena en el PC durante la navegacion

- Sirven para personalizar un sitio web basandose en las preferencias del usuario

- En las cookies se almacena el par Nombre-Valor:
	-> Nombre: Ciudad_origen_vuelo
	-> Valor: Madrid
	
- Tambien existen las llamadas Cookies de Terceros, cookies de anuncios de esa web,...

- Creacion de cookies (write):

	-> C_Cookie
		-> M_setMaxAge(int segundos) * Tiempo max de vida de la cookie en el PC
	-> I_HttpServeletResponse
		-> M_addCookie(Cookie lacookie)
		
- Lectura de cookies (read):

	-> I_HttpServletRequest
		-> M_getCookies()
	-> C_Cookie
		-> M_getValues()
		-> M_getName()	

M=Metodo, I_=Interface, C=Clase
*************************************************************************************
 --%>
 <%-- 
 *************************************Ejercicio***************************************
 
 1- Crear formulario HTML que envie al servidor informacion 
 2- JSP lea los datos del formulario y cree una cookie
 3- Que la web lea la cookie generada por el JSP y muestre el contenido personalizado
 
 *************************************************************************************
  --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//Leyendo datos del formulario
	String ciudad_favorita=request.getParameter("ciudad_favorita");

	//Crear la Cookie
	Cookie laCookie=new Cookie("agencia_viajes.ciudad_favorita", ciudad_favorita);
	
	//Tiempo de vida de la Cookie
	laCookie.setMaxAge(365*24*60*60);  //el argumento va en segundos(en este caso hemos puesto un año en segundos)
	
	//Enviar a Usuario la Cookie
	response.addCookie(laCookie);
	

%>

Gracias por enviar tus preferencias

<a href="AgenciaViajes_108_III.jsp">Ir a la agencia de viajes</a>



</body>
</html>
