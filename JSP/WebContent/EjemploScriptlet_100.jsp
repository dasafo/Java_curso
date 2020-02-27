<!-- 
Tipo de codigo JSP:
 
	- Expresiones: 
			< %= expresion Java, una sola linea%>
			
	- Scriptlets: 
			< % varias lineas de codigo Java%>
			
	- Declaraciones:
		    < %! Declacion de variables o metodos %>
-->

<html>
<body>

<h1>

Ejemplo de Scriptlet

</h1>

<%

for(int i=0;i<10;i++){
	
	out.println("<br>Este es el mensaje " + i);
}

%>


</body>

</html>