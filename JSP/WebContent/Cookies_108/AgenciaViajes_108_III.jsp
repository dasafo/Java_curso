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
