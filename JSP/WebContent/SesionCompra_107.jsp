<!-- 
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
  	
*********************************************************************************************
 -->

<%@ page import="java.util.*" %>
<html>

<body>
<form name="Formulario_Compra" action="SesionCompra_107.jsp">
 
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

//que se grabe en ListaElementos el objeto que se ha ido grabando previmente en la sesión iniciada
	List<String> ListaElementos=(List<String>)session.getAttribute("misElementos"); 

	if(ListaElementos==null){ //cuando se carga por primera vez misElementos en null, y por lo tanto cumple este if
		
		//creamos ListaElementos en un ArrayList cuando ListaElemntos esta vacio
		ListaElementos=new ArrayList<String>(); 
		
		//y acto seguido establece la sesion con el nombre de misElementos
		session.setAttribute("misElementos", ListaElementos); 
	}

	String[] elementos=request.getParameterValues("articulos"); //rescata los artículos seleccionados una vez se pulsa el boton de enviar de un array
	
	// al prinicpio de sesion al no haber elementos señalados elementos=null, e ignora este bucle, 
	//el cual solo funciona cuando hay elementos seleccionados
	if(elementos!=null){ 
		
		for(String elemTemp: elementos){ //recorre elementos y lo agrega a elemTemp
			
			//out.println("<li>" + elemTemp + "</li>"); //<li> es HTML y pone la viñeta circular    //mostramos en pabtalla lo seleccionado
			
			ListaElementos.add(elemTemp); //va agregando los elementos de de elemTemp a ListaElementos(para que no se 
											// borren cada vez que le damos a enviar)
		
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