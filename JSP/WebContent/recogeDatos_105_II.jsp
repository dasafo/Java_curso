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
	
	Class.forName("com.mysql.jdbc.Driver"); // le indicamos el Driver que tiene que cargar
	
	try{
	
	Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?useSSL=false", "root", "Dasafo_8" );

	Statement miStatement=miConexion.createStatement();
	
	String instruccionSql="INSERT INTO usuarios (Nombre,Apellido, Usuario, Contrasena, Pais, Tecnologia) VALUES ('" + nombre + "', '" + apellido + "', '" + usuario + "', '" + contra + "', '" + pais + "', '" + tecno + "')";

	miStatement.executeUpdate(instruccionSql);
	
	out.println("¡¡¡Registrado con ÉXITO!!!");
	
	}catch(Exception e){
		
		out.println("Ha habido un error");
	}
%>



</body>
</html>