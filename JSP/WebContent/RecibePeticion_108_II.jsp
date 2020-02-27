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