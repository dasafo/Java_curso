<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.*"%>  <!-- para importar ese paquete desde java -->


<%
	
	String usuario=request.getParameter("usuario");
	
	String contra=request.getParameter("contra");
	
	
	//Class.forName("com.mysql.jdbc.Driver"); // le indicamos el Driver que tiene que cargar
	Class.forName("org.postgresql.Driver"); // le indicamos el Driver que tiene que cargar

	try{
	
	Connection miConexion=DriverManager.getConnection("jdbc:postgresql://localhost:5432/curso_bbdd", "pildoras", "freedom85");

	//Creamos Consultas preparadas para evitar la inyeccion SQL desde fuera
// Creamos el PreparedStatement con un ResultSet desplazable (scrollable)
        PreparedStatement c_preparada = miConexion.prepareStatement(
            "SELECT * FROM usuarios WHERE \"Usuario\"=? AND \"Contrasena\"=?", 
            ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_READ_ONLY
        );

	c_preparada.setString(1, usuario); 
	c_preparada.setString(2, contra);
	
	ResultSet miResultset=c_preparada.executeQuery();
	
	if(miResultset.absolute(1)){ //absolute mueve el cursor a la fila indicada(1). Para que se vaya al primer registro
		
		out.println("Usuario AUTORIZADO");
	}else{
		
		out.println("Usuario NO AUTORIZADO");
	}
} catch (SQLException e) {
		out.println("Error en la base de datos: " + e.getMessage()); // Mostrar mensaje detallado del error
		e.printStackTrace(); // Para obtener más detalles en el log de Tomcat
	} catch (Exception e) {
		out.println("Ha habido un error inesperado: " + e.getMessage());
		e.printStackTrace(); // Para obtener más detalles en el log de Tomcat
	}

	%>



</body>
</html>
