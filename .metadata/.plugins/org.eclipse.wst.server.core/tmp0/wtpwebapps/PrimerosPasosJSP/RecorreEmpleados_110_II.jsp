<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Importamos la libreria, le decimos donde, y cual usamos 'c'(core) -->
    
    <%@ page import="java.util.*, java.sql.*, pildorasinformaticas.com.jsptags.Empleado_110_I"  %>
    
    <%
    
    	ArrayList<Empleado_110_I> datos=new ArrayList<>();    
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	
    try{
    	
		Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp?useSSL=false", "root", "Kromosoma_85" );
		
		Statement miStatement=miConexion.createStatement();
		
		String instruccionSql="SELECT * FROM empleados";
		
		ResultSet rs=miStatement.executeQuery(instruccionSql);
		
		while(rs.next()){
			
			datos.add(new Empleado_110_I(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		}
		
		rs.close();
		
		miConexion.close();

    }catch(Exception e){
    	
    	out.println("Ha habido un error!!");
    }
    
    pageContext.setAttribute("losEmpleados", datos);
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

.cabecera{
	font-weight:bold;

}

</style>
</head>
<body>

<table border="1">

<tr class="cabecera"> <td>Nombre</td><td>Apellido</td><td>Puesto</td><td>Salario</td></tr>

<c:forEach var="EmpTemp" items="${losEmpleados}">

  
<tr>
	
	<td>${EmpTemp.nombre}</td><td> ${EmpTemp.apellido} </td><td>${EmpTemp.puesto}</td><td>
	
	 
	<!----------------------- Sumamos un bonus de 5000 para los que cobren menos de 40000 ---------------->
	<!-- 
	<c:if test="${EmpTemp.salario<40000}">
	
	${EmpTemp.salario+5000}
	
	</c:if>
	
	<c:if test="${EmpTemp.salario>=40000}">
	
	${EmpTemp.salario}
	
	</c:if> 
	--> 
	 <!--------------------------------------------------------------------------------------------->
	
	
	<!---------Hacemos lo mismo que con c:if pero con c:chose(que es como un switch-case) y sumamos 2000 al que este entre 40000 y 50000 otro bonus----------->
	<c:choose>
	
		<c:when test="${EmpTemp.salario<40000}">
		
			${EmpTemp.salario+5000}
		
		</c:when>
		
		<c:when test="${EmpTemp.salario>40000 && EmpTemp.salario<=50000}">
		
			${EmpTemp.salario+2000}
		
		</c:when>
		<c:otherwise>
		
			${EmpTemp.salario}
			
		</c:otherwise>
	
	
	</c:choose>
	<!--------------------------------------------------------------------------------------------->
	
	
	
	</td> 
</tr>


</c:forEach>

</table>



</body>
</html>