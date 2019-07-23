<html>

<body>


<h2>Usuarios Registrados</h2>

Usuario CONFIRMADO: <br/><br/>

Nombre: <%=request.getParameter("nombre") %> &nbsp; <!-- &nbsp; es espacio horizontal -->
Apellido: <%=request.getParameter("apellido") %>    

<br/>
<br/>

<jsp:include page="fecha_104_IV.jsp"></jsp:include> <br/><br/> 	<!-- Para incluir en esta pagina el formulario creado antes -->



</body>





</html>