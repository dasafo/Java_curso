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
	
	
	Class.forName("com.mysql.jdbc.Driver"); // le indicamos el Driver que tiene que cargar
	
	try{
	
	Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp?useSSL=false", "root", "Kromosoma_85" );

	PreparedStatement c_preparada=miConexion.prepareStatement("SELECT * FROM usuarios WHERE Usuario=? AND Contrasena=?");
	
	c_preparada.setString(1, usuario);
	c_preparada.setString(2, contra);
	
	ResultSet miResultset=c_preparada.executeQuery();
	
	if(miResultset.absolute(1)){
		
		out.println("Usuario AUTORIZADO");
	}else{
		
		out.println("Usuario NO AUTORIZADO");
	}

	}catch(Exception e){
		
		out.println("Ha habido un error");
	}
%>



</body>
</html>