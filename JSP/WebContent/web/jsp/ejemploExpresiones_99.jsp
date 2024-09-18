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

Ejemlo de expresiones
</h1>


Convirtiendo a mayúsculas: <%= new String("David").toUpperCase()  %>

<br>

La suma de 5 y 7 es: <%= 5+7%>

<br>

10 es mayor que 100: <%= 10>100 %>

</body>

</html>