<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 style="text-align:center"> Agencia de viajes </h1>

<%
	
	//Valor por defecto
	String ciudad_favorita="Madrid";
	
	//Lee la Cookie de la petición del navegador
	
	Cookie[] lasCookies=request.getCookies();
	
	//Buscar las preferencias(la ciudad favorita)
	if(lasCookies!=null){
		
		for(Cookie cookie_temporal: lasCookies){ //recorre las cookies generadas
			
			if("agencia_viajes.ciudad_favorita".equals(cookie_temporal.getName())){ //si una cookie coincide con agencia_viajes.ciudad_favorita... 
				
				ciudad_favorita=cookie_temporal.getValue(); //me devuelves el Valor(REcordar que Cookie=Nombre+Valor)
			
				break;
			}
		}
		
	}
	
	
	

%>

<h3>Vuelos a <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>

<h3>Hoteles en <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>

<h3>Descuentos en restaurantes de <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>
<p>Esto es un texto de ejemplo</p>


</body>
</html>