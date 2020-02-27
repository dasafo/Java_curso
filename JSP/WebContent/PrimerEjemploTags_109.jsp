<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Importamos la libreria, le decimos donde, y cual usamos 'c'(core) -->

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

	<c:forEach var="tempAlumnos" items="${losAlumnos}">
	
		${tempAlumnos} <br/>
	
	


	</c:forEach>



</body>
</html>