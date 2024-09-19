<%-- 
************************************* Sesiones JSP *****************************************

- Las sesiones de usuario son creadas para seguir y memorizar las acciones de un 
usuario en un sitio web.

- Se usan en comercios virtuales, Banca online, paginas de certificaciones y examenes,..

- Cuando un usuario se registra en una web, en el Servidor se genera 
  un Objeto Session que nos permite acceder a información gracias a métodos como:
  
  	-> M_setAttribute(nombre, objeto) : Establece los datos que se memorizan en la sesion
  	-> M_getAttribute(nombre) : Devuelve el objeto que ha sido memorizado en esa sesion
  	-> M_isNew() : Para comprobar si una sesion es nueva o no
  	-> M_getId() : Para obtener el Id identificativo de cada sesion
  	-> M_invalidate() : Para borrar o resetear una sesion
  	-> M_setMaxInteractiveInterval(tiempo) : Tiempo que dura la sesion cuando esta inactiva 
  	.......
    Un ejemplo de uso de los primeros MEtodos sería setAttribute() que crea una carro 
    de la compra donde se van añadiendo cosas y getAttribute() devuelve el estado
    de ese carro de la compra si te has ido de la web y retornas, por ejemplo.
*********************************************************************************************
 --%>

<%@ page import="java.util.*" %>
<html>

<body>
  <%-- Vemos que apuntamos en action a este mismo archivo --%>
<form name="Formulario_Compra" action="/mi_proyecto/web/jsp/SesionCompra_107.jsp">
 
  <p>Artículos a comprar:</p>
  <p>
    <label>
      <input type="checkbox" name="articulos" value="agua " >
      Agua </label>
    <br>
    <label>
      <input type="checkbox" name="articulos" value="leche" >
      Leche </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="pan" >
      Pan </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="mazanas" >
      Manzanas </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="carne" >
      Carne </label>
      <br>
       <label>
      <input type="checkbox" name="articulos" value="pescado" >
      Pescado </label>
  </p>
  <p>
    <input type="submit" name="button" id="button" value="Enviar">
    <br>
  </p>
</form>

<h2>Carro de la compra:</h2>

<ul>

<%

//que se grabe en ListaElementos el objeto que se ha ido grabando previmente 
//en la sesión iniciada llamada 'misElementos'
	List<String> ListaElementos=(List<String>)session.getAttribute("misElementos"); 

//cuando se carga por primera vez misElementos en null, y por lo tanto cumple este if
//Pero cuando entra por segunda vez si el usuario ha seleccionado algo entraría igual,
//ya que la lista estaría de ListaElementos estaría vacia igual (machacaria la session)
//y es en esta segunda iteración donde se añadiria mas abajo en el String elementos los
//articulos añadidos anteriormente
//Ya las proximas iteraciones despues de dar a Enviar ListaElementos no seria null
//y pasaria ya directamente de este if
	if(ListaElementos==null){ 

		//creamos ListaElementos en un ArrayList cuando ListaElemntos esta vacio
		ListaElementos=new ArrayList<String>(); 
		
		//y acto seguido establece la sesion con el nombre de misElementos
		session.setAttribute("misElementos", ListaElementos); 
	}

  //Este String rescata los datos del formulario una vez el usuario presiona Enviar
 //getParameterValues sirve para recuperar valores dentro de un Array de tipo 
 //String, respecto a getParameter que solo nos devolvia el valor de un String
	String[] elementos=request.getParameterValues("articulos");	

  // Si los elementos es null es porque no ha presionado el usuario a Enviar aún,
  // entonces saltaria este if
  // O dicho de otra forma, si el Array de strings no esta vacio que entre en el if 
	if(elementos!=null){ 
		
		for(String elemTemp: elementos){ //recorre elementos y lo agrega a elemTemp
			
			//out.println("<li>" + elemTemp + "</li>"); //<li> es HTML y pone la viñeta circular    //mostramos en pabtalla lo seleccionado
			
			ListaElementos.add(elemTemp); 
      //va agregando los elementos de de elemTemp a ListaElementos
      //(para que no se borren cada vez que le damos a enviar)
		
		}
	}
	
	 //imprimimos lo que hay en el array ListaElementos
	for(String elemTemp: ListaElementos){
		
		out.println("<li>" + elemTemp + "</li>");
	}



%>


</ul>

</body>

</html>
