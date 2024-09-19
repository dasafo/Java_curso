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

	String nombre=request.getParameter("nombre");

	String apellido=request.getParameter("apellido");
	
	String usuario=request.getParameter("usuario");
	
	String contra=request.getParameter("contra");
	
	String pais=request.getParameter("pais");
	
	String tecno=request.getParameter("tecnologias");
	
  //este driver hay que guardarlo en la carpeta especifica dentro de Tomcat
	//Class.forName("com.mysql.jdbc.Driver"); // le indicamos el Driver que tiene que cargar
	Class.forName("org.postgresql.Driver"); // le indicamos el Driver que tiene que cargar
	
	try{
	
	Connection miConexion=DriverManager.getConnection("jdbc:postgresql://localhost:5432/curso_bbdd", "pildoras", "freedom85");

	Statement miStatement=miConexion.createStatement();
	

String instruccionSql = "INSERT INTO usuarios (\"Nombre\", \"Apellido\", \"Usuario\", \"Contrasena\", \"Pais\", \"Tecnologia\") VALUES ('"
    + nombre + "', '" + apellido + "', '" + usuario + "', '" + contra + "', '" + pais + "', '" + tecno + "')";

	miStatement.executeUpdate(instruccionSql);
	
	out.println("¡¡¡Registrado con ÉXITO!!!");

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
