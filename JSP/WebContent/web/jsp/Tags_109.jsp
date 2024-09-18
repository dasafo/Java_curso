<!-- 
****************************************JSP Tags******************************************

- Son librerias de etiquetas parecidas a los xml, utilizadas en paginas JSP
- Sirven para hacer mas simple la programacion, lectura, modificacion de
  paginas dinamicas JSP
- NO son imprescindibles pero si muy recomendables:
	-> Separan el codigo Java del codigo HTML
	-> Se integran limpiamente en el codigo HTML
	-> Minimizan el codigo en la web
	-> Hacen que el codigo dinamico sea reutilizable
	-> HAcen que el mantenimiento web sea sencillo

- Tipos de JSP Tags:

	-> JSP CustomsTags (Hechas por uno mismo)
	
	-> JSTL Standard Tag Library (librerias ya prefabricadas)
	
		Etiquetas:
			-> Core
				* Aglutinan las funcionalidades basicas de JSP
				* Bucles, condicionales....sintaxis basica de Java
			-> Formato
				* Aplican formato a elementos de dentro de JSP
				* Formato fecha, numero, moneda, internacionalizacion
			-> XML
				* Permite la manipulacion de vodigo XML en una web JSP
			-> SQL
				* Permite manipular BBDD desde paginas JSP.
					(No recomendado, mejor usando Beans)
					
		Pasos a seguir para usar los JSTL:
			1- Descargar la libreria JSTL
			2- Agregar la libreria al proyecto
			3- Importar la libreria en cada pagina JSP donde se use
				(< % taglib prefix="c" uri=http://java.sun.com/jsp/jstl/core %>)

******************************************************************************************
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Importamos la libreria, le decimos donde, y cual usamos 'c'(core) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%

	String alumnos[]={"Antonio", "Sandra", "María", "Paco"};

	pageContext.setAttribute("losAlumnos", alumnos);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Usamos la Tag de core con la etiqueta forEach -->
	<c:forEach var="tempAlumnos" items="${losAlumnos}">
	
		${tempAlumnos} <br/>
	
	


	</c:forEach>



</body>
</html>