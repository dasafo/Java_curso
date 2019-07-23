<%@ page import="java.util.*" %>
<html>

<body>
<form name="Formulario_Compra" action="ListaCompra_107_I.jsp">
 
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

	List<String> ListaElementos=(List<String>)session.getAttribute("misElementos"); //que se grabe en ListaElementos el objeto que se ha ido grabando previmente en la sesión iniciada

	if(ListaElementos==null){ //cuando se carga por primera vez misElementos en null, y por lo tanto cumple este if
		
		ListaElementos=new ArrayList<String>(); //creamos ListaElementos en un ArrayList
		
		session.setAttribute("misElementos", ListaElementos); //y acto seguido establece la sesion con el nombre de misElementos
	}

	String[] elementos=request.getParameterValues("articulos"); //rescata los artículos seleccionados una vez se pulsa el boton de enviar
	
	
	if(elementos!=null){ // al prinicpio de sesion al no haber elementos señalados elementos=null, e ignora este bucle, el cual solo funciona cuando hay elementos seleccionados
		
		for(String elemTemp: elementos){ //recorre elementos y lo agrega a elemTemp
			
			//out.println("<li>" + elemTemp + "</li>"); //<li> es HTML y pone la viñeta circular    //mostramos en pabtalla lo seleccionado
			
			ListaElementos.add(elemTemp); //va agregando los elementos de de elemTemp a ListaElementos(para que no se borren cada vez que le damos a enviar)
		
		}
	}
	
	for(String elemTemp: ListaElementos){
		
		out.println("<li>" + elemTemp + "</li>");
	}



%>


</ul>

</body>

</html>