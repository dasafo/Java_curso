<!-- 
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
 -->
 <!-- 
 *************************************Ejercicio***************************************
 
 1- Crear formulario HTML que envie al servidor informacion 
 2- JSP lea los datos del formulario y cree una cookie
 3- Que la web lea la cookie generada por el JSP y muestre el contenido personalizado
 
 *************************************************************************************
  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agencia Viajes</title>
</head>
<body>
<form action="RecibePeticion_108_II.jsp">

Selecciona tu ciudad de destino

<select name="ciudad_favorita">

	<option>Madrid</option>
	<option>Paris</option>	
	<option>Nueva_York</option>	
	<option>Sidney</option>

</select>
<br/><br/><br/>

<input type="submit" value="Enviar"/>


</form>


</body>
</html>